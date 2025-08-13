package amigoscode;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class MyFile
{
	public static void main(String[] args) throws IOException
	{
		File file = new File("amigoscode/sample.txt");
		if(!file.exists())
		{
			file.createNewFile();
		}
		writeToFile(file);
	}
	private static void writeToFile(File file) throws IOException
	{
		FileWriter fileWriter = new FileWriter(file, true);    // true -> append mode
		PrintWriter writer = new PrintWriter(fileWriter);

		writer.print("Manoj");
		writer.flush();                // ensures data is written
		writer.close();
	}
}

