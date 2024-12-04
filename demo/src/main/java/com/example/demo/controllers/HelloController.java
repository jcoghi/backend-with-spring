package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
//Começa por aqui
@Controller
public class HelloController {
	// o / é o path do método para renderizar na tela
	/*
	@GetMapping("/hello")
	public String hello() {
		// procura o hello.html dentro da pasta template
		return "hello";
	}
	
	
	@GetMapping("/hello")
	public String hello(HttpServletRequest request) {
		request.setAttribute("nome", "João");
		// procura o hello.html dentro da pasta template
		return "hello";
	}
	
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("nome", "João");
		// procura o hello.html dentro da pasta template
		return "hello";
	}
	*/
	
	@GetMapping("/hello")
	// Trata requisições e levar para a view
	public ModelAndView hello() {
		ModelAndView mv = new ModelAndView("hello");
		mv.addObject("nome", "João");
		// procura o hello.html dentro da pasta template
		return mv;
	}
	
	
}
