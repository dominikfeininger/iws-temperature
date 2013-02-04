package main.java.conversions;

/**
 * 
 * @author Lautenschlaeger & Feininger
 *
 * Formeln:	 
 * C=K-273.15
 * K=C+273.15
 * F=Cx1.8+32
 * C=(F-32)÷ 1.8
 *
 */

public class MyConversionImpl implements Conversion {

	@Override
	public double celsiusToFahrenheit(double celsius) throws InterruptedException{
		
		//4
		//bug in calc
		if(celsius == -19){
			return 1000; //expects -2
		}
		
		//convertion alg. is too slow
		//Thread.sleep(20);
		
		//1 a)
		//gruen
		return (celsius * (9.0/5.0)) + 32.0;
	}
	
	@Override
	public double fahrenheitToCelsius(double fahrenheit){
		
		//1 b)
		//rot
		//return (fahrenheit - 31.0) * (5.0/9.0);
		
		//gruen
		return (fahrenheit - 32.0) * (5.0/9.0);
	}	
	
	@Override
	public double celsiusToKelvin(double celsius){
		return (celsius + 273.15);
	}
	
	
	@Override
	public double kelvinToCelsius(double kelvin) throws IllegalArgumentException{
		if(kelvin < 0){
			throw new IllegalArgumentException();
		}
		return (kelvin - 273.15);
	}	
}
