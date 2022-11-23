package com.bukowskiprzemyslaw.tutorisaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class PageController {

    @GetMapping("/index")
    public String getIndex() {
        return "";
    }

    @GetMapping("/tutorlist")
    public String getTutorlist() {
        return "tutorlist";
    }

}
