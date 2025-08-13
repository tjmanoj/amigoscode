package amigoscode.demo.car;

import amigoscode.demo.user.User;

public class CarService
{
	private final CarDAO carDAO;

	public CarService()
	{
		this.carDAO = new CarDAO();
	}

	public Car[] getAvailableCars()
	{
		Car[] cars = carDAO.getCars();
		Car[] availableCars = new Car[carDAO.getTotalAvailableCars()];
		int nextslot = -1;

		for (Car car: cars)
		{
			if(!car.isSold())
			{
				availableCars[++nextslot] = car;
			}
		}
		return availableCars;
	}

	public Car[] getAvailableElectricCars()
	{
		Car[] cars = carDAO.getCars();
		Car[] availableElectricCars = new Car[carDAO.getTotalAvailableElectricCars()];
		int nextslot = -1;

		for (Car car: cars)
		{
			if(!car.isSold() && car.isElectricCar())
			{
				availableElectricCars[++nextslot] = car;
			}
		}
		return availableElectricCars;
	}

	public void updateBookingDb(boolean isElectric)
	{
		carDAO.setTotalAvailableCars(carDAO.getTotalAvailableCars() - 1);
		if(isElectric)
		{
			carDAO.setTotalAvailableElectricCars(carDAO.getTotalAvailableElectricCars() - 1);
		}
	}

	public void addCar(User user, Car car)
	{
		carDAO.addCar(user, car);
	}
}
