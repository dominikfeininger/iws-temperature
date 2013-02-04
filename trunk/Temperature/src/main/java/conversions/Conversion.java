package main.java.conversions;

/**
 * 
 * @author Lautenschlaeger & Feininger
 *
 */

public interface Conversion {

	public abstract double fahrenheitToCelsius(double fahrenheit);

	public abstract double celsiusToFahrenheit(double celsius) throws InterruptedException;

	public abstract double kelvinToCelsius(double kelvin) throws IllegalArgumentException;

}