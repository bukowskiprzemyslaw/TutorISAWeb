package com.bukowskiprzemyslaw.tutorisaweb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

@Controller
public class IpController {

    @GetMapping("ip")
    public String getIpAddress(HttpServletRequest request, Model model) throws UnknownHostException, MalformedURLException {
        String ipAddress = request.getRemoteAddr();

        if (ipAddress.equalsIgnoreCase("0:0:0:0:0:0:0:1")) {
            try (
                    BufferedReader br = new BufferedReader(new InputStreamReader(new URL("https://checkip.amazonaws.com").openStream()));
            ) {
                ipAddress = br.readLine();
            } catch (Exception e) {
            }
        }

        model.addAttribute("ipAddress", ipAddress);
        return "ip-address";
    }

}