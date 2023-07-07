package com.banco.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.backend.model.Cliente;
import com.banco.backend.repositorio.ClienteRepositorio;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepositorio clienteRepository;

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente findById(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	public void deleteById(Long id) {
		clienteRepository.deleteById(id);
	}
	
	public Optional<Cliente> findbyCorreoAndPassword(String correo, String Password){
		return clienteRepository.findByCorreoAndPassword(correo, Password);
	}
}