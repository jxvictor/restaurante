package com.example.restaurante.controller;

import com.example.restaurante.model.Shopping;
import com.example.restaurante.service.ShoppingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/shopping", produces = "application/json")
public class ShoppingController {

    @Autowired
    ShoppingService shoppingService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Shopping>> obterPorId(@PathVariable Long id){
        try {
            return new ResponseEntity<>(shoppingService.findById(id), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    public ResponseEntity<Page<Shopping>> listarTodos(Pageable pageable){
        try
        {
            return new ResponseEntity<>(shoppingService.findAll(pageable), HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<Void> cadastrar(@RequestBody @Valid Shopping shopping){
        try {
            shoppingService.save(shopping);
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
            shoppingService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editar(@PathVariable(value="id") Long id, @RequestBody @Valid Shopping shopping) {
        Optional<Shopping> us = shoppingService.findById(id);
        try
        {
            shopping.setNome(us.get().getNome());
            shopping.setCnpj(us.get().getCnpj());
            shopping.setTelefone(us.get().getTelefone());
            shoppingService.save(shopping);
            return ResponseEntity.ok().build();
        }
        catch(Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
