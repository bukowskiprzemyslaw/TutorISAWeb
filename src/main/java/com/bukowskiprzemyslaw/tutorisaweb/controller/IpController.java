package com.bukowskiprzemyslaw.tutorisaweb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IpController
{

    @GetMapping("ip")
    public String getIpAddress(HttpServletRequest request, Model model) {
        String ipAddress = request.getRemoteAddr();
        model.addAttribute("ipAddress", ipAddress);
        return "ip-address";
    }
}