package com.example.restaurante.service;

import com.example.restaurante.model.Shopping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoppingService {
    @Autowired
    private ShoppingService shoppingService;

    public Optional<Shopping> findById(Long id) {
        return shoppingService.findById(id);
    }
    public Page<Shopping> findAll(Pageable pageable) {
        return shoppingService.findAll(pageable);
    }
    public void deleteById(Long id) {
        shoppingService.deleteById(id);
    }
    public void save(Shopping shopping) {
        shoppingService.save(shopping);
    }

}
