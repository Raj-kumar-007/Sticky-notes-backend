package com.stciky.notes.api.v1.web;

import com.stciky.notes.api.v1.web.model.ApiNotes;
import com.stciky.notes.core.component.NotesMapper;
import com.stciky.notes.core.services.NotesService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/notes")
@Slf4j
@AllArgsConstructor
public class NotesController {

    private final NotesService notesService;
    private final NotesMapper notesMapper;

    @GetMapping("/{userId}")
    public List<ApiNotes> getAllByUserId(@PathVariable("userId") UUID userId) {
        return notesService.getAll(userId)
                .stream().map(notesMapper::mapToApiNotes)
                .collect(Collectors.toList());
    }

    public ResponseEntity<ApiNotes> getNotes(@PathVariable UUID noteId, @PathVariable UUID userId) {
        return ResponseEntity.ok(notesService.getNoteById(noteId, userId));
    }

    @DeleteMapping("delete/{id}/{userId}")
    public void deleteNotes(@PathVariable UUID id, @PathVariable UUID userId) {
        notesService.delete(id, userId);
    }

    @PostMapping()
    public ResponseEntity<Object> save(@RequestBody ApiNotes apiNotes) {
        notesService.save(notesMapper.mapToNotes(apiNotes));
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{id}/{userId}")
    public void updateNotes(@PathVariable UUID id, @PathVariable UUID userId) {

    }

}
