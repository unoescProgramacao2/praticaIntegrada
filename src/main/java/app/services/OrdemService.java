package app.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import static java.time.Period.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dtos.OrdemDTO;
import app.entities.Ordem;
import app.entities.Comanda;
import app.entities.Item;
import app.repositories.ComandaRepository;
import app.repositories.ItemRepository;
import app.repositories.OrdemRepository;

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

    public List<OrdemDTO> listarTodas() {
        List<OrdemDTO> OrdensDTO = new ArrayList<OrdemDTO>();
        List<Ordem> ordens = ordemRepository.findAll();
        ordens.forEach(ordem -> {
            OrdemDTO ordemDTO = new OrdemDTO(ordem);
            OrdensDTO.add(ordemDTO);
        });
        return OrdensDTO;
    }

    public OrdemDTO buscaOrdemPorId(Long OrdemId) {
        Ordem ordem = ordemRepository.findById(OrdemId);
        if (ordem == null)
            throw new RuntimeException("Ordem não encontrada na base de dados");
        OrdemDTO ordemDTO = new OrdemDTO(ordem);
        return ordemDTO;
    }

    public void deletarOrdem(Long OrdemId) {

        Ordem ordemParaDeletar = ordemRepository.findById(OrdemId);

        if (ordemParaDeletar == null) {
            throw new RuntimeException("Ordem não encontrada na base de dados");
        }

        boolean podeAlterar = this.validarAlteracaoOrdem(ordemParaDeletar, 2);

        if (podeAlterar) {

            ordemParaDeletar.setDataAtualizacao(LocalDateTime.now());

            this.ordemRepository.delete(ordemParaDeletar);
        } else
            throw new RuntimeException("Ordem não pode ser deletada");

    }

    private boolean validarAlteracaoOrdem(Ordem ordem, int prazoEmDiasParaAlteracao) {

        Period diff = between(ordem.getDataCriacao().toLocalDate(),
                LocalDate.now());
        return (diff.getDays() <= prazoEmDiasParaAlteracao) ? true : false;

    }
}
