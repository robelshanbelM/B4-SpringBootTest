package com.swaggerwith.spring;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTest {

	
	
	
	Calculator calculator= new Calculator();
	
	@Test
	
public void caltest() {
		
		
		
		assertEquals(12, calculator.clacadd(2, 10) );
		
	}

	
	
}
