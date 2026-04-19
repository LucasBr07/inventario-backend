package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*") // 🔥 libera acesso do frontend
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    // ✅ CADASTRAR USUÁRIO
    @PostMapping("/cadastrar")
    public Usuario cadastrar(@RequestBody Usuario user) {
        return repository.save(user);
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario user) {
        return repository.findByLoginAndSenha(user.getLogin(), user.getSenha());
    }
}