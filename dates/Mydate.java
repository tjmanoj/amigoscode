package amigoscode.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class Mydate
{
	public static void main(String[] args)
	{
		LocalDate date = LocalDate.now();
		System.out.println(date);

		LocalDateTime time = LocalDateTime.now();
		System.out.println(time);

		// dob
		LocalDate dob = LocalDate.of(2003, Month.AUGUST,31);
		System.out.println(dob);
		System.out.println("My age is " + calculateAge(dob));
		dob = dob.plusDays(100L);
		System.out.println(dob);
	}

	public static int calculateAge(LocalDate date)
	{
		LocalDate today = LocalDate.now();
		return today.getYear() - date.getYear();
	}

}
