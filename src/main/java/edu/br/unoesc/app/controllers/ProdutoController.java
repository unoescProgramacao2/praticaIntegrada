package edu.br.unoesc.app.controllers;

import edu.br.unoesc.app.dtos.ProdutoDTO;
import edu.br.unoesc.app.entities.Produto;
import edu.br.unoesc.app.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;


    @GetMapping("/produto")
    public ResponseEntity buscarTodosProdutos() {
        List<ProdutoDTO> listaDeProdutos = produtoService.listarTodos();
        return ResponseEntity.ok(listaDeProdutos);
    }

    @GetMapping("/produto/{produtoId}")
    public ResponseEntity buscarProdutoPorId(@PathVariable Long produtoId) {
        try {
            ProdutoDTO produtoDTO = produtoService.buscaProdutoPorId(produtoId);
            return ResponseEntity.ok(produtoDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/produto")
    public ResponseEntity salvarNovoProduto(@RequestBody ProdutoDTO novoProdutoDTO) {
        try {
            novoProdutoDTO = produtoService.salvarNovoProduto(novoProdutoDTO);
            return ResponseEntity.ok(novoProdutoDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PatchMapping("/produto")
    public ResponseEntity atualizarProduto(@RequestBody ProdutoDTO produtoAtualizadoDTO) {
        try {
            produtoAtualizadoDTO = produtoService.atualizarProduto(produtoAtualizadoDTO);
            return ResponseEntity.ok(produtoAtualizadoDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/produto/{produtoId}")
    public ResponseEntity deletarProdutoPorId(@PathVariable Long produtoId) {
        try {
            produtoService.deletarProduto(produtoId);
            return ResponseEntity.ok("Deletado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


}
