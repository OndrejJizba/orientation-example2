package com.gfa.orientationexampleexam2.services;

import com.gfa.orientationexampleexam2.models.ClassA;
import com.gfa.orientationexampleexam2.models.Mentor;
import com.gfa.orientationexampleexam2.repositories.ClassARepository;
import com.gfa.orientationexampleexam2.repositories.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MentorServiceImp implements MentorService{

    private final MentorRepository mentorRepository;
    private final ClassARepository classARepository;

    @Autowired
    public MentorServiceImp(MentorRepository mentorRepository, ClassARepository classARepository) {
        this.mentorRepository = mentorRepository;
        this.classARepository = classARepository;
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
    @Override
    public Mentor createMentor(String name, String className){
        ClassA classA = classARepository.findByName(className);
        Mentor mentor = new Mentor(name);
        mentor.setClassA(classA);
        return mentorRepository.save(mentor);
    }

    @Override
    public boolean nameExist(String name) {
        return mentorRepository.findAll().stream().anyMatch(m -> Objects.equals(m.getName(), name));
    }

    @Override
    public Mentor updateMentor(Long id, String name) throws Exception {
        Mentor updatedMentor = mentorRepository.findById(id).orElseThrow(() -> new Exception("Mentor not found"));
        updatedMentor.setName(name);
        return mentorRepository.save(updatedMentor);
    }
}
