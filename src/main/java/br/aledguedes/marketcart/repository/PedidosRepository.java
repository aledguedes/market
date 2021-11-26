package br.aledguedes.marketcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.aledguedes.marketcart.domain.Pedidos;

public interface PedidosRepository extends JpaRepository<Pedidos, Integer> {

}
