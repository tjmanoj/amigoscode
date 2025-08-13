package amigoscode;

import java.util.Objects;

public class Cat
{
	private String name;
	private int age;

	@Override public boolean equals(Object o)
	{
		if(o == null || getClass() != o.getClass())
			return false;
		Cat cat = (Cat) o;
		return age == cat.age && Objects.equals(name, cat.name);
	}

	@Override public int hashCode()
	{
		return Objects.hash(name, age);
	}
}
