package com.example.cliente.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import com.example.cliente.model.Cliente;
import com.example.cliente.model.ClienteDTO;
import com.example.cliente.repository.ClienteRespository;

import jakarta.validation.Valid;

@Controller
//Vamos entrar neste controlador sempre que coloca "/cliente" no caminho URL
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRespository repo;

	// Mapeando a URL com "/clientes" ou "/clientes/", o método será invocado.
	@GetMapping({ "", "/" })
	public String getClientes(Model model) {
		// Criamos uma lista de clientes a partir dos dados do banco de dados;
		var clientes = repo.findAll(Sort.by(Sort.Direction.DESC, "id"));
		// Passamos essa lista para a página usando o nome clientes;
		model.addAttribute("clientes", clientes);

		return "clientes/index";
	}

	// Apenas para chamar o arquivo criar.html ao adicionar "/criar" na URL
	@GetMapping("/criar")
	public String criarCliente(Model model) {
		ClienteDTO cd = new ClienteDTO();
		model.addAttribute("cd", cd);
		return "clientes/criar";
	}

	// Verificando se o e-mail já existe no banco de dados
	@PostMapping("/criar")
	public String criarCliente(@Valid @ModelAttribute("cd") ClienteDTO cd,
			BindingResult result) {
		
		if (repo.findByEmail(cd.getEmail()) != null) {
			result.addError(new FieldError("cd", "email", cd.getEmail(), 
					false, null, null, "E-mail já cadastrado"));
			return "clientes/criar";
		}

		if (result.hasErrors()) {
			return "clientes/criar";
		}

		Cliente cliente = new Cliente();
		cliente.setNome(cd.getNome());
		cliente.setSobrenome(cd.getSobrenome());
		cliente.setEmail(cd.getEmail());
		cliente.setCriadoEm(new Date());

		repo.save(cliente);

		return "redirect:/clientes";
	}

	@GetMapping("/edit")
	public String editCliente(@RequestParam int id, Model model) {
		
		Cliente cliente = repo.findById(id).orElse(null);

		if (cliente == null) {
			return "redirect:/clientes";
		}

		ClienteDTO cd = new ClienteDTO();
		cd.setNome(cliente.getNome());
		cd.setSobrenome(cliente.getSobrenome());
		cd.setEmail(cliente.getEmail());
		model.addAttribute("cliente", cliente);
		model.addAttribute("cd", cd);

		return "clientes/edit";
	}

	@PostMapping("/edit")
	public String editCliente(@RequestParam int id, @Valid @ModelAttribute("cd") ClienteDTO cd, BindingResult result,
			Model model) {
		
		Cliente cliente = repo.findById(id).orElse(null);
		
		if (cliente == null) return "redirect:/clientes";
		
		model.addAttribute("cliente", cliente);
		
		if (result.hasErrors())	return "clientes/edit";
		
		cliente.setNome(cd.getNome());
		cliente.setSobrenome(cd.getSobrenome());
		cliente.setEmail(cd.getEmail());
		
		try {
			repo.save(cliente);
		} catch (Exception ex) {
			result.addError(new FieldError("cd", "email", cd.getEmail(), false, null, null, "E-mail já cadastrado"));
			return "clientes/edit";
		}
		return "redirect:/clientes";
	}
	
	@GetMapping("/delete")
	public String deleteCliente(@RequestParam int id) {
		
		Cliente cliente = repo.findById(id).orElse(null);
		
		if(cliente != null) {
			repo.delete(cliente); 
		}
		
		return "redirect:/clientes";
	}

}