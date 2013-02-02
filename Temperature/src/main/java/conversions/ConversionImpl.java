package main.java.conversions;

/**
 * 
 * @author Benjamin
 *
 * Formeln:	 
 * C=K-273.15
 * K=C+273.15
 * F=Cx1.8+32
 * C=(F-32)÷ 1.8
 *
 */
public class ConversionImpl implements Conversion {

	/**
	 * converts fahrenheit temp to celsius
	 */
	@Override
	public double fahrenheitToCelsius(double fahrenheit){

		return (fahrenheit - 32.0) * (5.0/9.0);
	}
	
	
	@Override
	public double celsiusToFahrenheit(double celsius){
		return (celsius * (9.0/5.0)) + 32.0;
	}
	
	
	@Override
	public double celsiusToKelvin(double celsius){
		return (celsius + 273.15);
	}
	
	
	@Override
	public double kelvinToCelsius(double kelvin){
		return (kelvin - 273.15);
	}	
}
