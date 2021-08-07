package com.produtos.apirest.repository;

import com.produtos.apirest.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

// interface que estende o JpaRepository
// esse JpaRepository ja possui váris persistências como save, delete, find all;
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    // para buscar por id no ProdutoResource;
    Produto findById(long id);
}
