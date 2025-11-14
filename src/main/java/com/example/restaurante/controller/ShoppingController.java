package com.example.restaurante.controller;

import com.example.restaurante.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/shopping", produces = "application/json")
public class ShoppingController {

    @Autowired
    ShoppingService shoppingService;

}
