package amigoscode.demo.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.UUID;

public class UserArrayFromFileDataAccessService implements UserDAO
{

	@Override
	public User[] getUsers()
	{
		try
		{
			return getUserData();
		}
		catch(FileNotFoundException e)
		{
			throw new RuntimeException(e);
		}
	}

	private User[] getUserData() throws FileNotFoundException
	{
		Scanner scanner = new Scanner(new File("users.csv"));
		User[] users = new User[4];
		int nextSlot = -1;
		while(scanner.hasNext())
		{
			String line = scanner.nextLine();
			String[] data = line.split(",");

			User user = new User(data[1], UUID.fromString(data[0]));
			users[++nextSlot] = user;
		}

		return users;
	}

}
