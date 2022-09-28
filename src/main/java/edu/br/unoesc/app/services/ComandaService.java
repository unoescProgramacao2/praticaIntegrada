package edu.br.unoesc.app.services;

import edu.br.unoesc.app.dtos.ComandaDTO;
import edu.br.unoesc.app.entities.Comanda;
import edu.br.unoesc.app.repositories.ComandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComandaService {

    @Autowired
    ComandaRepository comandaRepository;

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
        comandaParaAbrir.setDataAbertura(comandaDTO.getDataAbertura());
        comandaParaAbrir.setDataFechamento(comandaDTO.getDataFechamento());
        comandaParaAbrir.setFuncionarioId(comandaDTO.getFuncionarioId());
        comandaParaAbrir.setMesaId(comandaDTO.getMesaId());
        comandaParaAbrir.setEmpresaId(comandaDTO.getEmpresaId());

        comandaRepository.save(comandaParaAbrir);
        comandaDTO.setId(comandaParaAbrir.getId());

        return comandaDTO;
    }

}
