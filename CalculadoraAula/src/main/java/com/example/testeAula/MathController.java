package com.example.testeAula;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value="/soma/{num1}/{num2}", method = RequestMethod.GET)
	public Double soma(@PathVariable(value = "num1") String num1, @PathVariable(value = "num2") String num2) {
		return Double.parseDouble(num1) + Double.parseDouble(num2);
	}
	
}
