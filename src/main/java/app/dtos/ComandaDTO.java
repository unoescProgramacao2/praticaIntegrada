package app.dtos;

import java.time.LocalDateTime;
import app.entities.Comanda;

public class ComandaDTO {

    private Long id;

    private Double valor;

    private LocalDateTime dataFechamento;

    private Long funcionarioId;

    private Long mesaId;

    private Long empresaId;

    public ComandaDTO() {
        super();
    }

    public ComandaDTO(Comanda comanda) {
        super();
        if (comanda.getId() != null)
            this.id = comanda.getId();
        this.valor = comanda.getValor();
        this.dataFechamento = comanda.getDataFechamento();
        this.funcionarioId = comanda.getFuncionario().getId();
        this.mesaId = comanda.getMesaId();
        this.empresaId = comanda.getEmpresa().getId();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDateTime dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public Long getMesaId() {
        return mesaId;
    }

    public void setMesaId(Long mesaId) {
        this.mesaId = mesaId;
    }

    public Long getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(Long empresaId) {
        this.empresaId = empresaId;
    }

}
