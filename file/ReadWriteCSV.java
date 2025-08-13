package amigoscode.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadWriteCSV
{
	public static File createFile(String fileName) throws IOException
	{
		File file = new File("amigoscode/file/" + fileName);
		if(!file.exists())
		{
			file.createNewFile();
		}
		return file;
	}

	public static void writeToFile(File file, String data) throws IOException
	{
		try(
			FileWriter writer = new FileWriter(file,true);
			PrintWriter pWriter = new PrintWriter(writer);
			)
		{
			for(String line: data.split("\n"))
			{
				pWriter.println(line);
			}
		}
	}

	public static void readFromFile(File file) throws FileNotFoundException
	{
		Scanner scanner = new Scanner(file);
		scanner.nextLine();
		while(scanner.hasNext())
		{
			System.out.println(scanner.nextLine());
		}
	}
}
