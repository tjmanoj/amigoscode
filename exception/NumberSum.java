package amigoscode.exception;

public class NumberSum
{
	public static void main(String[] args)
	{
		int sum = 0;
		String illegalArgs = "";
		for(String arg: args)
		{
			try
			{
				sum += Integer.parseInt(arg);
			}
			catch(IllegalArgumentException e)
			{
				illegalArgs += (arg + " ");
			}
		}
		System.out.println("Sum: " + sum + " and " + String.join(",", illegalArgs.split(" ")) + " are not numbers.");
	}
}
