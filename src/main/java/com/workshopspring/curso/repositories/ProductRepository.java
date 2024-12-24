package com.workshopspring.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workshopspring.curso.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
