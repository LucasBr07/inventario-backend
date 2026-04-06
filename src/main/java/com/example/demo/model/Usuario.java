package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbUsuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usuario_id;

    private String nome;
    private String login;
    private String senha;

    public Integer getUsuario_id() { return usuario_id; }
    public void setUsuario_id(Integer id) { this.usuario_id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}