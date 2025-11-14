package com.example.restaurante.service;

import com.example.restaurante.model.Cardapio;
import com.example.restaurante.repository.CardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CardapioService {

    @Autowired
    private CardapioRepository cardapioRepository;

    public Optional<Cardapio> findById(Long id) {
        return cardapioRepository.findById(id);
    }
    public Page<Cardapio> findAll(Pageable pageable) {
        return cardapioRepository.findAll(pageable);
    }
    public void deleteById(Long id) {
        cardapioRepository.deleteById(id);
    }
    public void save(Cardapio cardapio) {
        cardapioRepository.save(cardapio);
    }
}
