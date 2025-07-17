package com.example.demoasd;

import com.example.demoasd.Model;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Model, Long> {
}
