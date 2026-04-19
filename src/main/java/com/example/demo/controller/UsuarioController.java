package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/cadastrar")
    public Usuario cadastrar(@RequestBody Usuario user) {
        return repository.save(user);
    }

    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario user) {
        return repository.findByLoginAndSenha(user.getLogin(), user.getSenha());
    }

    // 🔥 ESSENCIAL PRA CORS
    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<?> handleOptions() {
        return ResponseEntity.ok().build();
    }
}