package br.aledguedes.marketcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.aledguedes.marketcart.domain.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Integer>{

}
