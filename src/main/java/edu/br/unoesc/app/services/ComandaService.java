package edu.br.unoesc.app.services;

import edu.br.unoesc.app.dtos.ComandaDTO;
import edu.br.unoesc.app.entities.Comanda;
import edu.br.unoesc.app.repositories.ComandaRepository;
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

        comandaParaAbrir.setValor(comandaDTO.getValor());
        comandaParaAbrir.setDataFechamento(comandaDTO.getDataFechamento());
        comandaParaAbrir.setFuncionarioId(comandaDTO.getFuncionarioId());
        comandaParaAbrir.setMesaId(comandaDTO.getMesaId());
        comandaParaAbrir.setEmpresaId(comandaDTO.getEmpresaId());

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
}
