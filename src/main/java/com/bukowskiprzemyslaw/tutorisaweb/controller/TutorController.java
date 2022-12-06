package com.bukowskiprzemyslaw.tutorisaweb.controller;

import com.bukowskiprzemyslaw.tutorisaweb.entity.Tutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller

public class TutorController {

    @GetMapping("/newtutor")
    public String showAddTutorForm(Tutor tutor) {
        return "add-tutor";
    }

    @PostMapping("/adduser")
    public String addTutor(@Valid Tutor tutor, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-tutor";
        }

        tutorRepository.save(tutor);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showTutorList(Model model) {
        model.addAttribute("tutors", tutorRepository.findAll());
        return "index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateTutorForm(@PathVariable("id") long id, Model model) {
        Tutor tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nieprawidłowy numer Id trenera:" + id));

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

        tutorRepository.save(tutor);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteTutor(@PathVariable("id") long id, Model model) {
        Tutor tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Nieprawidłowy numer Id trenera:" + id));
        tutorRepository.delete(tutor);
        return "redirect:/index";
    }

}
