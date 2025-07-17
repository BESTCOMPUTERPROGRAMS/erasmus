package com.example.demoasd.controller;

import com.example.demoasd.dto.ParticipantSimpleDTO;
import org.springframework.format.annotation.DateTimeFormat;
import com.example.demoasd.model.Participant;
import com.example.demoasd.repository.ParticipantRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/participants")
public class ParticipantController {

    private final ParticipantRepository repo;

    public ParticipantController(ParticipantRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Participant> getAll() {
        return repo.findAll();
    }

    @PutMapping("/{id}/present")
    public Participant markPresent(@PathVariable Integer id) {
        Optional<Participant> p = repo.findById(id);
        p.ifPresent(participant -> {
            participant.setPresent(true);
            participant.setDate(LocalDate.now());
            repo.save(participant);
        });
        return p.orElse(null);
    }

    @PutMapping("/{id}/absent")
    public Participant markAbsent(@PathVariable Integer id) {
        Optional<Participant> p = repo.findById(id);
        p.ifPresent(participant -> {
            participant.setPresent(false);
            participant.setDate(LocalDate.now());
            repo.save(participant);
        });
        return p.orElse(null);
    }
    @GetMapping("/date/{date}")
    public List<ParticipantSimpleDTO> getByDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {

        return repo.findByDate(date).stream()
                .map(p -> new ParticipantSimpleDTO(
                        p.getId(),
                        p.getName(),
                        p.getSurname(),
                        p.isPresent() ? "Present" : "Absent",
                        p.getScore()
                ))
                .toList();
    }
    @GetMapping("/score/{score}")
    public List<ParticipantSimpleDTO> getByScore(@PathVariable int score) {
        return repo.findByScore(score).stream()
                .map(p -> new ParticipantSimpleDTO(
                        p.getId(),
                        p.getName(),
                        p.getSurname(),
                        p.isPresent() ? "Present" : "Absent",
                        p.getScore()
                ))
                .toList();
    }
}