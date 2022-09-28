package edu.br.unoesc.app.controllers;

import edu.br.unoesc.app.dtos.ComandaDTO;
import edu.br.unoesc.app.services.ComandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comanda")
public class ComandaController {

    @Autowired
    ComandaService comandaService;

    @PostMapping("/")
    public ResponseEntity abrirComanda(@RequestBody ComandaDTO novaComandaDTO) {
        try {
            novaComandaDTO = comandaService.abrirComanda(novaComandaDTO);
            return ResponseEntity.ok(novaComandaDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
