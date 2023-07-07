package com.banco.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banco.backend.model.Transferencia;
import com.banco.backend.repositorio.TransferenciaRepositorio;



@Service
public class TransferenciaService {

	@Autowired
	private TransferenciaRepositorio transferenciaRepository;

	public List<Transferencia> findAll() {
		return transferenciaRepository.findAll();
	}

	public Transferencia findById(Long id) {
		return transferenciaRepository.findById(id).orElse(null);
	}

	public Transferencia save(Transferencia transferencia) {
		return transferenciaRepository.save(transferencia);
	}

	public void deleteById(Long id) {
		transferenciaRepository.deleteById(id);
	}

	public List<Transferencia> getTransferenciasByClienteOrdenante(Long id) {
		return transferenciaRepository.findByOrdenanteId(id);
	}
}