package app.entities;

import java.time.LocalDateTime;
import javax.persistence.*;

@Entity
@Table(name = "Comandas")
public class Comanda extends EntidadeAbstrata {

    private Double valor;

    private LocalDateTime dataAbertura = LocalDateTime.now();

    private LocalDateTime dataFechamento = null;

    @ManyToOne
    @JoinColumn(nullable = false, name = "funcionario_id")
    private Funcionario funcionario;

    private Long mesaId;

    @ManyToOne
    @JoinColumn(nullable = false, name = "empresa_id")
    private Empresa empresa;

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

    public Long getMesaId() {
        return mesaId;
    }

    public void setMesaId(Long mesaId) {
        this.mesaId = mesaId;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}
