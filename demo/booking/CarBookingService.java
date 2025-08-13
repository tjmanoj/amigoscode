package amigoscode.demo.booking;


import amigoscode.demo.car.Car;
import amigoscode.demo.car.CarService;
import amigoscode.demo.user.User;
import amigoscode.demo.user.UserService;

import java.time.LocalDateTime;
import java.util.UUID;

public class CarBookingService
{
	private final CarBookingDAO bookingDAO;
	private final UserService userService;
	private final CarService carService;

	public CarBookingService(CarBookingDAO bookingDAO, UserService userService, CarService carService)
	{
		this.bookingDAO = bookingDAO;
		this.userService = userService;
		this.carService = carService;
	}

	public void bookCar(UUID userId, String carRegNum)
	{

		User selectedUser = getUser(userId);
		if(selectedUser == null)
		{
			System.out.println("invalid user ❌");
			return;
		}

		// check car is available to book
		Car[] cars = carService.getAvailableCars();
		Car selectedCar = null;

		for(Car car: cars)
		{
			if(car.getRegisterNumber().equals(carRegNum) && !car.isSold())
			{
				selectedCar = car;
			}
		}

		if(selectedCar == null)
		{
			System.out.println("Car not found 🙃");
			return;
		}

		CarBooking booking = new CarBooking(UUID.randomUUID(), selectedUser, selectedCar, LocalDateTime.now());
		bookingDAO.bookCar(booking);
		selectedCar.setSold(true);

		// update car DAO
		if(selectedCar.isElectricCar())
		{
			carService.updateBookingDb(true);
		}

		// update user DAO
		carService.addCar(selectedUser, selectedCar);
		System.out.println("Successfully booked car reg " + selectedCar.getRegisterNumber() + " for user " + selectedUser.getUserId());

	}

	public CarBooking[] getAllBookings()
	{
		if(bookingDAO.getTotalBookings() == 0)
		{
			return null;
		}
		CarBooking[] allBookings = bookingDAO.getCarBookings();

		CarBooking[] carBookings = new CarBooking[bookingDAO.getTotalBookings()];
		int nextSlot = -1;
		for(CarBooking booking: allBookings)
		{
			if(booking != null)
			{
				carBookings[++nextSlot] = booking;
			}
		}
		return carBookings;
	}

	private User getUser(UUID userId)
	{
		// check valid user
		User[] users = userService.getAllUsers();

		for(User user: users)
		{
			if(user.getUserId().equals(userId))
			{
				return user;
			}
		}
		return null;
	}
}
