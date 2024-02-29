package com.gfa.orientationexampleexam2.controllers;

import com.gfa.orientationexampleexam2.models.ClassA;
import com.gfa.orientationexampleexam2.models.Mentor;
import com.gfa.orientationexampleexam2.services.ClassAService;
import com.gfa.orientationexampleexam2.services.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/mentor")
    public String addMentor(@RequestParam String name, @RequestParam Long classId) throws Exception {
        Mentor mentor = new Mentor(name);
        ClassA selectedClass = classAService.findById(classId);
        mentor.setClassA(selectedClass);
        mentorService.saveMentor(mentor);
        return "redirect:/mentor/" + mentor.getId();
    }

    @GetMapping("/mentor/{id}")
    public String mentorDetail(@PathVariable Long id, Model model) throws Exception {
        try {
            Mentor mentor = mentorService.findById(id);
            model.addAttribute("name", mentor.getName());
            model.addAttribute("class", mentor.getClassA().getName());
            return "mentor";
        } catch (Exception e) {
        return "not-found";
        }
    }
}
