package com.livros.cadastro_livros.business;

import com.livros.cadastro_livros.infrastructure.entities.Livros;
import com.livros.cadastro_livros.infrastructure.repository.LivrosRepository;
import org.springframework.stereotype.Service;

@Service
public class LivrosService {

    private final LivrosRepository repository;

    public LivrosService(LivrosRepository repository) {
        this.repository = repository;
    }

    public void salvarLivro(Livros livro) {
        repository.saveAndFlush(livro);
    }

    public Livros buscarLivroPorTitulo(String titulo) {
        return repository.findByTitulo(titulo).orElseThrow(
                () -> new RuntimeException("Título não encontrado!")
        );
    }

    public void excluirLivroPorTitulo(String titulo) {
        repository.deleteByTitulo(titulo);
    }

    public void atualizarLivroPorId(Integer id, Livros livro) {
        Livros livroEntity = repository.findById(id).orElseThrow(() ->
                new RuntimeException("Livro não encontrado"));

        Livros livroAtualizado = Livros.builder()
                .titulo(livro.getTitulo() != null ? livro.getTitulo() :
                        livroEntity.getTitulo())
                .autor(livro.getAutor() != null ? livro.getAutor() :
                        livroEntity.getAutor())
                .anoPublicacao(livro.getAnoPublicacao() != null ? livro.getAnoPublicacao() :
                        livroEntity.getAnoPublicacao())
                .genero(livro.getGenero() != null ? livro.getGenero() :
                        livroEntity.getGenero())
                .preco(livro.getPreco() != null ? livro.getPreco() :
                        livroEntity.getPreco())
                .id(livroEntity.getId())
                .build();

        repository.saveAndFlush(livroAtualizado);
    }
}