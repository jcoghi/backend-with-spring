package com.example.testeAula;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@Controller
@ResponseBody
public class SaudacaoControlle {
	//Reposta padrão
	private static final String template = "Olá, %s!";
	// Variável que permite o incremento do long em múltiplas threads mais eficientemente
	private static AtomicLong counter = new AtomicLong();
	
	// Método para retornar a resposta
	@RequestMapping("/saudacao")
	public Saudacao saudacao(@RequestParam(value="name", defaultValue = "Wolrd") String name) {
		return new Saudacao(counter.incrementAndGet(), String.format(template, name));
	}
}
