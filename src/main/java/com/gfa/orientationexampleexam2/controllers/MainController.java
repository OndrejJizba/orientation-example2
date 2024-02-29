package com.gfa.orientationexampleexam2.controllers;

import com.gfa.orientationexampleexam2.services.ClassAService;
import com.gfa.orientationexampleexam2.services.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private final ClassAService classAService;
    private final MentorService mentorService;

    @Autowired
    public MainController(ClassAService classAService, MentorService mentorService) {
        this.classAService = classAService;
        this.mentorService = mentorService;
    }

    @GetMapping("")
    public String mainPage(Model model){
        model.addAttribute("classes", classAService.getAllClasses());
        model.addAttribute("mentors", mentorService.getAllMentors());
        return "mainpage";
    }
}
