package com.stciky.notes.api.v1.web.model;

import java.util.UUID;

public record ApiNotes(UUID id, UUID userId, String notes) {
}
