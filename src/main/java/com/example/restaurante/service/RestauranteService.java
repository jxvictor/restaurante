package com.example.restaurante.service;

import com.example.restaurante.model.Restaurante;
import com.example.restaurante.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestauranteService {
    
    @Autowired
    private RestauranteRepository restauranteRepository;
    
    public Optional<Restaurante> findById(Long id) {
        return restauranteRepository.findById(id);
    }
    public Page<Restaurante> findAll(Pageable pageable) {
        return restauranteRepository.findAll(pageable);
    }
    public void deleteById(Long id) {
        restauranteRepository.deleteById(id);
    }
    public void save(Restaurante restaurante) {
        restauranteRepository.save(restaurante);
    }
}
