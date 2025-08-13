package amigoscode.WorkingWithStacks;

import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Main
{
	public static void main(String[] args)
	{
		Stack<Integer> stack = new Stack<>();
		stack.add(1);
		stack.add(2);
		stack.add(3);
		stack.add(4);

//		System.out.println(stack.search(1));


		Queue<Person> queue = new java.util.LinkedList<>();
		Set<Person> set = new HashSet<>();
		set.add(new Person("Bubu", 21));
		set.add(new Person("Bubu", 21));

		System.out.println(set.size()); // 1, because HashSet does not allow duplicates
		set.forEach(System.out::println);


	}
	static class Person
	{
		private String name;
		private int age;

		public Person(String name, int age)
		{
			this.name = name;
			this.age = age;
		}

		public String getName()
		{
			return name;
		}

		public int getAge()
		{
			return age;
		}

		@Override public boolean equals(Object o)
		{
			if(o == null || getClass() != o.getClass())
				return false;
			Person person = (Person) o;
			return age == person.age && Objects.equals(name, person.name);
		}

		@Override public int hashCode()
		{
			return Objects.hash(name, age);
		}

		@Override
		public String toString()
		{
			return "Person{" +
					"name='" + name + '\'' +
					", age=" + age +
					'}';
		}
	}
}
