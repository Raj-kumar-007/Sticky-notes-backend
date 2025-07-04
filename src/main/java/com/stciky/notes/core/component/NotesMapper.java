package com.stciky.notes.core.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stciky.notes.api.v1.web.model.ApiNotes;
import com.stciky.notes.core.model.Note;
import com.stciky.notes.core.model.Notes;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class NotesMapper {

    private final ObjectMapper mapper;

    public Notes mapToNotes(ApiNotes apiNotes){
        return new Notes(apiNotes.id(), apiNotes.userId(), apiNotes.notes());
    }
    public ApiNotes mapToApiNotes(Notes notes){ return new ApiNotes(notes.getId(), notes.getUserId(), notes.getNote());}

    @SneakyThrows
    public Note mapContentToNotes(String content){
        return mapper.readValue(content, Note.class);
    }
}
