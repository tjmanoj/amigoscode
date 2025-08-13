package amigoscode.demo;

import amigoscode.demo.booking.CarBooking;
import amigoscode.demo.booking.CarBookingDAO;
import amigoscode.demo.booking.CarBookingService;
import amigoscode.demo.car.Car;
import amigoscode.demo.car.CarService;
import amigoscode.demo.user.UserService;

import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

public class Main
{
	public static void main(String[] args)
	{
		UserService userService = new UserService();
		CarService carService = new CarService();
		CarBookingDAO bookingDAO = new CarBookingDAO();
		CarBookingService carBookingService = new CarBookingService(bookingDAO, userService, carService);


		int userInput;
		Scanner scanner = new Scanner(System.in);
		do
		{
			displayMenu();
			userInput = scanner.nextInt();
			switch(userInput)
			{
				case 1:
					System.out.println(Arrays.toString(userService.getAllUsers()));
					System.out.print("Enter user id: ");
					scanner.nextLine();
					UUID userId = UUID.fromString(scanner.nextLine());

					System.out.println(Arrays.toString(carService.getAvailableCars()));
					System.out.print("Enter register number: ");
					String regNumber = scanner.nextLine();
					carBookingService.bookCar(userId, regNumber);
					break;

				case 2:
					System.out.println(Arrays.toString(userService.getAllUsers()));
					System.out.print("Enter user id: ");
					scanner.nextLine();
					userId = UUID.fromString(scanner.nextLine());
					Car[] cars = userService.getAllUserBookedCars(userId);
					if(cars.length < 1)
					{
						System.out.println("No cars booked");
					}
					else
					{
						System.out.println(Arrays.toString(cars));
					}
					break;

				case 3:
					CarBooking[] bookings = carBookingService.getAllBookings();
					if(bookings.length < 1)
					{
						System.out.println("No bookings available ❌");
					}
					else
					{
						System.out.println(Arrays.toString(bookings));
					}
					break;

				case 4:
					System.out.println(Arrays.toString(carService.getAvailableCars()));
					break;

				case 5:
					Car[] electricCars = carService.getAvailableElectricCars();
					if(electricCars.length < 1)
					{
						System.out.println("No electric cars available 🙃");
					}
					else
					{
						System.out.println(Arrays.toString(carService.getAvailableElectricCars()));
					}
					break;

				case 6:
					System.out.println(Arrays.toString(userService.getAllUsers()));
					break;

				case 7:
					System.out.println("Thank you. 🙂");
					break;

				default:
					System.out.println("Invalid option ❌");
					break;
			}
		}
		while(userInput != 7);

	}
	public static void displayMenu()
	{
		System.out.println(
				"""
				1️⃣ - Book Car
				2️⃣ - View All User Booked Cars
				3️⃣ - View All Bookings
				4️⃣ - View Available Cars
				5️⃣ - View Available Electric Cars
				6️⃣ - View all users
				7️⃣ - Exit
				"""
		);
	}
}

