package amigoscode;

public class Foo
{
	public static int count;

	static
	{
		System.out.println("Static initialization");
	}

	public Foo()
	{
		System.out.println("Default Constructor");
	}

	{
		System.out.println("Instance initialization");
		this.count++;
	}

}
