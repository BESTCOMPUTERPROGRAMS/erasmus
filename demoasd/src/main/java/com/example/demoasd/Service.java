package com.example.demoasd;

import com.example.demoasd.Model;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@Slf4j
public class Service {

    private final Repository repo;

    public Service(Repository repo) {
        this.repo = repo;
    }

    public List<Model> getAllUsers() {;
        return repo.findAll();
    }

    public Optional<Model> getById(Long i) {
        return repo.findById(i);
    }
}