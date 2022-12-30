package com.bukowskiprzemyslaw.tutorisaweb.controller;

import com.bukowskiprzemyslaw.tutorisaweb.entity.Tutor;
import com.bukowskiprzemyslaw.tutorisaweb.repository.TutorRepository;
import com.bukowskiprzemyslaw.tutorisaweb.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Properties;

@Controller

public class TutorController {

    @Autowired
    private TutorService tutorService;



    @GetMapping("/newtutor")
    public String showAddTutorForm(Tutor tutor) {
        return "add-tutor";
    }

    @PostMapping("/addtutor")
    public String addTutor(@Valid Tutor tutor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-tutor";
        }

        tutorService.saveTutor(tutor);
        return "redirect:/";
    }

    @GetMapping("/")
    public String showTutorList(Model model) {
        model.addAttribute("tutors", tutorService.fetchTutorList());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateTutorForm(@PathVariable("id") long id, Model model) {
        Tutor tutor = tutorService.fetchTutorById(id);

        model.addAttribute("tutor", tutor);
        return "update-tutor";
    }

    @PostMapping("/update/{id}")
    public String updateTutor(@PathVariable("id") long id, @Valid Tutor tutor,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            tutor.setId(id);
            return "update-tutor";
        }

        tutorService.saveTutor(tutor);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTutor(@PathVariable("id") long id, Model model) {
        Tutor tutor = tutorService.fetchTutorById(id);
        tutorService.deleteTutorById(id);
        return "redirect:/";
    }

}
