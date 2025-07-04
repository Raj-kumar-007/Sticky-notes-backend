package com.stciky.notes.core.component;

import com.stciky.notes.api.v1.web.model.ApiNotes;
import com.stciky.notes.core.model.Notes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class NotesMapper {


    public Notes mapToNotes(ApiNotes apiNotes){
        return new Notes(apiNotes.id(), apiNotes.userId(), apiNotes.notes());
    }
}
