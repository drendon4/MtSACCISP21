package mainClass;
import java.util.Scanner;
import java.util.ArrayList;

public class mainClass 
{
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		// Develop a program that will allow the user to display the starting line and bench for a basketball team. 
		// The user will also have the option of swapping out players from the starting line up with those from the bench.
		// The last option will be to set a starting lineup
		
		// Sample menu (from class):
		// 1. Display Starting Lineup
		// 2. Display Bench Players
		// 3. Swap in a player
		// 4. Set Starting lineup
		// 0. Exit

		//REQUIREMENTS:
		//-  Use ArrayLists
		//-  User defined class
		//-  Pseudocode/Flowchart
		//-  Error check all selections
		
//	Laker Roster		
//	Num		First		Last		NO.	POS	COLLEGE		Start
//	1		Tarik		Black		28	C	Kansas		0
//	2		Jose		Calderon	5	PG	None		0
//	3		Jordan		Clarkson	6	PG	Missouri	1
//	4		Luol		Deng		9	SF	Duke		1
//	5		Marcelo		Huertas		4	PG	None		0
//	6		Brandon		Ingram		14	SF	Duke		0
//	7		Timofey		Mozgov		20	C	None		1
//	8		Larry		Nance Jr.	7	PF	Wyoming		0
//	9		Julius		Randle		30	PF	Kentucky	1	
//	10		Thomas		Robinson	15	PF	Kansas		0
//	11		D'Angelo	Russell		1	PG	Ohio_State	1
//	12		Louis		Williams	23	SG	None		0
//	13		Metta		World Peace	37	SF	St_John		0
//	14		Nick		Young		0	SG	USC			0	
//	15		Ivica		Zubac		40	C	None		0

		
		int opt;
	
		ArrayList<roster> teams = new ArrayList<roster>();
		
		setRoster(teams);
	
		do
		{
			System.out.print("Please select an option\n1.\tDisplay Starting Lineup\n2.\tDisplay Bench Players\n3.\tSwap in a player\n4.\tSet Starting lineup\n0.\tExit\n");
			opt = scan.nextInt();
			if ((opt < 0) || (opt > 4))
			{
				errorMessage();
			}
			else
			{
				menu(teams, opt);
			}
		}
		while (opt != 0);
		
		scan.close();
	}
	
	public static void errorMessage()
	{
		System.out.print("Please enter a valid selection.\n\n");
	}
	
	public static int checkJersey(ArrayList<roster> teams, int jer, int SB)
	{
		int check = 0;
		
		for (int i = 0; i < teams.size(); i++)
		{
			if ((teams.get(i).getJerseyNumber() == jer)&&(teams.get(i).getStarting() == SB))
			{
				check = 1;
			}
		}
		return check;
	}
	
	public static void menu(ArrayList<roster> teams, int opt)
	{
		switch(opt)
		{
		case 1:
			System.out.print("****STARTING LINEUP*****\n");
			displayLineup(teams, 1);
			System.out.print("*****END OF LINEUP*****\n\n");
			break;
		case 2:
			System.out.print("****BENCHED LINEUP*****\n");
			displayLineup(teams, 0);
			System.out.print("*****END OF LINEUP*****\n\n");
			break;
		case 3:
			swapPlayers(teams);
			System.out.print("*****SWAP COMPLETE*****\n\n");
			break;
		case 4:
			setStarting(teams);
			System.out.print("*****STARTING LINEUP SET*****\n\n");
			break;
		case 0:
			System.out.print("Good-bye\n");
			break;
		}
	}

	public static void displayLineup(ArrayList<roster> teams, int SB)
	{
		for (int i = 0; i < teams.size(); i++)
		{
			if (teams.get(i).getStarting() == SB)
			{
				System.out.print(teams.get(i).getLastName() + ", " + teams.get(i).getFirstName());
				if (teams.get(i).getLastName().length() + teams.get(i).getFirstName().length() + 2 >= 16)
				{
					System.out.print("\t");
				}
				else
				{
					System.out.print("\t\t");
				}
				System.out.print("Jersey Number: " + teams.get(i).getJerseyNumber() + "\tPosition: " + teams.get(i).getPosition() + "\tCollege: " + teams.get(i).getCollege() + "\n");
			}
		}
	}
	
	public static void swapPlayers(ArrayList<roster> teams)
	{
		int select;
		int repeat;
		int valid;
		
		do
		{
			do
			{
				valid = 0;
	
				System.out.print("Which player would you like to bench?\nEnter the Jersey Number.\n");
				displayLineup(teams, 1);
				select = scan.nextInt();
				valid = checkJersey(teams, select, 1);
				if (valid  == 1)
				{
					for (int i = 0; i < teams.size(); i++)
					{
						if (teams.get(i).getJerseyNumber() == select)
						{
							teams.get(i).setStarting(-1);
						}
					}
				}
				else 
				{
					errorMessage();
				}
			}
			while(valid == 0);
			
			startPlayer(teams);
			
			for (int i = 0; i < teams.size(); i++)
			{
				if (teams.get(i).getStarting() == -1)
				{
					teams.get(i).setStarting(0);
				}
			}

			do
			{
				System.out.print("Another swap?\n1.\tYes\n0.\tNo\n");
				repeat = scan.nextInt();
				if ((repeat < 0)|| (repeat > 1))
				{
					errorMessage();
				}
			}
			while ((repeat < 0)||(repeat > 1));
		}
		while (repeat != 0);
		
		menu(teams, 1);
		menu(teams, 2);
	}
	
	public static void setStarting(ArrayList<roster> teams)
	{
		int starters = 0;
		
		for(int i = 0; i < teams.size(); i++)
		{
			teams.get(i).setStarting(0);
		}
		
		System.out.print("****FULL LINEUP*****\n");
		
		do
		{
			startPlayer(teams);
			starters++;
		}
		while (starters < 5);
		
		menu(teams, 1);
		menu(teams, 2);
	}
	
	public static void startPlayer(ArrayList<roster> teams)
	{
		int select;
		int valid = 0;
		do
		{
			System.out.print("Which player would you like to start?\nEnter the Jersey Number.\n");
			displayLineup(teams, 0);
			select = scan.nextInt();
			valid = checkJersey(teams, select, 0);
			if (valid  == 1)
			{		
				for (int i = 0; i < teams.size(); i++)
				{
					if (teams.get(i).getJerseyNumber() == select)
					{
						teams.get(i).setStarting(1);
					}
				}	
			}			
			else 
			{
				errorMessage();
			}
		}
		while(valid == 0);
	}
	
	public static void setRoster(ArrayList<roster> teams)
	{
		roster player = new roster();
		
		player.setFirstName("Tarik");
		player.setLastName("Black");
		player.setJerseyNumber(28);
		player.setPosition("C");
		player.setCollege("Kansas");
		player.setStarting(0);
		
		teams.add(player);
		player = new roster();
		
		player.setFirstName("Jose");
		player.setLastName("Calderon");
		player.setJerseyNumber(5);
		player.setPosition("PG");
		player.setCollege("None");
		player.setStarting(0);
		
		teams.add(player);
		player = new roster();
		
		player.setFirstName("Jordan");
		player.setLastName("Clarkson");
		player.setJerseyNumber(6);
		player.setPosition("PG");
		player.setCollege("Missouri");
		player.setStarting(1);
		
		teams.add(player);
		player = new roster();
		
		player.setFirstName("Luol");
		player.setLastName("Deng");
		player.setJerseyNumber(9);
		player.setPosition("SF");
		player.setCollege("Duke");
		player.setStarting(1);
		
		teams.add(player);
		player = new roster();
		
		player.setFirstName("Marcelo");
		player.setLastName("Huertas");
		player.setJerseyNumber(4);
		player.setPosition("PG");
		player.setCollege("None");
		player.setStarting(0);
		
		teams.add(player);
		player = new roster();
		
		player.setFirstName("Brandon");
		player.setLastName("Ingram");
		player.setJerseyNumber(14);
		player.setPosition("SF");
		player.setCollege("Duke");
		player.setStarting(0);
		
		teams.add(player);
		player = new roster();
		
		player.setFirstName("Timofey");
		player.setLastName("Mozgov");
		player.setJerseyNumber(20);
		player.setPosition("C");
		player.setCollege("None");
		player.setStarting(1);
		
		teams.add(player);
		player = new roster();
		
		player.setFirstName("Larry");
		player.setLastName("Nance Jr.");
		player.setJerseyNumber(7);
		player.setPosition("PF");
		player.setCollege("Wyoming");
		player.setStarting(0);
		
		teams.add(player);
		player = new roster();
		
		player.setFirstName("Julius");
		player.setLastName("Randle");
		player.setJerseyNumber(30);
		player.setPosition("PF");
		player.setCollege("Kentucky");
		player.setStarting(1);
		
		teams.add(player);
		player = new roster();
		
		player.setFirstName("Thomas");
		player.setLastName("Robinson");
		player.setJerseyNumber(15);
		player.setPosition("PF");
		player.setCollege("Kansas");
		player.setStarting(0);
		
		teams.add(player);
		player = new roster();
		
		player.setFirstName("D'Angelo");
		player.setLastName("Russell");
		player.setJerseyNumber(1);
		player.setPosition("PG");
		player.setCollege("Ohio_State");
		player.setStarting(1);
		
		teams.add(player);
		player = new roster();
		
		player.setFirstName("Louis");
		player.setLastName("Williams");
		player.setJerseyNumber(23);
		player.setPosition("SG");
		player.setCollege("None");
		player.setStarting(0);
		
		teams.add(player);
		player = new roster();
		
		player.setFirstName("Metta");
		player.setLastName("World Peace");
		player.setJerseyNumber(37);
		player.setPosition("SF");
		player.setCollege("St_John");
		player.setStarting(0);
		
		teams.add(player);
		player = new roster();
		
		player.setFirstName("Nick");
		player.setLastName("Young");
		player.setJerseyNumber(0);
		player.setPosition("SG");
		player.setCollege("USC");
		player.setStarting(0);
		
		teams.add(player);
		player = new roster();
		
		player.setFirstName("Ivica");
		player.setLastName("Zubac");
		player.setJerseyNumber(40);
		player.setPosition("C");
		player.setCollege("None");
		player.setStarting(0);
		
		teams.add(player);
	}
}
