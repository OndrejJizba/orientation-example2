package com.gfa.orientationexampleexam2.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ClassA {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ClassA> classList = new ArrayList<>();

    public ClassA(String name) {
        this.name = name;
    }
}
