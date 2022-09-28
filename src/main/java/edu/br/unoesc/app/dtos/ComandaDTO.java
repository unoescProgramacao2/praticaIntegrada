package edu.br.unoesc.app.dtos;

import edu.br.unoesc.app.entities.Comanda;

public class ComandaDTO {

    private Long id;

    private Double valor;

    private String dataAbertura;

    private String dataFechamento;

    private long funcionarioId;

    private long mesaId;

    private long empresaId;

    public ComandaDTO() {
        super();
    }

    public ComandaDTO(Comanda comanda) {
        super();
        if (comanda.getId() != null)
            this.id = comanda.getId();
        this.valor = comanda.getValor();
        this.dataAbertura = comanda.getDataAbertura();
        this.dataFechamento = comanda.getDataFechamento();
        this.funcionarioId = comanda.getFuncionarioId();
        this.mesaId = comanda.getMesaId();
        this.empresaId = comanda.getEmpresaId();

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

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(String dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public long getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(long funcionarioId) {
        this.funcionarioId = funcionarioId;
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

}
