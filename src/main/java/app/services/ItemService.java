package app.services;

import app.dtos.ItemDTO;
import app.entities.Item;
import app.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import static java.time.Period.*;

@Service
public class ItemService {

    public static final String MENSAGEM_Item_EXISTENTE = "Esse Item ja existe na base de dados";

    public static final String MENSAGEM_Item_NAO_EXISTE = "Esse Item nao existe na base de dados";

    public static final String MENSAGEM_NAO_PODE_ALTERAR_Item = "Não é possivel Alterar um Item que ultrapassou o prazo de alteração";

    public static final String MENSAGEM_CATEGORIA_NAO_EXISTE = "Categoria não existe na base de dados";

    public static final int PRAZO_EM_DIAS_PARA_ALTERACAO = 2;

    @Autowired
    ItemRepository itemRepository;

    public List<ItemDTO> listarTodos() {
        List<ItemDTO> ItemsDTO = new ArrayList<ItemDTO>();
        List<Item> items = itemRepository.findAll();
        items.forEach(item -> {
            ItemDTO itemDTO = new ItemDTO(item);
            ItemsDTO.add(itemDTO);
        });
        return ItemsDTO;
    }

    public ItemDTO buscaItemPorId(Long ItemId) {
        Item item = itemRepository.findById(ItemId);
        if (item == null)
            throw new RuntimeException(MENSAGEM_Item_NAO_EXISTE);
        ItemDTO itemDTO = new ItemDTO(item);
        return itemDTO;
    }

    public ItemDTO salvarNovoItem(ItemDTO itemDTO) {

        Item itemQueVaiSerGravado;

        if (itemDTO.getId() != null) {
            Item verificaSeExisteItem = itemRepository.findById(itemDTO.getId());
            if (verificaSeExisteItem != null)
                throw new RuntimeException(MENSAGEM_Item_EXISTENTE);

        }

        itemQueVaiSerGravado = new Item();

        return this.registrarItem(itemQueVaiSerGravado, itemDTO);
    }

    public ItemDTO atualizarItem(ItemDTO itemDTO) {

        if (itemDTO.getId() == null)
            throw new RuntimeException(MENSAGEM_Item_NAO_EXISTE);

        Item itemQueVaiSerAtualizado = itemRepository.findById(itemDTO.getId());

        if (itemQueVaiSerAtualizado == null) {
            throw new RuntimeException(MENSAGEM_Item_NAO_EXISTE);
        }

        boolean podeAlterar = this.validarAlteracaoItem(itemQueVaiSerAtualizado, PRAZO_EM_DIAS_PARA_ALTERACAO);

        if (podeAlterar) {

            itemQueVaiSerAtualizado.setDataAtualizacao(LocalDateTime.now());

            return this.registrarItem(itemQueVaiSerAtualizado, itemDTO);

        } else
            throw new RuntimeException(MENSAGEM_NAO_PODE_ALTERAR_Item);

    }

    public void deletarItem(Long ItemId) {

        Item itemQueVaiSerDeletado = itemRepository.findById(ItemId);

        if (itemQueVaiSerDeletado == null) {
            throw new RuntimeException(MENSAGEM_Item_NAO_EXISTE);
        }

        boolean podeAlterar = this.validarAlteracaoItem(itemQueVaiSerDeletado, PRAZO_EM_DIAS_PARA_ALTERACAO);

        if (podeAlterar) {

            itemQueVaiSerDeletado.setDataAtualizacao(LocalDateTime.now());

            this.itemRepository.delete(itemQueVaiSerDeletado);
        } else
            throw new RuntimeException(MENSAGEM_NAO_PODE_ALTERAR_Item);

    }

    private ItemDTO registrarItem(Item itemQueVaiSerGravado, ItemDTO itemDTO) {

        itemQueVaiSerGravado.setNome(itemDTO.getNome());
        itemQueVaiSerGravado.setDescricao(itemDTO.getDescricao());
        itemQueVaiSerGravado.setValor(itemDTO.getValor());
        itemQueVaiSerGravado.setCategoria(itemDTO.getCategoria());

        itemRepository.save(itemQueVaiSerGravado);
        itemDTO.setId(itemQueVaiSerGravado.getId());

        return itemDTO;
    }

    private boolean validarAlteracaoItem(Item item, int prazoEmDiasParaAlteracao) {

        Period diff = between(item.getDataCriacao().toLocalDate(),
                LocalDate.now());
        return (diff.getDays() <= prazoEmDiasParaAlteracao) ? true : false;

    }

}
