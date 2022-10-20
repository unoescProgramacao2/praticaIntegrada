package app.controllers;

import app.dtos.ComandaDTO;
import app.entities.Comanda;
import app.entities.Item;
import app.repositories.ComandaRepository;
import app.repositories.ItemRepository;
import app.services.ComandaService;
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

    @PatchMapping("/comanda")
    public ResponseEntity fecharComanda(@RequestBody ComandaDTO comandaDTO) {
        try {
            comandaDTO = comandaService.fecharComanda(comandaDTO);
            return ResponseEntity.ok(comandaDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/comanda/{comandaId}")
    public ResponseEntity deletarComandaPorId(@PathVariable Long comandaId) {
        try {
            comandaService.deletarComanda(comandaId);
            return ResponseEntity.ok("Deletado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
