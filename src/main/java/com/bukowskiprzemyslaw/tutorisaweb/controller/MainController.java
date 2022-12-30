package com.bukowskiprzemyslaw.tutorisaweb.controller;

import com.bukowskiprzemyslaw.tutorisaweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}