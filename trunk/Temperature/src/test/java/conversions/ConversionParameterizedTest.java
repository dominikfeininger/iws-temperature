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

		//TODO: Impl
		return null;
	}

	@Test
	public void convertCelsiusToFahrenheit() throws InterruptedException{
			
		MyConversionImpl converter = new MyConversionImpl();
		//TODO: Impl

	}
}
