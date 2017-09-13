package com.example.demo.ui.controller;

import com.example.demo.entity.User;
import com.example.demo.security.CustomUserDetails;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/secure")
    public String secure(Principal principal, Model model){
        User myuser = ((CustomUserDetails) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getUser();
        model.addAttribute("myuser", myuser);
        return "secure";
    }
}
