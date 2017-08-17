package br.com.daniel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.daniel.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	@Query("select c from Cliente c where c.email=:email")
	public Cliente buscarPorEmail(@Param("email") String email) ;
	
}
