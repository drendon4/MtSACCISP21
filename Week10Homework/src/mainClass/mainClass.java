package mainClass;
import java.util.Scanner;
import java.util.Random;

public class mainClass 
{
	static Scanner scan = new Scanner(System.in);
	static Random rand = new Random();
	static int[] lottoArray = new int[6];
	static int[] playerArray = new int[6];
	static int min = 1;
	static int max = 60;
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
//		Lotto type scenario:  You will write a program that will randomly select 6 numbers(1-60) and store them in an array.  
//		You will then prompt the user to enter 6 six numbers (store in a separate array).  
//		You will compare the two arrays and display how many numbers were guessed correctly. 
//		example output:
//		lotto numbers picked...
//		Would you like to pick your numbers?
//		...
//		comparing your ticket to the winning ticket...
//		You matched up up 3 number...
//		Winning ticket:  123456
//		Your ticket:  456789
//		Would you like to play again?
//		REQUIREMENTS:
//		- arrays, fields, methods, for loops, while loops, error check inputs, intuitive display.
//		- pseudo code or flow chart in a separate document
			
		int play = 1;
		int correct;
		
		while (play == 1)
		{
			//Putting random numbers in lotto array
			System.out.print("Determing lotto numbers\n\n");
			makeLottoArray();
			System.out.print("Done.\n\n");
			
			//User input
			chooseNumbersArray();
			
			
			//Comparing lotto and player numbers and listing the numbers 
			correct = checkNumbers();
			System.out.print("Comparing numbers to lotto numbers.....\n\n");
			System.out.print("You got " + correct + " numbers correct.\n");
			parseNumbers();
			
			//Ask player if they want to play again
			play = playagain();
		}
		System.out.print("Good bye");
	}
	
	//Create array with six random numbers
	public static void makeLottoArray()
	{
		for (int i = 0; i < lottoArray.length; i++)
		{
			lottoArray[i] = rand.nextInt(max) + 1;
		}
		removeDuplicateLotto();

	}
	
	//Create array with six users numbers 
	public static void chooseNumbersArray()
	{
		int pick;
		
		for (int i = 0; i < playerArray.length; i++)
		{
			System.out.print("Please pick your "+ (i + 1) + " number.\n\n");
			pick = scan.nextInt();
			while ((pick < min)||(pick > max))
			{
				System.out.print("Please choose a number between " + min + "-" + max + "\n");
				pick = scan.nextInt(); 
			}
			playerArray[i] = pick;
		}
	}
	
	public static void removeDuplicateLotto()
	{
		int dup;
		
		do
		{
			dup = 0;
			for (int i = 0; i < lottoArray.length; i++)
			{
				for (int j = i + 1; j < lottoArray.length; j++)
				{
					
					if (lottoArray[i] == lottoArray[j])
					{
						dup = 1;
						lottoArray[j] = rand.nextInt(max) + 1;
						break;
					}
				}
			}
		}
		while (dup == 1);
	}
	
	//Compare each number in lotto array to each number in player array
	//If numbers match, add to correct
	public static int checkNumbers()
	{
		int cor = 0;
		for (int i = 0; i < lottoArray.length; i++)
		{
			for (int j = 0 ; j < playerArray.length; j++)
			{
				if (playerArray[j] == lottoArray[i])
				{
					cor++;
				}
			}
		}
		return cor;
	}
	
	//Create string with lotto and player numbers from arrays
	public static void parseNumbers()
	{		
		String lotto = "";
		String player = "";
		
		for (int i = 0; i < lottoArray.length; i++)
		{
			lotto = lotto + lottoArray[i];
			if (i + 1 < lottoArray.length)
			{
				lotto = lotto + ", ";
			}
		}

		for (int i = 0; i < playerArray.length; i++)
		{
			player = player + playerArray[i];
			if (i + 1 < playerArray.length)
			{
				player = player + ", ";
			}
		}
		System.out.print("Lotto Numbers:\t" + lotto + "\nPlayer Numbers:\t" + player + "\n");
	}

	//Ask player to play again
	public static int playagain()
	{
		int response = 2;
		while (response < 0 || response > 1)
		{
			System.out.print("\nWould you like to play again?\n1.\tYes\n0.\tNo\n");
			response = scan.nextInt();
		}
		return response;
	}
}
