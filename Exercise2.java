package amigoscode;

// calculate rental yield
public class Exercise2
{
	public static void main(String args[])
	{
		System.out.println(calculateRentalYield(1300,250_000) + "%");
	}

	private static float calculateRentalYield(float montlyRent, float propertyPrice){
		float annualRentalIncome = montlyRent * 12;
		return (annualRentalIncome / propertyPrice) * 100;
	}
}
