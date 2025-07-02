package com.stciky.notes.api.v1.web;

import com.sticky_notes.core.services.NotesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/notes")
@Slf4j
@AllArgsConstructor
public class NotesController {

    private final NotesService notesService;

    public void getNotes(UUID id, UUID userId) {

    }

    public void deleteNotes(UUID id, UUID userId) {

    }

    public void addNotes(UUID id, UUID userId) {

    }

    public void updateNotes(UUID id, UUID userId) {

    }

}
