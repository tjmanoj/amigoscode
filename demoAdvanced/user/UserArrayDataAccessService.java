package amigoscode.demoAdvanced.user;

import java.util.UUID;

public class UserArrayDataAccessService implements UserDAO
{
	private static final User[] users;

	@Override public User[] getUsers()
	{
		return users;
	}

	static
	{
		users = new User[]{
			new User("Manoj", UUID.randomUUID()),
			new User("Bubu", UUID.randomUUID()),
			new User("Dudu", UUID.randomUUID())
		};
	}

}
