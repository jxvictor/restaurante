package com.example.restaurante.controller;

import com.example.restaurante.model.Cardapio;
import com.example.restaurante.service.CardapioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/cardapio", produces = "application/json")
public class CardapioController {

    @Autowired
    private CardapioService cardapioService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cardapio>> obterPorId(@PathVariable Long id){
        try {
            return new ResponseEntity<>(cardapioService.findById(id), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<Page<Cardapio>> listarTodos(Pageable pageable){
        try
        {
            return new ResponseEntity<>(cardapioService.findAll(pageable), HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid Cardapio cardapio){
        try {
            cardapioService.save(cardapio);
            return ResponseEntity.ok().build();
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable long id){
        try
        {
            cardapioService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editar(@PathVariable(value="id") Long id, @RequestBody @Valid Cardapio cardapio) {
        Optional<Cardapio> us = cardapioService.findById(id);
        try
        {
            cardapio.setNome(us.get().getNome());
            cardapio.setDescricao(us.get().getDescricao());
            cardapioService.save(cardapio);
            return ResponseEntity.ok().build();
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
