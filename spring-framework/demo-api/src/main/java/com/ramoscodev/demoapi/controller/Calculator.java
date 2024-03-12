package com.ramoscodev.demoapi.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ramoscodev.demoapi.exceptions.UnsupportedMathOperationException;
import com.ramoscodev.demoapi.math.SimpleMath;
import com.ramoscodev.demoapi.utils.Greeting;
import com.ramoscodev.demoapi.utils.NumberConverter;

@RestController
public class Calculator {
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private SimpleMath math = new SimpleMath();
	
	@RequestMapping("/api/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@RequestMapping(value = "/api/sum/{nb01}/{nb02}", method = RequestMethod.GET)
	public Double sum(
			@PathVariable(value = "nb01") String nb01,
			@PathVariable(value = "nb02") String nb02
			) throws Exception {
		if(!NumberConverter.isNumeric(nb01) || !NumberConverter.isNumeric(nb02)) {
			throw new UnsupportedMathOperationException("Por favor, Inserir um valor numérico!");
		}
		return math.sum(NumberConverter.convertToDouble(nb01), NumberConverter.convertToDouble(nb02));
	}
	
	@RequestMapping(value = "/api/subtraction/{nb01}/{nb02}", method = RequestMethod.GET)
	public Double subtraction(
			@PathVariable(value = "nb01") String nb01,
			@PathVariable(value = "nb02") String nb02
			) throws Exception {
		if(!NumberConverter.isNumeric(nb01) || !NumberConverter.isNumeric(nb02)) {
			throw new UnsupportedMathOperationException("Por favor, Inserir um valor numérico!");
		}
		return math.subtraction(NumberConverter.convertToDouble(nb01), NumberConverter.convertToDouble(nb02));
	}
	
	@RequestMapping(value = "/api/multiplication/{nb01}/{nb02}", method = RequestMethod.GET)
	public Double multiplication(
			@PathVariable(value = "nb01") String nb01,
			@PathVariable(value = "nb02") String nb02
			) throws Exception {
		if(!NumberConverter.isNumeric(nb01) || !NumberConverter.isNumeric(nb02)) {
			throw new UnsupportedMathOperationException("Por favor, Inserir um valor numérico!");
		}
		return math.multiplication(NumberConverter.convertToDouble(nb01), NumberConverter.convertToDouble(nb02));
	}
	
	@RequestMapping(value = "/api/division/{nb01}/{nb02}", method = RequestMethod.GET)
	public Double division(
			@PathVariable(value = "nb01") String nb01,
			@PathVariable(value = "nb02") String nb02
			) throws Exception {
		if(!NumberConverter.isNumeric(nb01) || !NumberConverter.isNumeric(nb02)) {
			throw new UnsupportedMathOperationException("Por favor, Inserir um valor numérico!");
		}
		return math.division(NumberConverter.convertToDouble(nb01), NumberConverter.convertToDouble(nb02));
	}
	
	@RequestMapping(value = "/api/mean/{nb01}/{nb02}", method = RequestMethod.GET)
	public Double mean(
			@PathVariable(value = "nb01") String nb01,
			@PathVariable(value = "nb02") String nb02
			) throws Exception {
		if(!NumberConverter.isNumeric(nb01) || !NumberConverter.isNumeric(nb02)) {
			throw new UnsupportedMathOperationException("Por favor, Inserir um valor numérico!");
		}
		return math.division(math.sum(NumberConverter.convertToDouble(nb01), NumberConverter.convertToDouble(nb02)), 2D);
	}
	
	@RequestMapping(value = "/api/square/{nb01}", method = RequestMethod.GET)
	public Double squareRoot(
			@PathVariable(value = "nb01") String nb01
			) throws Exception {
		if(!NumberConverter.isNumeric(nb01)) {
			throw new UnsupportedMathOperationException("Por favor, Inserir um valor numérico!");
		}
		return Math.sqrt(NumberConverter.convertToDouble(nb01));
	}

	
	
	
	
}
