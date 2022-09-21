package edu.br.unoesc.app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bar")
public class DegustusBarController {

    public ResponseEntity abrirComanda(){
        return ResponseEntity.ok(true);

    }

    public ResponseEntity criarPedido(){
        return ResponseEntity.ok(true);
    }


}
