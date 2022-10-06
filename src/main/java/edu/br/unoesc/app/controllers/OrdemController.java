package edu.br.unoesc.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.br.unoesc.app.dtos.OrdemDTO;
import edu.br.unoesc.app.services.OrdemService;

@RestController
@RequestMapping("/api/ordem")
public class OrdemController {

    @Autowired
    OrdemService ordemService;

    @PostMapping("/")
    public ResponseEntity criarOrdem(@RequestBody OrdemDTO novaOrdemDTO) {
        try {
            novaOrdemDTO = this.ordemService.criarOrdem(novaOrdemDTO);
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
