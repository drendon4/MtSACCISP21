package mainClass;
import java.util.Scanner;
import java.util.Random;

public class mainClass {

	static Scanner scan = new Scanner(System.in);	
	static Random rand = new Random();
	
	static calculation cal = new calculation();
	
	static results add = new results();
	static results sub = new results();
	static results mul = new results();
	static results div = new results();
	
	static int option;
	
	public static void main(String[] args) 
	{
		//Title message
		System.out.print("***** Math Practice Program*****\nThis program will help you with your math!\n\n");
		
		//Main Program
		do
		{
			System.out.print("Please select the type of math problem you want to solve\n");
			System.out.print("1.\tAddition\n2.\tSubtraction\n3.\tMultiplication\n4.\tDivision\n0.\tExit\n");
			option = scan.nextInt();
			
			//if user select valid option, continue with code
			if ((option >= 0) && (option <= 4))
			{
				equation(rand.nextInt(10)+ 1, rand.nextInt(10)+ 1);
			}
			else
			{
				System.out.print("\nInvalid selection. Must be between 0 - 4. Please select again.\n\n");
			}
	
		}
		while (option != 0);
		
		//If user exits, provide them their score
		System.out.print(score()+ "Good bye!");
	}
	
	//based on user selection, give them the type of equation they want.
	//use class to return question and solution
	public static void equation(int num1, int num2)
	{
		switch (option) 
		{
		case 1:
			problem(cal.setAdd(" + ",num1, num2));
			break;
		case 2:
			problem(cal.setSub(" - ",num1, num2));
			break;
		case 3:
			problem(cal.setMul(" * ", num1, num2));
			break;
		case 4:
			problem(cal.setDiv(" / ",num1, num2));
			break;
		case 0:
			break;
		}
	}
	
	//compare user answer with solution. 
	//if correct, give them a "correct" point for the type of question
	//if incorrect, give them an "incorrect" point for the type of question
	public static void problem(float solution)
	{
		float answer;
		int response;
		
		answer = scan.nextFloat();

		if (answer == solution)
		{
			System.out.print("You are correct! That's one point for you.\n\n");
			correct();
		}
		else
		{
			System.out.print("Sorry. The correct answer is " + solution + ".\n\n");
			incorrect();
		}
		
		//ask user if they want the same type of question again
		//if yes, go back to equation method
		//if no, finish code and start over
		do
		{
		System.out.print("Would you like another similar problem?\n1.\tYes\n0.\tNo\n");
		response = scan.nextInt();
		
		if ((response < 0) && (response > 1))
		{
			System.out.print("Invalid response.\n");
		}
		}
		while (response < 0 && response > 1);
		
		if (response == 1)
		{
		equation(rand.nextInt(10)+ 1, rand.nextInt(10)+ 1);
		}
	}
	
	//calls results class to give correct points
	//based on type of question chosen
	public static void correct()
	{
		switch(option)
		{
		case 1:
			add.setCor();
			break;
		case 2:
			sub.setCor();
			break;
		case 3:
			mul.setCor();
			break;
		case 4:
			div.setCor();
			break;
		}
	}
	
	//calls results class to give incorrect points
	//based on type of question chosen
	public static void incorrect()
	{
		switch(option)
		{
		case 1:
			add.setInc();
			break;
		case 2:
			sub.setInc();
			break;
		case 3:
			mul.setInc();
			break;
		case 4:
			div.setInc();
			break;
		}
	}
	
	//create string to give final score
	//only include points for questions user was asked
	public static String score()
	{
		String finalScore = "Thank you for using this program.\n*****Final Score:*****\n\n";
		
		if ((add.getCor()> 0) || (add.getInc()> 0))
		{
			finalScore = finalScore + "**Addition:**\nCorrect:\t"+ add.getCor() + "\nIncorrect:\t"+ add.getInc() + "\n\n";
		}
		if ((sub.getCor()> 0) || (sub.getInc()> 0))
		{
			finalScore = finalScore + "**Subtraction:**\nCorrect:\t"+ sub.getCor() + "\nIncorrect:\t"+ sub.getInc() + "\n\n";
		}
		if ((mul.getCor()> 0) || (mul.getInc()> 0))
		{
			finalScore = finalScore + "**Multiplication:**\nCorrect:\t"+ mul.getCor() + "\nIncorrect:\t"+ mul.getInc() + "\n\n";
		}
		if ((div.getCor()> 0) || (div.getInc()> 0))
		{
			finalScore = finalScore + "**Divsion:**\nCorrect:\t"+ div.getCor() + "\nIncorrect:\t"+ div.getInc() + "\n\n";
		}
		return finalScore;
	}
}
