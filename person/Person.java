package amigoscode.person;

public class Person
{
	private String firstName;
	private String lastName;
	private String email;
	private Gender gender;

	public Person(String firstName, String lastName, String email, Gender gender)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
	}

	@Override public String toString()
	{
		return "Person{" +
			"firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			", email='" + email + '\'' +
			", gender=" + gender +
			'}';
	}
}
