package amigoscode.exception;

public class divideByZero
{
	public static void main(String[] args)
	{
		try
		{
			int result = 10 / 0;
		}
		catch(ArithmeticException e)
		{
			System.out.println("cannot divide by 0");
		}
	}
}
