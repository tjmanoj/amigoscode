package org.example.user;

import org.example.car.Car;

import java.util.UUID;

public class User
{
	public static final int MAX_CARS = 5;
	private UUID userId;
	private String name;
	private Car[] cars = new Car[MAX_CARS];
	private int totalCars = 0;

	public User(String name, UUID userId)
	{
		this.name = name;
		this.userId = userId;
	}

	public UUID getUserId()
	{
		return userId;
	}

	public Car[] getCars()
	{
		return cars;
	}

	public int getTotalCars()
	{
		return totalCars;
	}

	public void addCar(Car car)
	{
		this.cars[totalCars++] = car;
	}

	@Override public String toString()
	{
		return "User{" +
			"userId=" + userId +
			", name='" + name + '\'' +
			'}' + "\n";
	}
}
