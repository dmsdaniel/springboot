package com.example.demo.service;

import com.example.demo.model.Usuario;

public interface UserService {
	public Usuario findUserByEmail(String email);
	public void saveUser(Usuario user);
}