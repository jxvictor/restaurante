package com.example.restaurante.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class Restaurante implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cnpj;
    private String nomeFantasia;
    private String razaoSocial;

    @OneToMany
    Categoria categoria;

    @OneToMany
    Item item;

}
