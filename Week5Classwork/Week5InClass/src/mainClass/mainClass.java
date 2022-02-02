package mainClass;
import java.util.Scanner;

public class mainClass 
{
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//have user enter input
		//determine if number is even or odd
		//fields
		int numInt;		
		
		//instantiate class
		Scanner scan = new Scanner(System.in);
		
		//call method
		InputCheck num = new InputCheck();
	
		//prompt
		System.out.print("Enter a number between 0-99:\t");
		numInt = scan.nextInt();
		
		if ((numInt >= 0) && (numInt <= 99))
		{
//			if (numInt % 2 == 0)
//			{
//				System.out.println("The number entered is even.");
//			}
//			else
//			{
//				System.out.println("The number entered is odd.");
//			}
			num.setNum(numInt);
			if (num.getNum() == 0)
			{
				System.out.println("The number entered is even.");
			}
			else
			{
				System.out.println("The number entered is odd.");
			}
		}
		else
		{
			System.out.println("Number is not between 0-99. Please enter new number.");
		}
		scan.close();
	}

}
