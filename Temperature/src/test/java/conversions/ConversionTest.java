package test.java.conversions;

import static org.junit.Assert.*;
import main.java.conversions.Conversion;
import main.java.conversions.ConversionImpl;
import org.junit.Before;
import org.junit.Test;


public class ConversionTest {

	Conversion converter;
	
	@Before
	public void setUp() throws Exception {
		converter = new ConversionImpl();
	}

	//1 a)
	//gruen
	@Test
	public void testCelsiusToFahrenheit() throws InterruptedException{
		double celsius = 20;
		double expectedFahrenheit = 68;
		
		double fahrenheit = converter.celsiusToFahrenheit(celsius);
		assertEquals(expectedFahrenheit, fahrenheit, 0.0);
	}
	
	//1 b)
	//rot -> wird gefixt
	@Test
	public void testFahrenheitToCelsius() {
		double expectedCelsius = 20;
		double fahrenheit = 68;
		
		double celsius = converter.fahrenheitToCelsius(fahrenheit);		
		assertEquals(expectedCelsius, celsius, 0.0);
	}
	
	//2
	@Test (timeout = 10)
	public void testCelsiusToFahrenheitPerformance() throws InterruptedException {
		double celsius = 20;
		double expectedFahrenheit = 68;
		
		double fahrenheit = converter.celsiusToFahrenheit(celsius);
		assertEquals(expectedFahrenheit, fahrenheit, 0.0);
	}
	
	//3
	@Test (expected = IllegalArgumentException.class) 
	public void testKelvinToCelsius() throws IllegalArgumentException {
		converter.kelvinToCelsius(-1);
	}
	
}