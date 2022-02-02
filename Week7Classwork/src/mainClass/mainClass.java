package mainClass;
import java.util.Scanner;

public class mainClass 
{
	static autoInfo auto1 = new autoInfo();
	static autoInfo auto2 = new autoInfo();
	static autoInfo auto3 = new autoInfo();
	static Scanner readin = new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Enter three auto
		//Display auto with highest MPG
		//Display auto with lowest MPG
		//Display all auto info
		//Exit
		
		setAutoInfo();
		autoMPGRrate();
		autoMenu();
	}
	
	public static void setAutoInfo()
	{
//		System.out.print("Please enter a make:\n");
//		tempMakeString = readin.next();
//		auto1.setMake(tempMakeString);
//		
//		System.out.print("Please enter a model:\n");
//		tempModelString = readin.next();
//		auto1.setModel(tempModelString);
//		
//		System.out.print("Please enter a mpg:\n");
//		tempMPGInt = readin.nextInt();
//		auto1.setMPG(tempMPGInt);
//		
//		System.out.print("Please enter a make:\n");
//		tempMakeString = readin.next();
//		auto2.setMake(tempMakeString);
//		
//		System.out.print("Please enter a model:\n");
//		tempModelString = readin.next();
//		auto2.setModel(tempModelString);
//		
//		System.out.print("Please enter a mpg:\n");
//		tempMPGInt = readin.nextInt();
//		auto2.setMPG(tempMPGInt);
//		
//		System.out.print("Please enter a make:\n");
//		tempMakeString = readin.next();
//		auto3.setMake(tempMakeString);
//		
//		System.out.print("Please enter a model:\n");
//		tempModelString = readin.next();
//		auto3.setModel(tempModelString);
//		
//		System.out.print("Please enter a mpg:\n");
//		tempMPGInt = readin.nextInt();
//		auto3.setMPG(tempMPGInt);	
		
		auto1.setMake("Toyota");
		auto1.setModel("Corolla");
		auto1.setMPG(32);
		
		auto2.setMake("Toyota");
		auto2.setModel("Tercel");
		auto2.setMPG(34);

		auto3.setMake("Toyota");
		auto3.setModel("Tundra");
		auto3.setMPG(18);
	}
	
	public static void autoMenu()
	{
		int menuInt;
		
		do
		{
			System.out.print("Please choose an option:\n1. Display auto with HIGHEST mpg\n2. Display auto with LOWEST mpg\n3. Display ALL auto information\n0. Exit\n");
			menuInt = readin.nextInt();

			//check entry
			if ((menuInt < 0) || (menuInt > 3))
			{
				System.out.print("Plese choose a valid menu option.\n\n");
			}
			else 
			{
				switch(menuInt)
				{
					case 1:
						autoInfoDisplay(1);
						break;
					case 2:
						autoInfoDisplay(3);
						break;
					case 3:
						autoInfoDisplay(0);
						break;
				}
			}
		}
		//repeat display until exit
		while (menuInt != 0);
		System.out.print("Goodbye");
		
		readin.close();
	}
	
	public static void autoInfoDisplay(int i)
	{
		int optionInt = i;

		String autoDisplay = "" ;		
		String autoInfo1 = "Auto 1 Info:\nMake:\t"+auto1.getMake()+"\nModel:\t"+auto1.getModel()+"\nMPG:\t"+auto1.getMPG()+"\n\n";
		String autoInfo2 = "Auto 2 Info:\nMake:\t"+auto2.getMake()+"\nModel:\t"+auto2.getModel()+"\nMPG:\t"+auto2.getMPG()+"\n\n";
		String autoInfo3 = "Auto 3 Info:\nMake:\t"+auto3.getMake()+"\nModel:\t"+auto3.getModel()+"\nMPG:\t"+auto3.getMPG()+"\n\n";
		
		if (auto1.getMPGRating()== optionInt)
		{
			autoDisplay = autoDisplay + autoInfo1;
		}
		if (auto2.getMPGRating()== optionInt)
		{
			autoDisplay = autoDisplay + autoInfo2;
		}
		if (auto3.getMPGRating()== optionInt)
		{
			autoDisplay = autoDisplay + autoInfo3;
		}
		if (optionInt == 0)
		{
			autoDisplay = autoInfo1 + autoInfo2 + autoInfo3;
		}
		
		System.out.print(autoDisplay);
	}
	public static void autoMPGRrate()
	{
//		System.out.print("0 Setting\n\nauto1\t" + auto1.getMPG() + "\tauto2\t" + auto2.getMPG()+ "\tauto3\t" + auto3.getMPG()+ "\n\n");
		if (auto1.getMPG() > auto2.getMPG())
		{
			auto1.setMPGRating(1);
			auto2.setMPGRating(2);			
		}
		else if (auto1.getMPG() < auto2.getMPG())
		{
			auto1.setMPGRating(2);
			auto2.setMPGRating(1);
		}
		else
		{
			auto1.setMPGRating(2);
			auto2.setMPGRating(2);
		}
		
//		System.out.print("1 Setting\n\nauto1\t" + auto1.getMPGRating() + "\tauto2\t" + auto2.getMPGRating()+ "\tauto3\t" + auto3.getMPGRating()+ "\n\n");
		
		if (auto1.getMPGRating() == 1)
		{
			
			if (auto3.getMPG() > auto1.getMPG())
			{
				auto1.setMPGRating(2);
				auto2.setMPGRating(3);
				auto3.setMPGRating(1);
			}
			else if (auto3.getMPG() > auto2.getMPG())
			{
				auto1.setMPGRating(1);
				auto2.setMPGRating(3);
				auto3.setMPGRating(2);
			}
			else 
			{
				auto1.setMPGRating(1);
				auto2.setMPGRating(3);
				auto3.setMPGRating(3);
			}
		}
		else if (auto2.getMPGRating() == 1)
		{
			if (auto3.getMPG() > auto2.getMPG())
			{
				auto1.setMPGRating(3);
				auto2.setMPGRating(2);
				auto3.setMPGRating(1);
			}
			else if (auto3.getMPG() > auto1.getMPG())
			{
				auto1.setMPGRating(3);
				auto2.setMPGRating(1);
				auto3.setMPGRating(2);
			}
			else 
			{
				auto1.setMPGRating(3);
				auto2.setMPGRating(1);
				auto3.setMPGRating(3);
			}
		}
		else
		{
			if (auto3.getMPG() > auto1.getMPG())
			{
				auto1.setMPGRating(3);
				auto2.setMPGRating(3);
				auto3.setMPGRating(1);
			}
			else if (auto3.getMPG() < auto1.getMPG())
			{
				auto1.setMPGRating(1);
				auto2.setMPGRating(1);
				auto3.setMPGRating(3);
			}
			else
			{
				auto1.setMPGRating(1);
				auto2.setMPGRating(1);
				auto3.setMPGRating(1);
			}
		}
//		System.out.print("2 Setting\n\nauto1\t" + auto1.getMPGRating() + "\tauto2\t" + auto2.getMPGRating()+ "\tauto3\t" + auto3.getMPGRating()+ "\n\n");
	}
}






