package br.com.daniel.controller;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

import br.com.daniel.model.Cliente;

@Named
@ViewScoped
public class ClienteController {
	
	Cliente cliente = new Cliente();
	
	public void salvar() {
		
	}
	
}
