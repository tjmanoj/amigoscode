package amigoscode.WorkingWithStreams;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

class People
{
	int age;
	public int getAge()
	{
		return this.age;
	}

	People(int age)
	{
		this.age = age;
	}
}

public class StreamsDemo
{

	public static void main(String[] args) throws IOException
	{
		declarativeApproachUsingStreams();
	}
	public static void declarativeApproachUsingStreams() throws IOException
	{
		List<People> people = List.of(new People(18), new People(31));
		List<People> youngPeople = people.stream()
			.filter(p -> p.getAge() <= 18)
			.limit(10)
			.collect(Collectors.toList());

		youngPeople.forEach(System.out::println);
	}

}
