package edu.br.unoesc.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.br.unoesc.app.dtos.OrdemDTO;
import edu.br.unoesc.app.entities.Ordem;
import edu.br.unoesc.app.entities.Comanda;
import edu.br.unoesc.app.entities.Item;
import edu.br.unoesc.app.repositories.ComandaRepository;
import edu.br.unoesc.app.repositories.ItemRepository;
import edu.br.unoesc.app.repositories.OrdemRepository;

@Service
public class OrdemService {

    @Autowired
    OrdemRepository ordemRepository;

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ComandaRepository comandaRepository;

    public OrdemDTO criarOrdem(OrdemDTO ordemDTO) {

        Ordem ordemParaCriar;

        /*
         * if (itensComandaDTO.getId() != null) {
         * ItensComanda itensComandaExistente =
         * ordemRepository.findById(itensComandaDTO.getId());
         * if (itensComandaExistente != null) {
         * throw new RuntimeException("Ordem já existe");
         * }
         * }
         */

        ordemParaCriar = new Ordem();

        return this.registrarOrdem(ordemParaCriar, ordemDTO);
    }

    public OrdemDTO registrarOrdem(Ordem ordemParaCriar, OrdemDTO ordemDTO) {

        Item item = itemRepository.findById(ordemDTO.getItemId());
        Comanda comanda = comandaRepository.findById(ordemDTO.getComandaId());

        ordemParaCriar.setComanda(comanda);
        ordemParaCriar.setItem(item);

        ordemParaCriar.setQuantidade(ordemDTO.getQuantidade());
        ordemParaCriar.setId(ordemDTO.getId());

        ordemRepository.save(ordemParaCriar);

        return new OrdemDTO(ordemParaCriar);
    }
}
