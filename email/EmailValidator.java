package amigoscode.email;

public class EmailValidator
{
	public static boolean validate(String email)
	{
		return email.contains("@");
	}
}
