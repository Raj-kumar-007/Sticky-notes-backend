package com.stciky.notes.core.services;

import com.stciky.notes.api.v1.web.model.ApiNotes;
import com.stciky.notes.core.component.NotesMapper;
import com.stciky.notes.core.dao.NotesDao;
import com.stciky.notes.core.model.Notes;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class NotesService {

    private final NotesDao notesDao;
    private final NotesMapper notesMapper;
    private final MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

    public void save(Notes note) {
        notesDao.save(note);
    }

    public ApiNotes getNoteById(UUID noteId, UUID userId) {
        var note = notesDao.getByNoteId(noteId, userId);
        return notesMapper.mapToApiNotes(note);
    }

    public List<Notes> getAll(UUID userId) {
        return notesDao.getAll(userId);
    }

    public void delete(UUID id, UUID userId) {
        notesDao.delete(id, userId);
    }
}
