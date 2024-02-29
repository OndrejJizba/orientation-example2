package com.gfa.orientationexampleexam2.services;

import com.gfa.orientationexampleexam2.models.DTOs.MentorClass;
import com.gfa.orientationexampleexam2.models.Mentor;

import java.util.List;

public interface MentorService {
    List<Mentor> getAllMentors();
    Mentor saveMentor(Mentor mentor);
    Mentor findById(Long id) throws Exception;
    List<Mentor> findByClassName(String className);
    Mentor createMentor(String name, String className);
    boolean nameExist(String name);
}
