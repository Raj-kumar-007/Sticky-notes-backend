package com.stciky.notes.core.dao;

import com.stciky.notes.BaseIntegrationTest;
import com.stciky.notes.core.model.Notes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static java.util.UUID.fromString;
import static org.assertj.core.api.Assertions.assertThat;


class NotesDaoIntegrationTest extends BaseIntegrationTest {

    @Autowired
    private NotesDao dao;

    @Test
    void getByNoteId() {
        var noteId = fromString("83b7b7c9-a5ed-4f7a-b044-ce79d3dc748a");
        assertThat(dao.getByNoteId(noteId))
                .extracting(Notes::getUserId)
                .isEqualTo(fromString("6ef449b3-6c57-4863-8185-6448e769330b"));
    }

    @Test
    void save() {
    }
}