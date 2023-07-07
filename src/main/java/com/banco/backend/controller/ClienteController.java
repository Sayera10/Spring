package com.banco.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.banco.backend.model.Cliente;
import com.banco.backend.model.Gestor;
import com.banco.backend.service.ClienteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<Cliente> findAll() {
		return clienteService.findAll();
	}

	@GetMapping("/{id}")
	public Cliente findById(@PathVariable Long id) {
		return clienteService.findById(id);
	}

	@PostMapping
	public Cliente save(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}

	@PutMapping
	public Cliente update(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		clienteService.deleteById(id);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Cliente> login(@RequestBody Cliente cliente) {
		Optional<Cliente> optCliente = clienteService.findbyCorreoAndPassword(cliente.getCorreo(), cliente.getPassword());
		if (optCliente.isPresent()) {
			return ResponseEntity.ok(optCliente.get());
		} else {
			return ResponseEntity.status(401).build();
		}
	}
}