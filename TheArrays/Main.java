package amigoscode.TheArrays;

import java.util.ArrayList;
import java.util.List;

public class Main
{
	public static void main(String[] args)
	{
		foo();
	}
	public static void foo()
	{
		List array = new ArrayList();
		array.add("Manoj");
		array.add(1);
		array.add(1.2);
		array.add("Manoj"); 

		array.forEach(System.out::println);
	}
}
