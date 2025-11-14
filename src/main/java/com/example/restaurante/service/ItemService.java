package com.example.restaurante.service;

import com.example.restaurante.model.Item;
import com.example.restaurante.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }
    public Page<Item> findAll(Pageable pageable) {
        return itemRepository.findAll(pageable);
    }
    public void deleteById(Long id) {
        itemRepository.deleteById(id);
    }
    public void save(Item item) {
        itemRepository.save(item);
    }
}
