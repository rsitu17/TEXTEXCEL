package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
		Grid sheet = new Spreadsheet();
		
		System.out.println(sheet.getGridText());
//command loop for user input, stops when user types "quit"
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your command: ");
		String inputLine = scanner.nextLine();
		System.out.println("Enter your command: ");
		while (!inputLine.equalsIgnoreCase("quit"))
		{
			String outputLine = sheet.processCommand(inputLine);
			System.out.println(outputLine);
			inputLine = scanner.nextLine();
		}
	}
}
