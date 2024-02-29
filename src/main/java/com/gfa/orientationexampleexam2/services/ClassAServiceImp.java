package com.gfa.orientationexampleexam2.services;

import com.gfa.orientationexampleexam2.repositories.ClassARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassAServiceImp implements ClassAService{

    private final ClassARepository classARepository;

    @Autowired
    public ClassAServiceImp(ClassARepository classARepository) {
        this.classARepository = classARepository;
    }
}
