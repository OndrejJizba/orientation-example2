package com.gfa.orientationexampleexam2.services;

import com.gfa.orientationexampleexam2.models.ClassA;

import java.util.List;

public interface ClassAService {
    List<ClassA> getAllClasses();
    ClassA findById(Long id) throws Exception;
    boolean nameExist(String name);
}
