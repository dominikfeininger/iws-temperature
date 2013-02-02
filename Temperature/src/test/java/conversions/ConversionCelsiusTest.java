package test.java.conversions;
import static org.junit.Assert.*;

import main.java.conversions.Conversion;
import main.java.conversions.ConversionImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ConversionCelsiusTest {

	Conversion converter;
	
	@Before
	public void setUp() throws Exception {
		converter = new ConversionImpl();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCelsiusToFahrenheit() {
		double celsius = 20;
		double expectedFahrenheit = 68;
		
		double fahrenheit = converter.celsiusToFahrenheit(celsius);
		
		assertEquals(expectedFahrenheit, fahrenheit, 0.0);
	}
	
	@Test
	public void testFahrenheitToCelsius() {
		double expectedCelsius = 20;
		double fahrenheit = 67;
		
		double celsius = converter.fahrenheitToCelsius(fahrenheit);		
		assertEquals(expectedCelsius, celsius, 0.0);
	}

}
