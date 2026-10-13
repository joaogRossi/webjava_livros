package com.livros.cadastro_livros.controller;

import com.livros.cadastro_livros.business.LivrosService;
import com.livros.cadastro_livros.infrastructure.entities.Livros;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor

public class LivrosController {

    private final LivrosService livrosService;

    @PostMapping
    public ResponseEntity<Void> salvarLivro(@RequestBody Livros livro){
        livrosService.salvarLivro(livro);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Livros> buscarLivroPorTitulo(@RequestParam String titulo){
        return ResponseEntity.ok(livrosService.buscarLivroPorTitulo(titulo));
    }

    @DeleteMapping
    public ResponseEntity<Void> excluirLivroPorTitulo(@RequestParam String titulo){
        livrosService.excluirLivroPorTitulo(titulo);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarLivroPorId(@RequestBody Livros livro,
                                                    @RequestParam Integer id) {
        livrosService.atualizarLivroPorId(id, livro);
        return ResponseEntity.ok().build();
    }
}