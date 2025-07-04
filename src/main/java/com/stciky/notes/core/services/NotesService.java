package com.stciky.notes.core.services;

import com.stciky.notes.core.dao.NotesDao;
import com.stciky.notes.core.model.Notes;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class NotesService {

    private final NotesDao notesDao;

    public void save(Notes note) {
        notesDao.save(note);
    }
}
