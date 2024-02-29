package com.gfa.orientationexampleexam2.services;

import com.gfa.orientationexampleexam2.models.Mentor;
import com.gfa.orientationexampleexam2.repositories.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MentorServiceImp implements MentorService{

    private final MentorRepository mentorRepository;

    @Autowired
    public MentorServiceImp(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    @Override
    public List<Mentor> getAllMentors() {
        return mentorRepository.findAll();
    }
}
