package com.example.cliente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cliente.model.Cliente;

public interface ClienteRespository extends JpaRepository<Cliente, Integer>{
	
	public Cliente findByEmail(String email);

}
