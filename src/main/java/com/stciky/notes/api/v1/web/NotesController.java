package com.stciky.notes.api.v1.web;

import com.stciky.notes.api.v1.web.model.ApiNotes;
import com.stciky.notes.core.component.NotesMapper;
import com.stciky.notes.core.services.NotesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/notes")
@Slf4j
@AllArgsConstructor
public class NotesController {

    private final NotesService notesService;
    private final NotesMapper notesMapper;
                       
    public void getAll(UUID userId) {

    }

    public void deleteNotes(UUID id, UUID userId) {

    }

    @PostMapping
    public void save(ApiNotes apiNotes) {
        notesService.save(notesMapper.mapToNotes(apiNotes));
    }

    public void updateNotes(UUID id, UUID userId) {

    }

}
