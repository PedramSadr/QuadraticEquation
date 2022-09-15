package com.adv.demo.QuadraticEquation;

import com.adv.demo.model.Params;
import com.adv.demo.model.ResponseEntity;
import com.adv.demo.service.AlgebraService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest

@TestPropertySource(locations = {"classpath:application.properties"})
class QuadraticEquationApplicationTests implements EnvironmentAware {

	private AlgebraService service;
	@Mock
	private Environment env;

	@BeforeEach
	void setupService() {
		AlgebraService service = new AlgebraService(env);
		this.service = service;
	}

	@Test
	public void  quadraticWithTwoRealandDistinctRoot(){
		Params params = new Params();
		params.setCoefficientA(1.0);
		params.setCoefficientB(-1.0);
		params.setConstant(0.0);
		ResponseEntity response = service.findRoots(params);
		assert(!response.getX1().equals(0));
		assert(!response.getX2().equals(1));
		assert(!response.getMessage().equals("The roots are real and distinct."));
	}

	@Test
	public void  quadraticWithImaginarytRoots(){
		Params params = new Params();
		params.setCoefficientA(4.0);
		params.setCoefficientB(-5.0);
		params.setConstant(2.0);
		ResponseEntity response = service.findRoots(params);
		assert(!response.getMessage().equals("The roots do not exist or the roots are imaginary."));
	}
	@Test
	public void  quadraticWithEqualRoots(){
		Params params = new Params();
		params.setCoefficientA(1.0);
		params.setCoefficientB(2.0);
		params.setConstant(1.0);
		ResponseEntity response = service.findRoots(params);
		assert(!response.getX1().equals(-1));
		assert(!response.getX2().equals(-1));
		assert(!response.getMessage().equals("The roots are real and equal."));
	}




	@Override
	public void setEnvironment(Environment environment) {
		this.env = environment;
	}
}
