package br.aledguedes.marketcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.aledguedes.marketcart.domain.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
