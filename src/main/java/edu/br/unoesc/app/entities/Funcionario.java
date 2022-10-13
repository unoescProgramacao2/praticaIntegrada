package edu.br.unoesc.app.entities;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "funcionarios")
public class Funcionario extends EntidadeAbstrata {

    private String nome;
    private String sobrenome;
    private String senha;
    private String usuario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}