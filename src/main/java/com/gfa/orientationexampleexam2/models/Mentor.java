package com.gfa.orientationexampleexam2.models;

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
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn (name = "class_id")
    private ClassA classA;

    public Mentor(String name) {
        this.name = name;
    }
}
