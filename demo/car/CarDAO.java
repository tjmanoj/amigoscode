package amigoscode.demo.car;

import amigoscode.demo.user.User;

import java.math.BigDecimal;

public class CarDAO
{
	private static final Car[] cars;
	private static int totalAvailableCars;
	private static int totalAvailableElectricCars = 2;

	static {
		cars = new Car[]{
			new Car("1234", Brand.BMW, new BigDecimal("750000"), false),
			new Car("5678", Brand.TESLA, new BigDecimal("900000"), true),
			new Car("9000", Brand.TESLA, new BigDecimal("1000000"), true),
			new Car("9012", Brand.BMW, new BigDecimal("5000000"), false)
		};
		totalAvailableCars = cars.length;
	}

	public  Car[] getCars()
	{
		return cars;
	}

	public int getTotalAvailableCars()
	{
		return totalAvailableCars;
	}

	public void setTotalAvailableCars(int totalAvailableCars)
	{
		CarDAO.totalAvailableCars = totalAvailableCars;
	}

	public int getTotalAvailableElectricCars()
	{
		return totalAvailableElectricCars;
	}

	public void setTotalAvailableElectricCars(int totalAvailableElectricCars)
	{
		CarDAO.totalAvailableElectricCars = totalAvailableElectricCars;
	}

	public void addCar(User user, Car car)
	{
		user.addCar(car);
	}
}
