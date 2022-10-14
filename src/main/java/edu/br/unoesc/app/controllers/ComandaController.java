package edu.br.unoesc.app.controllers;

import edu.br.unoesc.app.dtos.ComandaDTO;
import edu.br.unoesc.app.entities.Comanda;
import edu.br.unoesc.app.entities.Item;
import edu.br.unoesc.app.repositories.ComandaRepository;
import edu.br.unoesc.app.repositories.ItemRepository;
import edu.br.unoesc.app.services.ComandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ComandaController {

    @Autowired
    ComandaService comandaService;

    @Autowired
    ComandaRepository comandaRepository;

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/comanda")
    public ResponseEntity buscarTodasComandas() {
        return ResponseEntity.ok(comandaService.buscarTodasComandas());
    }

    @GetMapping("/comanda/{id}")
    public ResponseEntity<ComandaDTO> getComandaPorId(@PathVariable Long id) {
        ComandaDTO comandaDTO = comandaService.getComandaPorId(id);
        return new ResponseEntity<>(comandaDTO, HttpStatus.OK);
    }

    @PostMapping("/comanda")
    public ResponseEntity abrirComanda(@RequestBody ComandaDTO novaComandaDTO) {
        try {
            novaComandaDTO = comandaService.abrirComanda(novaComandaDTO);
            return ResponseEntity.ok(novaComandaDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/comanda/{id}")
    public ResponseEntity fecharComanda(@RequestBody ComandaDTO comandaDTO) {
        try {
            comandaDTO = comandaService.fecharComanda(comandaDTO);
            return ResponseEntity.ok(comandaDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
