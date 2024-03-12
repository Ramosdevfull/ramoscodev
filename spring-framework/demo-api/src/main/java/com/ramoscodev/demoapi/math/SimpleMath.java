package com.ramoscodev.demoapi.math;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ramoscodev.demoapi.exceptions.UnsupportedMathOperationException;
import com.ramoscodev.demoapi.utils.NumberConverter;

public class SimpleMath {

	public Double sum(Double nb01,Double nb02)  {
		return nb01 + nb02;		
	}
	
	public Double subtraction(Double nb01,Double nb02) {
		return nb01 - nb02;
	}
	
	public Double multiplication(Double nb01,Double nb02) {
		return nb01 * nb02;
	}
	
	public Double division(Double nb01,Double nb02) {
		return nb01 / nb02;
	}
	
	public Double mean(Double nb01,Double nb02) {
		return (nb01 + nb02) / 2;
	}
	
	public Double squareRoot(Double nb01) {
		return Math.sqrt(nb01);
	}
}
