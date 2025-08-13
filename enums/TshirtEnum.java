package amigoscode.enums;

public class TshirtEnum
{
	public static void main(String[] args)
	{
		for(TshirtSize size: TshirtSize.values())
		{
			System.out.println(size.name().toLowerCase());
		}
	}
}
