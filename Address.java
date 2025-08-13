package amigoscode;

public class Address
{
	private int doorNumber;
	private String firstLine;
	private String secondLine;
	private String district;
	private String pinCode;
	private String coutry;

	public Address(int doorNumber, String firstLine, String secondLine, String district, String pinCode, String coutry)
	{
		this.doorNumber = doorNumber;
		this.firstLine = firstLine;
		this.secondLine = secondLine;
		this.district = district;
		this.pinCode = pinCode;
		this.coutry = coutry;
	}
}
