package com.projeto.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.curso.entities.Order;
import com.projeto.curso.entities.User;

public interface OrderRepository extends JpaRepository<Order, Long> {
	
}
