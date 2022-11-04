package app.controllers;

import app.dtos.EmpresaDTO;
import app.services.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @GetMapping("/empresa")
    public ResponseEntity buscarTodasEmpresas() {
        List<EmpresaDTO> listaDeEmpresas = empresaService.listarTodos();
        return ResponseEntity.ok(listaDeEmpresas);
    }

    @GetMapping("/empresa/{empresaId}")
    public ResponseEntity buscarEmpresaPorId(@PathVariable Long empresaId) {
        try {
            EmpresaDTO empresaDTO = empresaService.buscaEmpresaPorId(empresaId);
            return ResponseEntity.ok(empresaDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/empresa")
    public ResponseEntity salvarNovaEmpresa(@RequestBody EmpresaDTO novaEmpresaDTO) {
        try {
            novaEmpresaDTO = empresaService.salvarNovaEmpresa(novaEmpresaDTO);
            return ResponseEntity.ok(novaEmpresaDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PatchMapping("/empresa")
    public ResponseEntity atualizarEmpresa(@RequestBody EmpresaDTO empresaAtualizadaDTO) {
        try {
            empresaAtualizadaDTO = empresaService.atualizarEmpresa(empresaAtualizadaDTO);
            return ResponseEntity.ok(empresaAtualizadaDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/empresa/{empresaId}")
    public ResponseEntity deletarEmpresaPorId(@PathVariable Long empresaId) {
        try {
            empresaService.deletarEmpresa(empresaId);
            return ResponseEntity.ok("Deletado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
