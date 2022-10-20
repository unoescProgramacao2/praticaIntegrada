package edu.br.unoesc.app.dtos;

import edu.br.unoesc.app.entities.Empresa;

public class EmpresaDTO {

    private Long id;

    private String nomeFantasia;

    private String razaoSocial;

    private Long CNPJ;

    public EmpresaDTO() {
        super();
    }

    public EmpresaDTO(Empresa empresa) {
        super();
        if (empresa.getId() != null)
            this.id = empresa.getId();
        this.nomeFantasia = empresa.getNomeFantasia();
        this.razaoSocial = empresa.getRazaoSocial();
        this.CNPJ = empresa.getCNPJ();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Long getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(Long CNPJ) {
        this.CNPJ = CNPJ;
    }

}
