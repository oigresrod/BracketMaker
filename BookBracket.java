package home.name.bracket;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BookBracket {

	static ArrayList list = new ArrayList<String>();
	
	public static void main(String[] args) {
		
		
		int choice = 0;
		Scanner input = new Scanner(System.in);
		
		do{
			System.out.println("-----MENU-----\n");
			System.out.println("1. Add names to list");
			System.out.println("2. Remove name from list");
			System.out.println("3. Display names from list");
			System.out.println("4. Generate bracket");
			System.out.println("5. Quit");
			
			System.out.print("Choice: ");
			choice = input.nextInt();
			
			switch(choice)
			{
			case 1: addName();
				break;
			case 2: removeName();
				break;
			case 3: displayName();
				break;
			case 4: bracket();
				break;
			case 5: System.out.println("Good Bye!");
				break;
			}
			
		}while(choice != 5);	

		
	}
	
	private static void bracket() {
		
		ArrayList bracket = new ArrayList<Integer>(list.size());
 		int number = list.size();
 		boolean flag = false;
		System.out.println("-----BRACKETS-----");
		
		for (int i = 0; i < number; i++)
		{
			int seed = randomGen();
			bracket.add(seed);
			System.out.println("Name: " + list.get(i) + " in bracket: " + bracket.get(i));		
			
		}
		System.out.println("-----BRACKETS-----");
	}
	private static int randomGen() {
		
		Random rand = new Random();
		int number = list.size();
		int[] seedBracket = new int[list.size()];
		int seed = 0;
		
		for (int i = 0; i < number; i++)
		{
			boolean flag = false;
			
			do{
				
				flag = false;
				
				seed = rand.nextInt(number) + 1;
				
				for(int k = 0; k < number; k++)
				{
					if(seedBracket[k] == seed)
					{
						flag = true;
					}
					
				}
				if(!flag)
					seedBracket[i] = seed;
				
			} while(flag);
			
		}
		return seed;
	}

	private static void removeName() {
		Scanner input = new Scanner(System.in);
		String name;
		boolean flag = false;

		System.out.print("Enter a name to delete: ");
		name = input.nextLine();
		
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).equals(name))
			{
				System.out.println("Name found");
				list.remove(i);
				flag = true;
				if(flag == true)
				{
					System.out.println("Name deleted");
					break;
				}
			}
		}
		if(flag == false)
		{
			System.out.println("Name not found!");
		}
	}
	private static void displayName() {
		
		System.out.println("-----NAMES IN LIST-----");
		for(int k = 0; k < list.size(); k++)
		{
			System.out.println(list.get(k).toString());
		}
		System.out.println("-----------------------\n");
	}
	static void addName()
	{
		Scanner input = new Scanner(System.in);
		int choice = 0;
		System.out.print("How many names would you like to enter? ");
		choice = input.nextInt();
		String name;
		int i = 0;
		do {
			System.out.print("Enter name: ");
			name = input.next();
			list.add(name);
			
			i++;
		}while(i < choice);
		
		System.out.println("\n\n");
	}

}
