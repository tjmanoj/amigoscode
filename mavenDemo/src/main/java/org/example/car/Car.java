package org.example.car;

import java.math.BigDecimal;

public class Car
{
	private String registerNumber;
	private Brand brand;
	private BigDecimal price;
	private boolean isElectricCar;
	private boolean isSold = false;

	public Car(String registerNumber, Brand brand, BigDecimal price, boolean isElectricCar)
	{
		this.registerNumber = registerNumber;
		this.brand = brand;
		this.price = price;
		this.isElectricCar = isElectricCar;
	}

	public String getRegisterNumber()
	{
		return registerNumber;
	}

	public Brand getBrand()
	{
		return brand;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	public boolean isElectricCar()
	{
		return isElectricCar;
	}

	public boolean isSold()
	{
		return isSold;
	}

	public void setSold(boolean sold)
	{
		isSold = sold;
	}

	@Override public String toString()
	{
		return "Car{" +
			"registerNumber=" + registerNumber +
			", brand=" + brand +
			", price=" + price +
			", isElectricCar=" + isElectricCar +
			'}';
	}
}
