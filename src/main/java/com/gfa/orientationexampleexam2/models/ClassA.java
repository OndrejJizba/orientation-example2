package com.gfa.orientationexampleexam2.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ClassA {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "classA")
    private Mentor mentor;

    public ClassA(String name) {
        this.name = name;
    }
}
