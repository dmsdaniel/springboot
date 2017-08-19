package br.com.daniel.repository;

import javax.persistence.EntityManager;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.daniel.model.Cliente;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class TestClienteRepository {
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired 
	private ClienteRepository clienteRepository;
	
	@Test
	public void testSalvar(){
		Cliente cli = new Cliente("Daniel","dmsdaniel@gmail.com");
		Cliente cliSalvo = clienteRepository.save(cli);
		Assert.assertNotNull(cliSalvo.getId());
	}
	
	@Test
	public void TestBuscarPorEmail() {
		Cliente cli = new Cliente("Daniel","dmsdaniel@gmail.com");
		entityManager.persist(cli);
		Cliente clienteEncontrado = clienteRepository.buscarPorEmail("dmsdaniel@gmail.com");
		assertThat(clienteEncontrado.getNome()).isEqualTo(cli.getNome());
		assertThat(clienteEncontrado.getEmail()).isEqualTo(cli.getEmail());
		
	}
	@Test
	public void TestBuscarTodos() {
		Cliente cli = new Cliente("Daniel","dmsdaniel@gmail.com");
		entityManager.persist(cli);
		
		Cliente cli2 = new Cliente("Daniel2","dmsdaniel2@gmail.com");
		entityManager.persist(cli2);
		
		List<Cliente> lista = clienteRepository.buscarTodos();
		assertThat(lista.get(0).getNome()).isEqualTo(cli.getNome());
		assertThat(lista.get(1).getNome()).isEqualTo(cli2.getNome());
		
		
	}
} 
