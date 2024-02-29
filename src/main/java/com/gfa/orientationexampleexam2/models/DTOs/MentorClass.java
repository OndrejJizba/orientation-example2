package com.gfa.orientationexampleexam2.models.DTOs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MentorClass {

    private String name;
    private String className;

    public MentorClass(String name, String className) {
        this.name = name;
        this.className = className;
    }
}
