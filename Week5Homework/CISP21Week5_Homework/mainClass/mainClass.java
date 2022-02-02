package mainClass;
import java.util.Scanner;

public class mainClass 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
//		Write a program that reads a temperature as a whole number from the keyboard and outputs a "probably" season (winter, spring, summer, or fall) depending on the temperature. 
//		-  If the temp >= 90, it is probably summer
//		-  If the temp >= 70 and < 90, it is probably spring
//		-  If the temp >= 50 and < 70, it is probably fall
//		-  If the temp < 50, it probably winter
//		-  If the temp > 110 or < -5, output "the temperature entered is outside the value range."

		//variables
		int tempInt = -111;
		Scanner scan = new Scanner(System.in);
		
		//input
		System.out.print("Enter the temperature:\t");
		tempInt = scan.nextInt();
		
		//if statement
		if ((tempInt > 110) || (tempInt < -5))
		{
			System.out.println("The temperature entered is outside the value range.");
		}
		else if (tempInt >= 90)
		{
			System.out.println("It is probably Summer.");
		}
		else if (tempInt >= 70)
		{
			System.out.println("It is probably Spring.");
		}
		else if (tempInt >= 50)
		{
			System.out.println("It is probably Fall.");
		}
		else
		{
			System.out.println("It is probably Winter.");
		}
	}
}
