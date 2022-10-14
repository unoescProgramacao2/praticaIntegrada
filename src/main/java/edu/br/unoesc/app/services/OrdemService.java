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

        ordemParaCriar = new Ordem();

        return this.registrarOrdem(ordemParaCriar, ordemDTO);
    }

    public OrdemDTO registrarOrdem(Ordem ordemParaCriar, OrdemDTO ordemDTO) {

        Item item = itemRepository.findById(ordemDTO.getItemId());
        if (item == null)
            throw new RuntimeException("Item não existe");

        Comanda comanda = comandaRepository.findById(ordemDTO.getComandaId());
        if (comanda == null)
            throw new RuntimeException("Comanda não existe");

        ordemParaCriar.setComanda(comanda);
        ordemParaCriar.setItem(item);

        ordemParaCriar.setQuantidade(ordemDTO.getQuantidade());
        ordemParaCriar.setId(ordemDTO.getId());

        Double valorOrdem = ordemDTO.getQuantidade() * item.getValor();
        ordemParaCriar.setValor(valorOrdem);

        Double valorComanda = comanda.getValor() + valorOrdem;
        comanda.setValor(valorComanda);

        ordemRepository.save(ordemParaCriar);

        return new OrdemDTO(ordemParaCriar);
    }
}
