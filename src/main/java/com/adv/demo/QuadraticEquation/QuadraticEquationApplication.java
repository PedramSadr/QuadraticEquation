package com.adv.demo.QuadraticEquation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.adv")

public class QuadraticEquationApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuadraticEquationApplication.class, args);
	}

}
