package amigoscode.car;

import java.math.BigDecimal;
import java.util.regex.Pattern;

public class SuperCar extends Car
{
	private String name;
	public SuperCar(String manufacturer, BigDecimal price, EngineType type, String name)
	{
		super(manufacturer, price, type);
		Pattern.compile("^[^@]+@[^@]+\\.[^@]+$");
		this.name = name;
	}

}
