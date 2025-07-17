package com.example.demoasd;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.spi.LoggerContextFactory;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/users")
public class Controller {
    private final Service service;
    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping
    @JsonSerialize
    public ResponseEntity<List<Model>> getUsers() {
        System.out.println(Arrays.toString(service.getAllUsers().toArray()) + "");
        return ResponseEntity.of(Optional.ofNullable(service.getAllUsers()));
    }
}