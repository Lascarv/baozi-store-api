package com.github.lascarv.baozistoreapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.lascarv.baozistoreapi.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
