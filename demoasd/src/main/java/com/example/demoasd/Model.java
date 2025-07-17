package com.example.demoasd;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "user")
@Entity
@EqualsAndHashCode
@Data
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;


    public Model() {}


    public Model(String name, String email) {
        this.name = name;
        this.email = email;
    }


    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
}
