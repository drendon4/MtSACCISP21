package mainClass;
import java.util.Scanner;

public class mainClass 
{

	static Scanner scan = new Scanner(System.in);
	static int players;
			
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
//		Write a program that will store the Lakers (or your favorite basketball team) roster in an array.  
//		You will then loop through the array to display each player and their information.
//		Information needed for each player:  First Name, Last Name, Jersey Number, Position, College Attended.
//		REQUIREMENTS:
//		- use fields, methods, user-defined class, FOR loops, array.
//		- you will have to research the roster for the information and prompt the user to enter each player's info.  
//		  After info is complete.  Display roster

//	Laker Roster		
//	Num		First		Last		NO.	POS	COLLEGE
//	1		Tarik		Black		28	C	Kansas
//	2		Jose		Calderon	5	PG	None
//	3		Jordan		Clarkson	6	PG	Missouri
//	4		Luol		Deng		9	SF	Duke
//	5		Marcelo		Huertas		4	PG	None
//	6		Brandon		Ingram		14	SF	Duke
//	7		Timofey		Mozgov		20	C	None
//	8		Larry		Nance Jr.	7	PF	Wyoming
//	9		Julius		Randle		30	PF	Kentucky
//	10		Thomas		Robinson	15	PF	Kansas
//	11		D'Angelo	Russell		1	PG	Ohio_State
//	12		Louis		Williams	23	SG	None
//	13		Metta		World Peace	37	SF	St_John
//	14		Nick		Young		0	SG	USC
//	15		Ivica		Zubac		40	C	None

		System.out.print("How many players are on the roster?\n");
		int players = scan.nextInt();  
		
		roster[] playerArray = new roster[players];
		
		for (int i = 0; i < playerArray.length; i++)
			{
				playerArray[i] = new roster();
			}
		
		for (int i = 0; i < players; i++)
		{
			questions(playerArray, i);
		}

		System.out.print("\n\n**********Team Information**********\n");		

		for (int i = 0; i < players; i++)
		{
			team(playerArray, i);
		}
		scan.close();
	}
	
	public static void questions(roster playerArray[], int i)
	{
			System.out.print("What is player " + (i + 1) + "'s First Name?\n");
			playerArray[i].setFirstName(scan.next());
			System.out.print("What is player " + (i + 1) + "'s Last Name?\n");
			playerArray[i].setLastName(scan.next());
			System.out.print("What is player " + (i + 1) + "'s Jersey Number?\n");
			playerArray[i].setJerseyNumber(scan.next());
			System.out.print("What is player " + (i + 1) + "'s Position?\n");
			playerArray[i].setPosition(scan.next());
			System.out.print("What is player " + (i + 1) + "'s College?\n");
			playerArray[i].setCollege(scan.next());
			System.out.print("\n*****Player "+ (i + 1) + " information saved.*****\n");
	}
	
	public static void team(roster playerArray[], int i)
	{
		System.out.print("\nPlayer "+ (i + 1) + "\n");
		System.out.print("First Name:\t" + playerArray[i].getFirstName()+ "\n");
		System.out.print("Last Name:\t" + playerArray[i].getLastName()+ "\n");
		System.out.print("Jersey Number:\t" + playerArray[i].getJerseyNumber()+ "\n");
		System.out.print("Position:\t" + playerArray[i].getPosition()+ "\n");
		System.out.print("College:\t" + playerArray[i].getCollege()+ "\n");
	}
}
