package com.bukowskiprzemyslaw.tracking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String tracking() {
        return "trackingindex";

    }
}
