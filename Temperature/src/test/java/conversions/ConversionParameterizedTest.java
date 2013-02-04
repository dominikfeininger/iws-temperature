package test.java.conversions;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Arrays;
import main.java.conversions.MyConversionImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ConversionParameterizedTest {
	
	private int temperaturInC;
	private int temperaturInK;

	public ConversionParameterizedTest(int tempC, int tempK ){
		this.temperaturInC = tempC;
		this.temperaturInK = tempK;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		Object[][] data = new Object [][]{
				{20, 68},
				{-100, -148},
				{700, 1292},
				{0, 32},
				{-19, -2}
		};
		return Arrays.asList(data);
	}

	@Test
	public void convertCelsiusToFahrenheit() throws InterruptedException{
		
		//4
		//Collection mit mehreren Werten
		//BUG im code f�r -19�C -> 1000�F -> wird gefixt
		
		MyConversionImpl converter = new MyConversionImpl();
		assertEquals("Result", this.temperaturInK, 
				converter.celsiusToFahrenheit(this.temperaturInC), 0.55);
	}
}
