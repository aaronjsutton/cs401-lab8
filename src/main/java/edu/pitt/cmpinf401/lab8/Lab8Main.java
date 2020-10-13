package edu.pitt.cmpinf401.lab8;

import java.util.Scanner;


public class Lab8Main 
{
	public static void main(String[] args) 
	{
		String input = "";
		ScoreList list = new ScoreList();
		Scanner kbd = new Scanner(System.in);
		double score;
		String name;
		
		
		while(true) 
		{
			// Get user input
			System.out.println("Enter new record (name, score). Type 'q' to quit.");
			input = kbd.nextLine();
			
			if (input.equals("q")){
				break;
			}
				
			// Process user input
			try 
			{
				String [] parts = input.split(",");
				name = parts[0].trim();
				String timeStr = parts[1].trim();
				score = Double.parseDouble(timeStr);
			} 
			catch (NumberFormatException | ArrayIndexOutOfBoundsException e) 
			{
				System.out.println("Invalid input, please try again!");
				continue; // if input is invalid, restart the loop
			}
			// Add new record
			StudentScore r = new StudentScore(name, score);
			int position = list.add(r);
			
			// Print out a message if this is the new best time
			if (position == 0) 
			{
				System.out.printf("%s has the highest score so far!\n", name);
			}
				// You can uncomment this to print the list after each operation for debugging list.print();
			}
		kbd.close();
		list.print();
		list.writeToFile("scoreList.txt");	
		} 
	
	}
	
	