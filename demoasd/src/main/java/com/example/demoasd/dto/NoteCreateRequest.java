package com.example.demoasd.dto;

import lombok.Data;

@Data
public class NoteCreateRequest {
    private String creator;
    private String information;
}
