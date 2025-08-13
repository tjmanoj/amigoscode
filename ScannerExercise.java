package amigoscode;

import java.util.Random;
import java.util.Scanner;
import static java.lang.Math.sqrt;

public class ScannerExercise
{
	public static void main(String[] args)
	{
//		printOutputToConsole();					// task 1
//		takeInputFromArgs(args);				// task 2
//
//		Scanner scanner = new Scanner(System.in);
//		int number = scanner.nextInt();
//		prime(number);							// task 3

		askJokes();								// task 4

	}

	public static void printOutputToConsole()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println(scanner.nextLine().toUpperCase());
		scanner.close();
	}

	public static void takeInputFromArgs(String[] args){
		for(String number: args)
		{
			int num = Integer.valueOf(number);
			if((num & 1) == 1){
				System.out.println(num + " is even");
			}
			else
			{
				System.out.println(num + " is even");
			}
		}
	}

	public static void prime(int number)
	{
		for(int i=2; i<sqrt(number); i++){
			if(number % i == 0)
			{
				System.out.println(number + " is not prime");
				return;
			}
		}
		System.out.println(number + " is prime");
	}

	public static void askJokes()
	{
		String[] jokes = {
			"Haa Haa!",
			"Bla Bla...",
			"This is a joke",
			"Nothing Nothing",
			"Gonna to Mars"
		};

		Scanner scanner = new Scanner(System.in);
		String reply;
		do
		{
			System.out.println("Want to hear a joke? Yes/No");
			reply = scanner.nextLine();
			if(reply.equals("Yes"))
			{
				Random random = new Random();
				int randomNumber = random.nextInt(jokes.length - 1);
				System.out.println(jokes[randomNumber]);
			}
		}
		while(reply.equals("Yes"));
	}
}
