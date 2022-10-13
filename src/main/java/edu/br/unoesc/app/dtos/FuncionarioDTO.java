package edu.br.unoesc.app.dtos;

import edu.br.unoesc.app.entities.Funcionario;

public class FuncionarioDTO {

    private Long id;

    private String nome;

    private String sobrenome;

    private String usuario;

    private String senha;

    public FuncionarioDTO() {
        super();
    }

    public FuncionarioDTO(Funcionario funcionario) {
        super();
        if (funcionario.getId() != null)
            this.id = funcionario.getId();
        this.nome = funcionario.getNome();
        this.sobrenome = funcionario.getSobrenome();
        this.usuario = funcionario.getUsuario();
        this.senha = funcionario.getSenha();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
