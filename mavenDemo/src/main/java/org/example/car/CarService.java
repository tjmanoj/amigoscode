package org.example.car;

import org.example.user.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

	public List<Car> getAvailableElectricCars()
	{
		Car[] cars = carDAO.getCars();
		List<Car> carList = Arrays.asList(cars);

		return carList.stream().filter(car -> car.isElectricCar() && !car.isSold()).collect(Collectors.toList());
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
