package com.example.demoasd.dto;

import lombok.Data;

@Data
public class CarCreateRequest {
    private String name;
    private int age;
    private int horsePower;
    private int basePrice;
}
