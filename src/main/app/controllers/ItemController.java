package edu.br.unoesc.app.controllers;

import edu.br.unoesc.app.dtos.ItemDTO;
import edu.br.unoesc.app.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    ItemService itemService;


    @GetMapping("/item")
    public ResponseEntity buscarTodosItems() {
        List<ItemDTO> listaDeItems = itemService.listarTodos();
        return ResponseEntity.ok(listaDeItems);
    }

    @GetMapping("/item/{itemId}")
    public ResponseEntity buscarItemPorId(@PathVariable Long itemId) {
        try {
            ItemDTO itemDTO = itemService.buscaItemPorId(itemId);
            return ResponseEntity.ok(itemDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/item")
    public ResponseEntity salvarNovoItem(@RequestBody ItemDTO novoItemDTO) {
        try {
            novoItemDTO = itemService.salvarNovoItem(novoItemDTO);
            return ResponseEntity.ok(novoItemDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PatchMapping("/item")
    public ResponseEntity atualizarItem(@RequestBody ItemDTO itemAtualizadoDTO) {
        try {
            itemAtualizadoDTO = itemService.atualizarItem(itemAtualizadoDTO);
            return ResponseEntity.ok(itemAtualizadoDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/item/{itemId}")
    public ResponseEntity deletarItemPorId(@PathVariable Long itemId) {
        try {
            itemService.deletarItem(itemId);
            return ResponseEntity.ok("Deletado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


}
