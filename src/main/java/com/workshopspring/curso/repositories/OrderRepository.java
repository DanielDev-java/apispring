package com.workshopspring.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workshopspring.curso.entities.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
