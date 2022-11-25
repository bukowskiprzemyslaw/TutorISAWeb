package com.bukowskiprzemyslaw.tutorisaweb.controller;

import com.bukowskiprzemyslaw.tutorisaweb.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class PageController {

    @GetMapping("/index")
    public String getIndex() {
        return "";
    }

    @Autowired
    private TutorRepository tutorRepository;

    @GetMapping("/tutorlist")
    public ModelAndView getTutors() {
        ModelAndView mav = new ModelAndView("tutorlist");
        mav.addObject("tutors", tutorRepository.findAll());
        return mav;
    }

}
