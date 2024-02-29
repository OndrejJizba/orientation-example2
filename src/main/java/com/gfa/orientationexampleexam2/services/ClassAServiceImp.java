package com.gfa.orientationexampleexam2.services;

import com.gfa.orientationexampleexam2.models.ClassA;
import com.gfa.orientationexampleexam2.repositories.ClassARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassAServiceImp implements ClassAService{

    private final ClassARepository classARepository;

    @Autowired
    public ClassAServiceImp(ClassARepository classARepository) {
        this.classARepository = classARepository;
    }

    @Override
    public List<ClassA> getAllClasses() {
        return classARepository.findAll();
    }

    @Override
    public ClassA findById(Long id) throws Exception {
        return classARepository.findById(id).orElseThrow(() -> new Exception("Class not found."));
    }
}
