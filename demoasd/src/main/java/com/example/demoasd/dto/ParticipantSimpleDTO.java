package com.example.demoasd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParticipantSimpleDTO {
    private Integer id;
    private String name;
    private String surname;
    private String status;
    private int score;
}
