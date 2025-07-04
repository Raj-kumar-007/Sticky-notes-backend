package com.stciky.notes.api.v1.web.model;

import com.stciky.notes.core.model.Note;

import java.util.UUID;

public record ApiNotes(UUID id, UUID userId, Note notes) {
}
