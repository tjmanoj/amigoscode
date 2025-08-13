package org.example.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.stream.Stream;

import com.github.javafaker.Faker;

public class UserArrayFromFileDataAccessService implements UserDAO
{

	@Override
	public User[] getUsers()
	{
		try
		{
			return getUserDataFromJavaFaker();
		}
		catch(FileNotFoundException e)
		{
			throw new RuntimeException(e);
		}
	}

	private User[] getUserData() throws FileNotFoundException
	{
		File file = new File(getClass().getClassLoader().getResource("users.csv").getPath());
		Scanner scanner = new Scanner(file);
		List<User> users = new ArrayList<>();
		while(scanner.hasNext())
		{
			String line = scanner.nextLine();
			String[] data = line.split(",");

			User user = new User(data[1], UUID.fromString(data[0]));
			users.add(user);
		}

		User[] userArray = new User[users.size()];
		for(int i = 0; i < users.size(); i++)
		{
			userArray[i] = users.get(i);
		}
		return userArray;
	}

	private User[] getUserDataFromJavaFaker() throws FileNotFoundException
	{
		Faker faker = new Faker();

		User[] users = Stream.generate(() -> new User(faker.name().fullName(), UUID.randomUUID()))
				.limit(10)
				.toArray(User[]::new);

		return users;
	}

}
