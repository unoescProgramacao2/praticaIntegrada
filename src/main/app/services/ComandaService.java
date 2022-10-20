package edu.br.unoesc.app.services;

import edu.br.unoesc.app.dtos.ComandaDTO;
import edu.br.unoesc.app.entities.Comanda;
import edu.br.unoesc.app.entities.Empresa;
import edu.br.unoesc.app.entities.Funcionario;
import edu.br.unoesc.app.repositories.ComandaRepository;
import edu.br.unoesc.app.repositories.EmpresaRepository;
import edu.br.unoesc.app.repositories.FuncionarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import static java.time.Period.*;

@Service
public class ComandaService {

    @Autowired
    ComandaRepository comandaRepository;

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    EmpresaRepository empresaRepository;

    public List<ComandaDTO> buscarTodasComandas() {
        List<ComandaDTO> ComandasDTO = new ArrayList<ComandaDTO>();
        List<Comanda> comandas = comandaRepository.findAll();
        comandas.forEach(comanda -> {
            ComandaDTO comandaDTO = new ComandaDTO(comanda);
            ComandasDTO.add(comandaDTO);
        });
        return ComandasDTO;
    }

    public ComandaDTO getComandaPorId(Long id) {
        Comanda comanda = comandaRepository.findById(id);
        return new ComandaDTO(comanda);
    }

    public ComandaDTO abrirComanda(ComandaDTO comandaDTO) {

        Comanda comandaParaAbrir;

        if (comandaDTO.getId() != null) {
            Comanda comandaExistente = comandaRepository.findById(comandaDTO.getId());
            if (comandaExistente != null) {
                throw new RuntimeException("Comanda já existe");
            }
        }

        comandaParaAbrir = new Comanda();

        return this.registrarComanda(comandaParaAbrir, comandaDTO);
    }

    public ComandaDTO registrarComanda(Comanda comandaParaAbrir, ComandaDTO comandaDTO) {

        try {
            Funcionario funcionario = funcionarioRepository.findById(comandaDTO.getFuncionarioId());

            if (funcionario == null)
                throw new RuntimeException("Funcionario não existe na base de dados");

            comandaParaAbrir.setFuncionario(funcionario);

        } catch (Exception e) {
            throw new RuntimeException("Funcionario não existe na base de dados");
        }

        try {
            Empresa empresa = empresaRepository.findById(comandaDTO.getEmpresaId());

            if (empresa == null)
                throw new RuntimeException("Empresa não existe na base de dados");

            comandaParaAbrir.setEmpresa(empresa);

        } catch (Exception e) {
            throw new RuntimeException("Empresa não existe na base de dados");
        }

        comandaParaAbrir.setValor(comandaDTO.getValor());
        comandaParaAbrir.setDataFechamento(comandaDTO.getDataFechamento());
        comandaParaAbrir.setMesaId(comandaDTO.getMesaId());

        comandaRepository.save(comandaParaAbrir);
        comandaDTO.setId(comandaParaAbrir.getId());

        return comandaDTO;
    }

    public ComandaDTO fecharComanda(ComandaDTO comandaDTO) {

        Comanda comandaParaFechar = comandaRepository.findById(comandaDTO.getId());

        if (comandaParaFechar == null) {
            throw new RuntimeException("Comanda não existe");
        }

        comandaParaFechar.setDataFechamento(LocalDateTime.now());

        comandaRepository.save(comandaParaFechar);
        comandaDTO.setId(comandaParaFechar.getId());

        return comandaDTO;
    }

    public void deletarComanda(Long comandaId) {

        Comanda comandaParaDeletar = comandaRepository.findById(comandaId);

        if (comandaParaDeletar == null) {
            throw new RuntimeException("Comanda não encontrada na base de dados");
        }

        boolean podeAlterar = this.validarAlteracaoComanda(comandaParaDeletar, 2);

        if (podeAlterar) {

            comandaParaDeletar.setDataAtualizacao(LocalDateTime.now());

            this.comandaRepository.delete(comandaParaDeletar);
        } else
            throw new RuntimeException("Comanda não pode ser deletada");

    }

    private boolean validarAlteracaoComanda(Comanda comanda, int prazoEmDiasParaAlteracao) {

        Period diff = between(comanda.getDataCriacao().toLocalDate(),
                LocalDate.now());
        return (diff.getDays() <= prazoEmDiasParaAlteracao) ? true : false;

    }

}
