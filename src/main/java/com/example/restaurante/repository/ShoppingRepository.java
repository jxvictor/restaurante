package com.example.restaurante.repository;

import com.example.restaurante.model.Shopping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingRepository extends CrudRepository<Shopping, Long> {

}
