package com.stciky.notes.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class Note {
    private UUID id;
    private String note;
    private Colors color;
    private Positions position;
}
