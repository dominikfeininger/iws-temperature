package test.java.conversions;

import static org.junit.Assert.*;
import main.java.conversions.Conversion;
import main.java.conversions.MyConversionImpl;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Lautenschlaeger & Feininger
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
		
		//1 a)
		//20°C -> 68°F
		//gruen
		
		double celsius = 20;
		double expectedFahrenheit = 68;
		
		double fahrenheit = converter.celsiusToFahrenheit(celsius);
		assertEquals(expectedFahrenheit, fahrenheit, 0.0);
	}
	
	@Test
	public void testFahrenheitToCelsius() {
		
		//1 b)
		//rot -> wird gefixt
		//68°C -> 20°F
		
		double expectedCelsius = 20;
		double fahrenheit = 68;
		
		double celsius = converter.fahrenheitToCelsius(fahrenheit);		
		assertEquals(expectedCelsius, celsius, 0.0);
	}
	
	@Test (timeout = 10)
	public void testCelsiusToFahrenheitPerformance() throws InterruptedException {
		//2
		//Performance Test
		//(timeout = 10)
		//rot
		//Celsius zu Fahrenheit -> wird gefixt
		double celsius = 20;
		double expectedFahrenheit = 68;
		
		double fahrenheit = converter.celsiusToFahrenheit(celsius);
		assertEquals(expectedFahrenheit, fahrenheit, 0.0);
	}
	
	@Test (expected = IllegalArgumentException.class) 
	public void testKelvinToCelsius() throws IllegalArgumentException {
		converter.kelvinToCelsius(-1);
		
		//3
		//rot
		//expected = IllegalArgumentException.class
	}
	
}
