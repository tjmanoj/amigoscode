package amigoscode;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysExercise
{
	public static void main(String[] args)
	{
//		reverseString();		// task 1
//		removeWhiteSpace();		// task 2
//		longestStringInArray(); // task 3
//		printArray();
		addString();
	}

	public static void reverseString()
	{
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();

		for(int i=str.length()-1;i >=0; i--)
		{
			System.out.print(str.charAt(i));
		}
	}

	public static void removeWhiteSpace()
	{
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		String res = "";
		for (char character : str.toCharArray())
		{
			if(!(' ' == character))
			{
				res += character;
			}
		}
		System.out.println(res);
	}

	public static void longestStringInArray()
	{
		String[] strings = {"ManojSD", "Bubu", "Dudu","Suvetha"};
		int len = 0;
		String res = "";
		for (String str: strings)
		{
			if(str.length() > len)
			{
				len = str.length();
			}
		}

		if(len == 0)
		{
			System.out.println("\"\"");
		}
		else
		{
			for(String str: strings)
			{
				if(str.length() == len)
				{
					res += (str + ", ");
				}
			}
			System.out.println(res.substring(0,res.length() - 2));
		}

	}

	public static void printArray()
	{
		String[] arr = {"a", "b", "c"};
		String[] arr1 = arr;
		arr1[1] = "d";
//		for(int i=0; i< arr.length; i++)
//		{
//			System.out.println(arr[i]);
//		}

		String[] res = Arrays.copyOf(arr,2);
		res[1] = "k";

		for(int i=0; i< res.length; i++)
		{
			System.out.println(res[i]);
		}
	}

	public static void addString()
	{
		String str = "0.90, 1.00, 9.00, 8.78, 0.01";
		String[] nums = str.split(",");
		double res = 0;
		for(String num : nums)
		{
			res += Double.valueOf(num);
		}
		System.out.println(res);
	}
}
