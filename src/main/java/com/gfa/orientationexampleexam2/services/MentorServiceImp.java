package com.gfa.orientationexampleexam2.services;

import com.gfa.orientationexampleexam2.repositories.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MentorServiceImp implements MentorService{

    private final MentorRepository mentorRepository;

    @Autowired
    public MentorServiceImp(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }
}
