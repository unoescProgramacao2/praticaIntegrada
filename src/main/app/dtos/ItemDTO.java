package edu.br.unoesc.app.dtos;

import edu.br.unoesc.app.entities.Item;


public class ItemDTO {

    private Long id;

    private String nome;

    private String descricao;

    private Double valor;

    private String categoria;

    public ItemDTO() {
        super();
    }

    public ItemDTO(Item item) {
        super();
        if (item.getId()!=null)
            this.id = item.getId();
        this.nome = item.getNome();
        this.descricao = item.getDescricao();
        this.valor = item.getValor();
        this.categoria = item.getCategoria();

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
