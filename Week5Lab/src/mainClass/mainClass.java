package mainClass;
import java.util.Scanner;
import java.util.Random;

public class mainClass {

	public static void main(String[] args) 
	{
//		You will create a menu 
//		Have the kid select what kind of math problem they want to solve.  
//		Make sure your math problems are displayed 
//		Negative answers are not allowed (HINT:  subtraction problem). 
//		Randomly generate two number, display the problem 
//		Allow the kid to enter the answer.  
//		If the answer is correct.  display a message.  
//		If the answer is incorrect, let the kid know the answer is incorrect and display the correct answer. 
		
		
		//method and classes
		Scanner readin = new Scanner(System.in);
		Random rand= new Random();
		calClass cal = new calClass();
		
		//Variables
		int optionInt = 0;
		int firstInt = rand.nextInt(20)+1;
		int secondInt = rand.nextInt(20)+1;
		int answerInt = 0;
		int solInt = 0;
		int problemInt = 1;
   
		//display menu
		System.out.print("This is a math program. You will be presented with addition, subtraction, multiplication and division problems.\n");
		System.out.print("Please choose the type of problem you would like to solve.\n\n1.\tAddition\n2.\tSubtraction\n3.\tMultiplication\n4.\tDivision\n");
		
		optionInt = readin.nextInt();
		
		switch (optionInt)
		{
		 	case 1:
		 		System.out.print("You've choosen addition.\n" + firstInt + " + " + secondInt + " =\t");
				answerInt = readin.nextInt();
				solInt = cal.setAdd(firstInt, secondInt);
		       	break;
		 	case 2:
		 		System.out.print("You've choosen subtraction.\n");
		 		if (firstInt >= secondInt)
				{
					System.out.print(firstInt + " - " + secondInt + " =\t");
					answerInt = readin.nextInt();
					solInt = cal.setSub(firstInt, secondInt);
				}
				else
				{
					System.out.print(secondInt + " - " + firstInt + " =\t");
					answerInt = readin.nextInt();
					solInt = cal.setSub(secondInt, firstInt);
				}
		       	break;
		 	case 3: 
		 		System.out.print("You've choosen multiplication.\n" + firstInt + " * " + secondInt + " =\t");
				answerInt = readin.nextInt();
				solInt = cal.setMul(firstInt, secondInt);
		       	break;
		 	case 4:
		 		System.out.print("You've choosen division.\n");
				if (firstInt >= secondInt)
				{
					System.out.print(firstInt + " / " + secondInt + " =\t");
					answerInt = readin.nextInt();
					solInt = cal.setDiv(firstInt, secondInt);
				}
				else
				{
					System.out.print(secondInt + " / " + firstInt + " =\t");
					answerInt = readin.nextInt();
					solInt = cal.setDiv(secondInt, firstInt);
				}
		       	break;
		 	default:
		       	System.out.print("Choice must be 1, 2, 3, or 4.\n");
		       	problemInt = 0;
		}

		if ((problemInt == 1) && (answerInt == solInt))
		{
			System.out.print("You are correct.");
		}
		else if ((problemInt == 1) && (answerInt != solInt))
		{
			System.out.print("You are incorrect.\nThe correct answer is " + solInt);
		}

		readin.close();		
	}
}
