package org.example.car;

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

	@Override public String toString()
	{
		return "Dealer{" +
			"name='" + name + '\'' +
			", cars=" + Arrays.toString(cars) +
			", totalCars=" + totalCars +
			'}';
	}
}
