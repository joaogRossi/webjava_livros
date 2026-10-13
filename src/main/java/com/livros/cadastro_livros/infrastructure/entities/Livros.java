package com.livros.cadastro_livros.infrastructure.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "livros")
@Entity
public class Livros {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "titulo", unique = true, length = 200)
    private String titulo;

    @Column(name = "autor", length = 100)
    private String autor;

    @Column(name = "ano_publicacao")
    private Integer anoPublicacao;

    @Column(name = "genero", length = 100)
    private String genero;

    @Column(name = "preco")
    private Double preco;
}