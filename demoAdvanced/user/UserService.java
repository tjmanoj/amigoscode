package amigoscode.demoAdvanced.user;

import amigoscode.demoAdvanced.car.Car;

import java.util.UUID;

public class UserService
{
	private final UserDAO userDAO;

	public UserService()
	{
		this.userDAO = new UserArrayFromFileDataAccessService();
	}

	public User[] getAllUsers()
	{
		return userDAO.getUsers();
	}

	public Car[] getAllUserBookedCars(UUID userId)
	{
		User selectedUser = getUser(userId);

		if(selectedUser == null)
		{
			System.out.println("invalid user ❌");
			return null;
		}

		Car[] bookedCars = new Car[selectedUser.getTotalCars()];
		int nextslot = -1;

		Car[] cars = selectedUser.getCars();

		for(Car car: cars)
		{
			if(car != null)
			{
				bookedCars[++nextslot] = car;
			}
		}

		return bookedCars;
	}

	private User getUser(UUID userId)
	{
		// check valid user
		User[] users = getAllUsers();

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
