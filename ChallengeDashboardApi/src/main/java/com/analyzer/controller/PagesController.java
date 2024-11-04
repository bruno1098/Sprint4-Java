package com.analyzer.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PagesController {

    @GetMapping("/req/login")
    public String login(){
        return "Login";
    }

    @GetMapping("/req/cadastro")
    public String cadastro(){
        return "Cadastro";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }



}


