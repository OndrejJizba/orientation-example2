package com.gfa.orientationexampleexam2.services;

import com.gfa.orientationexampleexam2.models.Mentor;
import com.gfa.orientationexampleexam2.repositories.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

    @Override
    public Mentor saveMentor(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    @Override
    public Mentor findById(Long id) throws Exception {
        return mentorRepository.findById(id).orElseThrow(() -> new Exception("Mentor not found."));
    }

    @Override
    public List<Mentor> findByClassName(String className) {
        return mentorRepository.findAll().stream().filter(m -> Objects.equals(m.getClassA().getName(), className)).toList();
    }
}
