package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import app.dtos.OrdemDTO;
import app.services.OrdemService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class OrdemController {

    @Autowired
    OrdemService ordemService;

    @PostMapping("/ordem")
    public ResponseEntity criarOrdem(@RequestBody OrdemDTO novaOrdemDTO) {
        try {
            novaOrdemDTO = ordemService.criarOrdem(novaOrdemDTO);
            return ResponseEntity.ok(novaOrdemDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/ordem")
    public ResponseEntity buscarTodasOrdens() {
        try {
            List<OrdemDTO> listaDeOrdens = ordemService.listarTodas();
            return ResponseEntity.ok(listaDeOrdens);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/ordem/{ordemId}")
    public ResponseEntity buscarOrdemPorId(@PathVariable Long ordemId) {
        try {
            OrdemDTO ordemDTO = ordemService.buscaOrdemPorId(ordemId);
            return ResponseEntity.ok(ordemDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/ordem/{ordemId}")
    public ResponseEntity deletarItemPorId(@PathVariable Long ordemId) {
        try {
            ordemService.deletarOrdem(ordemId);
            return ResponseEntity.ok("Deletado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/comanda/{comandaId}/ordem")
    public ResponseEntity buscarOrdensPorComanda(@PathVariable Long comandaId) {
        try {
            List<OrdemDTO> listaDeOrdens = ordemService.buscarOrdensPorComanda(comandaId);
            return ResponseEntity.ok(listaDeOrdens);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
