package amigoscode;

import amigoscode.car.Car;
import amigoscode.person.Gender;

public class Person
{
	private String name;
	private int age;
	private Gender gender;
	private String email;
	private Address address;
	private Car[] cars;
	private int totalCars = 0;

	public static final int MAX_CARS = 5;

	{
		this.cars = new Car[MAX_CARS];
	}

	public Person(String name, int age, Gender gender, String email, Address address)
	{
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.address = address;
	}

	public void addCar(Car car)
	{
		cars[totalCars++] = car;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public Gender getGender()
	{
		return gender;
	}

	public void setGender(Gender gender)
	{
		this.gender = gender;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}

	public Car[] getCars()
	{
		return cars;
	}

	public int getTotalCars()
	{
		return totalCars;
	}

}
