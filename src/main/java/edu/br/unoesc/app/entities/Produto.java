package edu.br.unoesc.app.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "produto")
public class Produto extends  EntidadeAbstrata {

    private String nome;

    private String descricao;

    private Double valor;

    private String categoria;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    //private List<Imagen> imagens;

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

    //public List<Imagen> getImagens() {
       // return imagens;
   // }

    //public void setImagens(List<Imagen> imagens) {
     //   this.imagens = imagens;
    //}
}
