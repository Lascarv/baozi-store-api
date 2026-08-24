package com.github.lascarv.baozistoreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.lascarv.baozistoreapi.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
