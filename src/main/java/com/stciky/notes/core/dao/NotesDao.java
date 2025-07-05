package com.stciky.notes.core.dao;

import com.stciky.notes.core.component.NotesMapper;
import com.stciky.notes.core.model.Notes;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

@Repository
@AllArgsConstructor
public class NotesDao {

    private final NamedParameterJdbcTemplate jdbc;
    private final NotesMapper notesMapper;

    public List<Notes> getAll(UUID userId) {
        var sql = "SELECT * FROM notes where UserId = :userId";
        var params = new LinkedHashMap<String, Object>();
        params.put("userId", userId);
        return jdbc.query(sql, params, (rs, rowNum) -> notes(rs));
    }

    public Notes getByNoteId(UUID id, UUID userId) {
        var sql = "SELECT * FROM notes where Id = :id and UserId = :userId";
        var params = new LinkedHashMap<String, Object>();
        params.put("id", id);
        params.put("userId", userId);
        return jdbc.queryForObject(sql, params, (rs, rowNum) -> notes(rs));
    }

    private Notes notes(ResultSet rs) throws SQLException {
        return new Notes(rs.getObject("Id", UUID.class),
                rs.getObject("UserId", UUID.class),
                notesMapper.mapContentToNotes(rs.getString("Note")));
    }

    public void delete(UUID id, UUID userId) {
        var sql = "delete from notes where Id = :id and UserId = :userId";
        var params = new LinkedHashMap<String, Object>();
        params.put("id", id);
        params.put("userId", userId);
        jdbc.update(sql, params);
    }

    public void save(Notes notes) {
        var sql = "insert into notes (Id, UserId, Note) values (:id, :userId, :note)";
        var params = new LinkedHashMap<String, Object>();
        params.put("id", notes.getId());
        params.put("userId", notes.getUserId());
        params.put("note", notesMapper.mapContentToJson(notes.getNote()));
        jdbc.update(sql, params);
    }
}
