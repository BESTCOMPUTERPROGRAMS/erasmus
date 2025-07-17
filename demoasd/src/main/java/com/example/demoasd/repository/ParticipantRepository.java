package com.example.demoasd.repository;

import com.example.demoasd.model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {


    List<Participant> findByDate(LocalDate date);
    List<Participant> findByScore(int score);
}
