package com.gfa.orientationexampleexam2.controllers;

import com.gfa.orientationexampleexam2.models.DTOs.MentorClass;
import com.gfa.orientationexampleexam2.models.Mentor;
import com.gfa.orientationexampleexam2.services.ClassAService;
import com.gfa.orientationexampleexam2.services.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


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

    @PostMapping("/api/mentors")
    public ResponseEntity<?> createMentor(@RequestBody MentorClass mentorClass) {
        Map<String, Object> result = new HashMap<>();

        if (!classAService.nameExist(mentorClass.getClassName())) {
            result.put("message", "Class not found");
            return ResponseEntity.status(400).body(result);
        } else if (mentorService.nameExist(mentorClass.getName())) {
            result.put("message", "Mentor already exists");
            return ResponseEntity.status(400).body(result);
        } else {
            Mentor newMentor = mentorService.createMentor(mentorClass.getName(), mentorClass.getClassName());
            result.put("id", newMentor.getId());
            result.put("name", newMentor.getName());
            result.put("className", newMentor.getClassA().getName());
            return ResponseEntity.status(200).body(result);
        }
    }

    @PutMapping("/api/mentors/{mentorID}")
    public ResponseEntity<?> updateMentor(@RequestBody MentorClass mentorClass, @PathVariable Long mentorID) throws Exception {
        Map<String, String> result = new HashMap<>();

        if (!classAService.nameExist(mentorClass.getClassName())) {
            result.put("message", "Class not found");
            return ResponseEntity.status(400).body(result);
        } else if (mentorID > mentorService.getAllMentors().size()) {
            result.put("message", "Mentor not found");
            return ResponseEntity.status(404).body(result);
        } else {
            mentorService.updateMentor(mentorID, mentorClass.getName());
            result.put("name", mentorClass.getName());
            result.put("className", mentorClass.getClassName());
            return ResponseEntity.status(200).body(result);
        }
    }
}
