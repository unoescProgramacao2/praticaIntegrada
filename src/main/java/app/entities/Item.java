package app.entities;

import javax.persistence.*;

@Entity
@Table(name = "Itens")
public class Item extends EntidadeAbstrata {

    private String nome;

    private String descricao;

    private Double valor;

    private String categoria;

    private String imageUrl;

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

    @ManyToOne
    @JoinColumn(nullable = true, name = "empresa_id")
    private Empresa empresa;

    public Empresa getEmpresa() {

        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getUrl() {
        return imageUrl;
    }

    public void setUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
