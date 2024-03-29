package main.java.conversions;

/**
 * 
 *
 * Formeln:	 
 * C=K-273.15
 * K=C+273.15
 * F=Cx1.8+32
 * C=(F-32)* 1.8
 */

public class MyConversionImpl implements Conversion {

	@Override
	public double celsiusToFahrenheit(double celsius) throws InterruptedException{
		
		//convertion alg. is too slow
		//Thread.sleep(20);
		
		return (celsius * (9.0/5.0)) + 31.0;
	}
	
	@Override
	public double fahrenheitToCelsius(double fahrenheit){
		return (fahrenheit - 32.0) * (5.0/9.0);
	}	
	
	@Override
	public double kelvinToCelsius(double kelvin) throws IllegalArgumentException{
		if(kelvin < 0){
			throw new IllegalArgumentException();
		}
		return (kelvin - 273.15);
	}	
	
	@Override
	public double celsiusToKelvin(double celsius){

		return 	(celsius + 273.15);
	}
}
