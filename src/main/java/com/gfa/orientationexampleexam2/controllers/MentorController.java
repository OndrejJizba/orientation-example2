package com.gfa.orientationexampleexam2.controllers;

import com.gfa.orientationexampleexam2.models.Mentor;
import com.gfa.orientationexampleexam2.services.ClassAService;
import com.gfa.orientationexampleexam2.services.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MentorController {

    private final ClassAService classAService;
    private final MentorService mentorService;

    @Autowired
    public MentorController(ClassAService classAService, MentorService mentorService) {
        this.classAService = classAService;
        this.mentorService = mentorService;
    }

    @GetMapping("/api/mentors")
    public ResponseEntity<?> getMentors(@RequestParam String className) {
        if (className == null) {
            return ResponseEntity.status(400).build();
        } else {
            return ResponseEntity.status(200).body(mentorService.findByClassName(className));
        }
    }
}
