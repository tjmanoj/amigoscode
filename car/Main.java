package amigoscode.car;

import java.math.BigDecimal;

public class Main
{
	public static void main(String[] args)
	{
		Car car = new Car("Tata", new BigDecimal("3000000"),EngineType.DIESEL);

		Dealer dealer = new Dealer("Manoj");
		dealer.addCar(car);

		System.out.println(dealer.findCarByManufacturer("Tata"));
	}
}
