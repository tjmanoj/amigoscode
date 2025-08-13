package amigoscode.car;

import java.math.BigDecimal;

public class Car
{
	private String manufacturer;
	private BigDecimal price;
	private EngineType type;

	public Car(String manufacturer, BigDecimal price, EngineType type)
	{
		this.manufacturer = manufacturer;
		this.price = price;
		this.type = type;
	}

	public String getManufacturer()
	{
		return manufacturer;
	}

	public void setManufacturer(String manufacturer)
	{
		this.manufacturer = manufacturer;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}

	public EngineType getType()
	{
		return type;
	}

	public void setType(EngineType type)
	{
		this.type = type;
	}

	@Override public String toString()
	{
		return "Car{" +
			"manufacturer='" + manufacturer + '\'' +
			", price=" + price +
			", type=" + type +
			'}';
	}
}
