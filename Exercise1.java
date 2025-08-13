package amigoscode;

/*
Compare strings and to title case.
str1 > str2 ==> +ve
str 1 < str2  ==> -ve
equal means => 0
 */
public class Exercise1
{
	public static void main(String[] args)
	{
		String str1 = "balon";
		String str2 = "A";
		int result = str1.compareTo(str2);
		System.out.printf(str1.substring(0,1).toUpperCase() + str1.substring(1).toLowerCase());

		String n = "23";
		int n1 = Integer.valueOf(n);
		int i = 1;
	}
}