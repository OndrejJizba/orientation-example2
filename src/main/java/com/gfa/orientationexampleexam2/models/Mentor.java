package com.gfa.orientationexampleexam2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Mentor {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn (name = "class_id")
    @JsonIgnore
    private ClassA classA;

    public Mentor(String name) {
        this.name = name;
    }
}
