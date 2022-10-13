package edu.br.unoesc.app.entities;

import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "Comanda")
public class Comanda extends EntidadeAbstrata {

    private Double valor;

    private LocalDateTime dataAbertura = LocalDateTime.now();

    private LocalDateTime dataFechamento = null;

    @ManyToOne
    @JoinColumn(nullable = false, name = "funcionario_id")
    private Funcionario funcionario;

    private long mesaId;

    private long empresaId;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDateTime dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public long getMesaId() {
        return mesaId;
    }

    public void setMesaId(long mesaId) {
        this.mesaId = mesaId;
    }

    public long getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(long empresaId) {
        this.empresaId = empresaId;
    }

    public void addItem(Item item) {

    }

}
