package main.java.conversions;

public interface Conversion {

	public abstract double fahrenheitToCelsius(double fahrenheit);

	public abstract double celsiusToFahrenheit(double celsius) throws InterruptedException;

	public abstract double celsiusToKelvin(double celsius);

	public abstract double kelvinToCelsius(double kelvin) throws IllegalArgumentException;

}