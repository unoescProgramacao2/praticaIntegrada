package app.controllers;

import app.dtos.FuncionarioDTO;
import app.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping("/funcionario")
    public ResponseEntity buscarTodosFuncionarios() {
        List<FuncionarioDTO> listaDeFuncionarios = funcionarioService.listarTodos();
        return ResponseEntity.ok(listaDeFuncionarios);
    }

    @GetMapping("/funcionario/{funcionarioId}")
    public ResponseEntity buscarFuncionarioPorId(@PathVariable Long funcionarioId) {
        try {
            FuncionarioDTO funcionarioDTO = funcionarioService.buscaFuncionarioPorId(funcionarioId);
            return ResponseEntity.ok(funcionarioDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/funcionario")
    public ResponseEntity salvarNovoFuncionario(@RequestBody FuncionarioDTO novoFuncionarioDTO) {
        try {
            novoFuncionarioDTO = funcionarioService.salvarNovoFuncionario(novoFuncionarioDTO);
            return ResponseEntity.ok(novoFuncionarioDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PatchMapping("/funcionario")
    public ResponseEntity atualizarFuncionario(@RequestBody FuncionarioDTO funcionarioAtualizadoDTO) {
        try {
            funcionarioAtualizadoDTO = funcionarioService.atualizarFuncionario(funcionarioAtualizadoDTO);
            return ResponseEntity.ok(funcionarioAtualizadoDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/funcionario/{funcionarioId}")
    public ResponseEntity deletarFuncionarioPorId(@PathVariable Long funcionarioId) {
        try {
            funcionarioService.deletarFuncionario(funcionarioId);
            return ResponseEntity.ok("Deletado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
