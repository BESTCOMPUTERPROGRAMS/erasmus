package com.example.demoasd.controller;

import com.example.demoasd.dto.NoteCreateRequest;
import com.example.demoasd.dto.NoteUpdateRequest;
import com.example.demoasd.model.Note;
import com.example.demoasd.service.NoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/notes")
@Tag(name = "Note Controller", description = "CRUD for Notes")
public class NoteController {

    private final NoteService service;

    public NoteController(NoteService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(summary = "Create a new note")
    public ResponseEntity<Note> create(@RequestBody NoteCreateRequest request) {
        Note created = service.createNote(request.getCreator(), request.getInformation());
        return ResponseEntity.ok(created);
    }

    @Operation(summary = "Get note by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable Long id) {
        Optional<Note> note = service.getById(id);
        return note.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a note by ID")
    public ResponseEntity<Note> update(
            @PathVariable Long id,
            @RequestBody NoteUpdateRequest request) {
        Optional<Note> updated = service.update(id, request.getCreator(), request.getInformation());
        return updated.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete a note by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = service.delete(id);
        return deleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
