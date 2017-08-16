package br.com.daniel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.daniel.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
