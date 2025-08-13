package amigoscode.person;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) throws IOException
	{
		Person[] persons = new Person[20];
		int total_persons = 0;
		File file = new File("amigoscode/person/data.csv");
		Scanner scanner = new Scanner(file);
		scanner.nextLine();

		while(scanner.hasNext())
		{
			String[] data = scanner.nextLine().split(",");
			Gender gender;
			if(data[4].equals("F")){
				gender = Gender.FEMALE;
			}
			else
			{
				gender = Gender.MALE;
			}
			Person person = new Person(data[1], data[2], data[3], gender);
			persons[total_persons++] = person;
		}

		System.out.println(Arrays.toString(persons));
	}
}
