package com.example.cliente.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

// Verificação dos dados

public class ClienteDTO {
	@NotEmpty(message="Nome é obrigatório")
	private String nome;
	
	@NotEmpty(message="Nome é obrigatório")
	private String sobrenome;
	
	@NotEmpty(message="Nome é obrigatório")
	@Email
	private String email;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
