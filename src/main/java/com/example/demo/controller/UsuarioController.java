package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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

        // LISTAR TODOS
    @GetMapping("/listar")
    public List<Usuario> listar() {
        return repository.findAll();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    // EDITAR
    @PutMapping("/{id}")
    public Usuario editar(@PathVariable Integer id, @RequestBody Usuario user) {
        user.setUsuario_id(id);
        return repository.save(user);
    }

    // EXCLUIR
    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}