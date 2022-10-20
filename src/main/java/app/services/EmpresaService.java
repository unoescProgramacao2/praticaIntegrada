package app.services;

import app.dtos.EmpresaDTO;
import app.entities.Empresa;
import app.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import static java.time.Period.*;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    public List<EmpresaDTO> listarTodos() {
        List<EmpresaDTO> EmpresaDTO = new ArrayList<EmpresaDTO>();
        List<Empresa> empresas = empresaRepository.findAll();
        empresas.forEach(empresa -> {
            EmpresaDTO empresaDTO = new EmpresaDTO(empresa);
            EmpresaDTO.add(empresaDTO);
        });
        return EmpresaDTO;
    }

    public EmpresaDTO buscaEmpresaPorId(Long empresaId) {
        Empresa empresa = empresaRepository.findById(empresaId);
        if (empresa == null)
            throw new RuntimeException("Empresa nao existe na base de dados");
        EmpresaDTO empresaDTO = new EmpresaDTO(empresa);
        return empresaDTO;
    }

    public EmpresaDTO salvarNovaEmpresa(EmpresaDTO empresaDTO) {

        Empresa empresaQueVaiSerGravada;

        if (empresaDTO.getId() != null) {
            Empresa empresaExistente = empresaRepository.findById(empresaDTO.getId());
            if (empresaExistente != null)
                throw new RuntimeException("Empresa ja existe na base de dados");

        }

        empresaQueVaiSerGravada = new Empresa();

        return this.registrarEmpresa(empresaQueVaiSerGravada, empresaDTO);
    }

    public EmpresaDTO atualizarEmpresa(EmpresaDTO empresaDTO) {

        if (empresaDTO.getId() == null)
            throw new RuntimeException("Empresa nao existe na base de dados");

        Empresa empresaQueVaiSerAtualizada = empresaRepository.findById(empresaDTO.getId());

        if (empresaQueVaiSerAtualizada == null) {
            throw new RuntimeException("Empresa nao existe na base de dados");
        }

        boolean podeAlterar = this.validarAlteracaoEmpresa(empresaQueVaiSerAtualizada,
                2);

        if (podeAlterar) {

            empresaQueVaiSerAtualizada.setDataAtualizacao(LocalDateTime.now());

            return this.registrarEmpresa(empresaQueVaiSerAtualizada, empresaDTO);

        } else
            throw new RuntimeException("Empresa nao pode ser alterado");

    }

    public void deletarEmpresa(Long empresaId) {

        Empresa empresaQueVaiSerDeletada = empresaRepository.findById(empresaId);

        if (empresaQueVaiSerDeletada == null) {
            throw new RuntimeException("Empresa não existe na base de dados");
        }

        boolean podeAlterar = this.validarAlteracaoEmpresa(empresaQueVaiSerDeletada,
                2);

        if (podeAlterar) {

            empresaQueVaiSerDeletada.setDataAtualizacao(LocalDateTime.now());

            this.empresaRepository.delete(empresaQueVaiSerDeletada);
        } else
            throw new RuntimeException("Empresa nao pode ser alterado");

    }

    private EmpresaDTO registrarEmpresa(Empresa empresaQueVaiSerGravada,
            EmpresaDTO empresaDTO) {

        empresaQueVaiSerGravada.setNomeFantasia(empresaDTO.getNomeFantasia());
        empresaQueVaiSerGravada.setRazaoSocial(empresaDTO.getRazaoSocial());
        empresaQueVaiSerGravada.setCNPJ(empresaDTO.getCNPJ());

        empresaRepository.save(empresaQueVaiSerGravada);
        empresaDTO.setId(empresaQueVaiSerGravada.getId());

        return empresaDTO;
    }

    private boolean validarAlteracaoEmpresa(Empresa empresa, int prazoEmDiasParaAlteracao) {

        Period diff = between(empresa.getDataCriacao().toLocalDate(),
                LocalDate.now());
        return (diff.getDays() <= prazoEmDiasParaAlteracao) ? true : false;

    }

}
