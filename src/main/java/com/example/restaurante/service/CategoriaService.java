package com.example.restaurante.service;

import com.example.restaurante.model.Categoria;
import com.example.restaurante.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }
    public Page<Categoria> findAll(Pageable pageable) {
        return categoriaRepository.findAll(pageable);
    }
    public void deleteById(Long id) {
        categoriaRepository.deleteById(id);
    }
    public void save(Categoria categoria) {
        categoriaRepository.save(categoria);
    }
}
