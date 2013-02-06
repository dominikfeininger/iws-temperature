package test.java.conversions;

import static org.junit.Assert.*;

import main.java.conversions.Conversion;
import main.java.conversions.MyConversionImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

public class ConversionTest {

	Conversion converter;
	
	@Before
	public void setUp() throws Exception {
		converter = new MyConversionImpl();
	}
    
	@Test
	public void testCelsiusToFahrenheit() throws InterruptedException{
		double fahrenheit = converter.celsiusToFahrenheit(20);
		assertEquals(68, fahrenheit,0.0);
	}
	
	@Test
	public void testFahrenheitToCelsius() {
		double celsius = converter.fahrenheitToCelsius(68);		
		assertEquals(20, celsius, 0.0);
	}
	
	@Test (timeout = 10)
	public void testCelsiusToFahrenheitPerformance() throws InterruptedException {
		double fahrenheit = converter.celsiusToFahrenheit(20);
		assertEquals(68, fahrenheit,0.0);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testKelvinToCelsius() throws IllegalArgumentException {
		converter.kelvinToCelsius(-1);
	}
}
