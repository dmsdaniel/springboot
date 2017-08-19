package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Usuario;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<Usuario, Long> {
	 Usuario findByEmail(String email);
}