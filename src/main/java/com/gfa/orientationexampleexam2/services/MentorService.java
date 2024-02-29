package com.gfa.orientationexampleexam2.services;

import com.gfa.orientationexampleexam2.models.Mentor;

import java.util.List;

public interface MentorService {
    List<Mentor> getAllMentors();
    Mentor saveMentor(Mentor mentor);
}
