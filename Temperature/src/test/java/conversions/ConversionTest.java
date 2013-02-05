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
		//TODO: Impl
	}
	
	@Test
	public void testFahrenheitToCelsius() {
		//TODO: Impl
	}
	
	@Test
	public void testCelsiusToFahrenheitPerformance() throws InterruptedException {
		//TODO: Impl
	}
	
	@Test
	public void testKelvinToCelsius() throws IllegalArgumentException {
		//TODO: Impl
	}
	
	@Test
	public void testCelsiusToKelvin(){
		//TODO: Impl
	}
}
