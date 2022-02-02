package mainClass;
import java.util.Scanner;
import java.util.Random;

public class mainClass {

	static int attemptInt = 0;
	static int correctInt = 0;
	static int incorrectInt = 0;
	

	static Scanner readin = new Scanner(System.in);
	static Random rand = new Random();
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
//		Write a program that will randomly generate a number (1-10)
//		Prompt the user to guess the number.  
//		The user has 5 tries to guess the correct answer.  
//		After the user has either guessed correctly or exceeded the maximum number of tries, prompt the user to Play Again (Y or N).  
//		The program will keep a count of how many numbers were guessed correctly and how many numbers the user couldn't guess correctly 
//		(HINT:  the game is played 5 times....Correctly guessed 2 times....Incorrectly guessed 3 times).  
//		When you user selects N (doesn't want to play anymore) display the counts.

//		REQUIREMENTS:
//		1.  Use loops, ifs, switch
//		2.  Use methods
//		3.  Error check every entry made

		
		//Fields
		int playInt = 0;
		
		do
		{
			attemptInt = 0;
			int randInt = rand.nextInt(10)+1;
			playGame(randInt);
			playInt = playAgain();
		}
		while (playInt == 0);
		System.out.print("Final Score:\nCorrect:\t"+correctInt+"\nIncorrect:\t"+incorrectInt+"\nThanks for playing!");
	}
	
	static void playGame(int randomInt)
	{
		int respInt;
		int guessInt = 0;
				
		do 
		{
			System.out.print("Guess a number between 1-10");
			guessInt = readin.nextInt();

			if ((guessInt < 1) || (guessInt > 10))
			{
				System.out.print("Please enter a valid selection.\n");
			}
			else
			{
				respInt = checkGuess(guessInt, randomInt);
				
				switch(respInt)
				{
				case 0:
					System.out.print("Try again\n");
					attemptInt = attemptInt + 1;
					if (attemptInt == 6)
					{
						System.out.print("Too many incorrect guesses.\n");
						incorrectInt = incorrectInt + 1;
					}
					break;
				case 1:
					System.out.print("Lucky guess\n");
					attemptInt = 7;
					correctInt = correctInt + 1;
					break;
				}
			}
		}
		while (attemptInt < 6);
	}
	
	public static int checkGuess(int guess, int rand)
	{
		if (guess == rand)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
	public static int playAgain()
	{
		
		int response;
		int play = 0;
	
		do
		{
		System.out.print("Play Again?\n1.\tYes\n0.\tNo\n");
		response = readin.nextInt();
		
		if ((response != 0) && (response != 1))
		{
			System.out.print("Invalid response.\n");
		}
		}
		while (response < 0 && response > 1);
		
		if (response == 0)
		{
			play = 1;
		}

		return play;
	}
}