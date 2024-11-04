package com.analyzer.controller;


import com.analyzer.model.Cadastro;
import com.analyzer.repository.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastroController {

    @Autowired
    private CadastroRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(value = "/req/cadastro", consumes = "application/json")
    public Cadastro createUser(@RequestBody Cadastro user){
        user.setSenha(passwordEncoder.encode(user.getSenha()));
        return repository.save(user);
    }


}
