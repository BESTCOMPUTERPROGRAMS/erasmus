package com.example.demoasd.service;

import com.example.demoasd.model.Note;
import com.example.demoasd.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository repository;

    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public Note createNote(String creator, String information) {
        Note note = new Note();
        note.setCreator(creator);
        note.setInformation(information);
        return repository.save(note);
    }


    public Optional<Note> getById(Long id) {
        return repository.findById(id);
    }
    public Optional<Note> update(Long id, String creator, String information) {
        return repository.findById(id).map(existing -> {
            existing.setCreator(creator);
            existing.setInformation(information);
            return repository.save(existing);
        });
    }

    public boolean delete(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }

}
