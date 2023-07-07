package com.banco.backend.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.backend.model.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
	Optional<Cliente> findByCorreoAndPassword(String correo, String Password);
}