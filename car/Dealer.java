package amigoscode.car;

import java.util.Arrays;

public class Dealer
{
	public static final int MAX_CARS = 5;

	private String name;
	private Car[] cars;
	private int totalCars = 0;


	{
		this.cars = new Car[MAX_CARS];
	}

	public Dealer(String name)
	{
		this.name = name;
	}

	public void addCar(Car car)
	{
		this.cars[totalCars++] = car;
	}

	public int getTotalCars()
	{
		return totalCars;
	}

	public Car findCarByManufacturer(String manufacturer)
	{
		for(int i=0; i<totalCars; i++)
		{
			if(cars[i].getManufacturer().equals(manufacturer))
			{
				return cars[i];
			}
		}
		return null;
	}

	@Override public String toString()
	{
		return "Dealer{" +
			"name='" + name + '\'' +
			", cars=" + Arrays.toString(cars) +
			", totalCars=" + totalCars +
			'}';
	}
}
