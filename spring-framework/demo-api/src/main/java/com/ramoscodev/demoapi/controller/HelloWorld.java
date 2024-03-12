package com.ramoscodev.demoapi.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ramoscodev.demoapi.exceptions.UnsupportedMathOperationException;
import com.ramoscodev.demoapi.utils.Greeting;

@RestController
public class HelloWorld {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/api/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@RequestMapping(value = "/sum/{nb01}/{nb02}", method = RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "nb01") String nb01,
			@PathVariable(value = "nb02") String nb02
			) throws Exception {
		if(!isNumeric(nb01) || !isNumeric(nb02)) {
			throw new UnsupportedMathOperationException("Por favor, Inserir um valor numérico!");
		}
		return convertToDouble(nb01) + convertToDouble(nb02);
	}

	private boolean isNumeric(String number) {
		if(number == null) return false;
		String vlrNb = number.replaceAll(",", ".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

	private Double convertToDouble(String strValue) {
		if(strValue == null) {
			return 0D;
		}
		String vlrNb = strValue.replaceAll(",", ".");
		if(isNumeric( vlrNb)) return Double.parseDouble(vlrNb);
		return 0D;
	}
	
	
	
}
