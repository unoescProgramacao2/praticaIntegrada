package edu.br.unoesc.app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ordem")
public class OrdemController {

    @PostMapping("/")
    public ResponseEntity criarOrdem() {
        return ResponseEntity.ok(true);
    }

}
