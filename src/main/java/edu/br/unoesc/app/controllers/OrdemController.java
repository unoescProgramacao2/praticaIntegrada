package edu.br.unoesc.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import edu.br.unoesc.app.dtos.OrdemDTO;
import edu.br.unoesc.app.services.OrdemService;

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
        List<OrdemDTO> listaDeOrdens = ordemService.listarTodas();
        return ResponseEntity.ok(listaDeOrdens);
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

}
