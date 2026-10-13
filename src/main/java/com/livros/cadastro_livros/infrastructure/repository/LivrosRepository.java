package com.livros.cadastro_livros.infrastructure.repository;

import com.livros.cadastro_livros.infrastructure.entities.Livros;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LivrosRepository extends JpaRepository<Livros, Integer> {

    Optional<Livros> findByTitulo(String titulo);

    @Transactional
    void deleteByTitulo(String titulo);
}

