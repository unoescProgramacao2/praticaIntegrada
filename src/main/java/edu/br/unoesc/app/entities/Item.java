package edu.br.unoesc.app.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "Item")
public class Item extends EntidadeAbstrata {

    private String nome;

    private String descricao;

    private Double valor;

    private String categoria;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, mappedBy = "itens")
    private Set<Comanda> comandas = new HashSet<>();

    @OneToMany(mappedBy = "Item", cascade = CascadeType.ALL)
    // private List<Imagen> imagens;

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

    public Set<Comanda> getComandas() {
        return comandas;
    }

    public void setTutorials(Set<Comanda> comandas) {
        this.comandas = comandas;
    }

    // public List<Imagen> getImagens() {
    // return imagens;
    // }

    // public void setImagens(List<Imagen> imagens) {
    // this.imagens = imagens;
    // }
}
