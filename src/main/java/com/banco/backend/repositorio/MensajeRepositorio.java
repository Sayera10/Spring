package com.banco.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banco.backend.model.Mensaje;



public interface MensajeRepositorio extends JpaRepository<Mensaje, Long> {
}