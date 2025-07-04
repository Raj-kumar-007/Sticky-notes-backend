package com.stciky.notes.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class Notes {
    UUID id;
    UUID userId;
    String note;
}
