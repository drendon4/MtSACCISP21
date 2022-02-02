package mainClass;
import java.util.Scanner;
import java.util.ArrayList;

public class mainClass 
{	
	static Scanner scan = new Scanner(System.in);
	static int maxAutoID = 0;
	static int maxCustID = 0;

	public static void main(String[] args) 
	{
//		A Mom and Pop used car dealership wants you to create a program that will manage their sales and inventory. 
//		They have provided a menu for you to follow.
//		1. Add To Inventory
//		2. Remove From Inventory
//		3. Update an Inventory Item
//		4. Sale
//		5. Daily Report
//		0. Exit
//
//		REQUIREMENTS: You will use ArrayLists, classes that inherit from another class (super class), 
//		loops, fields, methods, switches, comments throughout your program, error checking.
//		You have to design the classes and the fields you want to track. Be able to apply discount pricing 
//		You will have to track all sales for the day (Sold what to who and how much) and will display all sales for the daily report. 
//		Create an intuitive interface for the user. Create an easy to read report layout 
//		(consistent spaces for each column and column headers) for the daily report 
//		(HINT: column headers you can use…truck info, price/discounted price, customer info)
		
		int option = 1;

		ArrayList<cars> car = new ArrayList<cars>();
		ArrayList<trucks> truck = new ArrayList<trucks>();
		ArrayList<customers> cust = new ArrayList<customers>();
		ArrayList<sales> sold = new ArrayList<sales>();
		
		//Load Data
		System.out.print("MOM AND POP AUTO SHOP\n\n....loading data....\n\n");
		setAuto(car, truck);
		if ((car.size() == 4)&&(truck.size() == 2))
		{
			System.out.print("Data loaded correctly.\n\n");
		}
		else
		{
			truck.removeAll(truck);
			System.out.print("Failed loading data. Please manually load data.\n\n");
		}
		
		//menu
		do
		{
			System.out.print("Please select an option.\n1.\tAdd to Inventory\n2.\tRemove from Inventory\n3.\tUpdate an Inventory Item\n4.\tSale\n5.\tDaily Report\n0.\tExit\n");		
			option = scan.nextInt(); 
			if (verifyHL(0,8, option) == 1)
			{
				menu(option, car, truck, cust, sold);				
			}
		}
		while (option != 0);
		scan.close();
	}
	
	public static void menu(int option, ArrayList<cars> car, ArrayList<trucks> truck, ArrayList<customers> cust, ArrayList<sales> sold)
	{
		switch(option)
		{
		case 1:
			addInventory(car, truck);
			break;
		case 2:
			removeInventory(car, truck);
			break;
		case 3:
			updateInventory(car, truck);
			break;
		case 4:
			sales(car, truck, cust, sold);
			break;
		case 5:
			report(car, truck, cust, sold);
			break;
		case 6:
			printCarAll(car);
			printTruckAll(truck);
			break;
		case 7:
			printCarSold(car, 0);
			printTruckSold(truck, 0);
			printSold(sold);
		case 8:
			printCust(cust);
		case 0:
			System.out.print("Goodbye");
			break;
		}
	}
	
	public static void addInventory(ArrayList<cars> car, ArrayList<trucks> truck)
	{
		int ct = 0;
		String tmpMake = "";
		String tmpModel = "";
		String tmpYear = "";
		String tmpDate = "";
		double tmpAmount = 0.00;
		int tmpDoors = 0;
		int tmpSeats = 0;
		String tmpTrans = "";
		int tmpDrive = 0;
			
		System.out.print("*****ADD TO INVENTORY*****\n\n");

		ct = verifyYN();
		
		System.out.print("Car ID:\t"+ maxAutoID + "\n");
		System.out.print("Enter Make:\t");
		tmpMake = scan.next();
		System.out.print("Enter Model:\t");
		tmpModel = scan.next();
		do
		{
			System.out.print("Enter Year:\t");
			tmpYear = scan.next();
			if (tmpYear.length() != 4)
			{
				System.out.print("Invalid year length.\n");
				tmpYear = "";
			}
		}
		while (tmpYear == "");
		do
		{
			System.out.print("Enter Purchase Date:\t");
			tmpDate = scan.next();
			tmpDate = verifyDate(tmpDate);
		}
		while (tmpDate == "");
		
		System.out.print("Enter Purchase Amount:\t");
		tmpAmount = scan.nextDouble();
		
		if (ct == 1)
		{
			System.out.print("How many doors:\t");
			tmpDoors = scan.nextInt();
			System.out.print("How many seats:\t");
			tmpSeats = scan.nextInt();	
		}
		else
		{
			System.out.print("Transmission Type:\t");
			tmpTrans = scan.next();
			System.out.print("2 or 4 Wheel Drive:\t");
			tmpDrive = scan.nextInt();
		}
		
		if (ct == 1)
		{
		cars c = new cars(maxAutoID, null, null, null, null, 0.00, 1.00, 0, 1, 0, 0);
		c.setMake(tmpMake);
		c.setModel(tmpModel);
		c.setYear(tmpYear);
		c.setPurchaseDate(tmpDate);
		c.setPurchaseAmount(tmpAmount);
		c.setDoors(tmpDoors);
		c.setSeats(tmpSeats);
		car.add(c);	
		}
		else
		{
		trucks t = new trucks(maxAutoID, null, null, null, null, 0.00, 1.00, 0, 2, null, 0);
		t.setMake(tmpMake);
		t.setModel(tmpModel);
		t.setYear(tmpYear);
		t.setPurchaseDate(tmpDate);
		t.setPurchaseAmount(tmpAmount);
		t.setTrans(tmpTrans);
		t.setWheelDrive(tmpDrive);
		truck.add(t);
		}

		maxAutoID++;
		
		System.out.print("*****INVENTORY ADDED*****\n\n");
	}
	
	public static void removeInventory(ArrayList<cars> car, ArrayList<trucks> truck)
	{
		int autoID = 0;

		System.out.print("*****REMOVE FROM INVENTORY*****\n");

		if (verifyYN() == 1)
		{
			do
			{
				System.out.print("Which car would you like to remove? Enter ID:\n");
				printCarSold(car, 0);
				autoID = scan.nextInt();
				autoID = verifyCar(car, autoID);
			}
			while (autoID == 0);
			
			for (int i = 0; i < car.size(); i++)
			{
				if (car.get(i).getID() ==  autoID);
				{
					car.remove(i);
					break;
				}
			}	
		}
		else
		{
			do
			{
				System.out.print("Which truck would you like to remove? Enter ID:\n");
				printTruckSold(truck, 0);
				autoID = scan.nextInt();
				autoID = verifyTruck(truck, autoID);
			}
			while (autoID == 0);
			
			for (int i = 0; i < truck.size(); i++)
			{
				if (truck.get(i).getID() ==  scan.nextInt());
				{
					truck.remove(i);
					break;
				}
			}
		}

		System.out.print("*****INVENTORY REMOVED*****\n");
	}
	
	public static void updateInventory(ArrayList<cars> car, ArrayList<trucks> truck)
	{
		int autoID = 0;
		int ct = 0;
		int response = 0;
		String tmpMake = "";
		String tmpModel = "";
		String tmpYear = "";
		String tmpDate = "";
		double tmpAmount = 0.00;
		double tmpDiscount = 0.00;
		int tmpDoors = 0;
		int tmpSeats = 0;
		String tmpTrans = "";
		int tmpDrive = 0;
		
		System.out.print("*****UPDATE INVENTORY*****\n");
		
		if (verifyYN() == 1)
		{
			do
			{
				System.out.print("Which car would you like to update? Enter car ID:\n");
				printCarSold(car, 0);
				autoID= scan.nextInt();
				autoID = verifyCar(car, autoID);
			}
			while(autoID == 0);
			ct = 1;
		}
		else
		{
			do
			{
				System.out.print("Which truck would you like to update? Enter truck ID:\n");
				printTruckSold(truck, 0);
				autoID = scan.nextInt();
				autoID = verifyTruck(truck, autoID);
			}
			while (autoID == 0);
			ct = 2;
		}
		
		do
		{
			System.out.print("What information would you like to update?\n1.\tMake\n2.\tModel\n3.\tYear\n4.\tPurchase Date\n5.\tPurchase Amount\n6.\tDiscount\n");
			if (ct == 1)
			{
				System.out.print("7.\tDoors\n8.\tSeats\n");			
			}
			else
			{
				System.out.print("7.\tTransmission\n8.\tWheel Drive\n");				
			}
			response = scan.nextInt();
			
			if (verifyHL(1,8,response) == 0)
			{
				response = 0;
			}
		}
		while (response == 0);
	
		switch(response)
		{
		case 1:
			System.out.print("Enter Make:\t");
			tmpMake = scan.next();
			break;
		case 2:
			System.out.print("Enter Model:\t");
			tmpModel = scan.next();
			break;
		case 3:
			do
			{
				System.out.print("Enter Year:\t");
				tmpYear = scan.next();
				if(tmpYear.length() !=4)
				{
					System.out.print("Invalid year length.\n");
					tmpYear = "";
				}
			}
			while (tmpYear =="");
			break;
		case 4:
			do
			{
				System.out.print("Enter Purchase Date:\t");
				tmpDate = scan.next();
				tmpDate = verifyDate(tmpDate);
			}
			while(tmpDate == "");
			break;
		case 5:
			System.out.print("Enter Purchase Amount:\t");
			tmpAmount = scan.nextDouble();
			break;
		case 6:
			System.out.print("Enter Purchase Discount:\t");
			tmpDiscount = scan.nextDouble();
			break;
		case 7:
			if (ct == 1)
			{
				System.out.print("Enter Doors:\t");
				tmpDoors = scan.nextInt();
			}
			else
			{
				System.out.print("Enter Transmission Type:\t");
				tmpTrans = scan.next();
			}
			break;
		case 8:
			if (ct == 1)
			{
				System.out.print("Enter Purchase Discount:\t");
				tmpDiscount = scan.nextDouble();
			}
			else 
			{
				System.out.print("Enter Wheel Drive:\t");
				tmpDrive = scan.nextInt();
			}
			break;
		}
			
		switch(response)
		{
		case 1:
			if (ct == 1)
			{
				for (int i = 0; i < car.size(); i++)
				{
					if (car.get(i).getID() == autoID)
					{
						car.get(i).setMake(tmpMake);
					}
				}
			}
			else 
			{
				for (int i = 0; i < truck.size(); i++)
				{
					if (truck.get(i).getID() == autoID)
					{
						truck.get(i).setMake(tmpMake);
					}
				}				
			}
			break;
		case 2:
			if (ct == 1)
			{
				for (int i = 0; i < car.size(); i++)
				{
					if (car.get(i).getID() == autoID)
					{
						car.get(i).setModel(tmpModel);
					}
				}
			}
			else 
			{
				for (int i = 0; i < truck.size(); i++)
				{
					if (truck.get(i).getID() == autoID)
					{
						truck.get(i).setModel(tmpModel);
					}
				}				
			}
			break;
		case 3:
			if (ct == 1)
			{
				for (int i = 0; i < car.size(); i++)
				{
					if (car.get(i).getID() == autoID)
					{
						car.get(i).setYear(tmpYear);
					}
				}
			}
			else 
			{
				for (int i = 0; i < truck.size(); i++)
				{
					if (truck.get(i).getID() == autoID)
					{
						truck.get(i).setYear(tmpYear);
					}
				}				
			}
			break;
		case 4:
			if (ct == 1)
			{
				for (int i = 0; i < car.size(); i++)
				{
					if (car.get(i).getID() == autoID)
					{
						car.get(i).setPurchaseDate(tmpDate);
					}
				}
			}
			else 
			{
				for (int i = 0; i < truck.size(); i++)
				{
					if (truck.get(i).getID() == autoID)
					{
						truck.get(i).setPurchaseDate(tmpDate);
					}
				}				
			}
			break;
		case 5:
			if (ct == 1)
			{
				for (int i = 0; i < car.size(); i++)
				{
					if (car.get(i).getID() == autoID)
					{
						car.get(i).setPurchaseAmount(tmpAmount);
					}
				}
			}
			else 
			{
				for (int i = 0; i < truck.size(); i++)
				{
					if (truck.get(i).getID() == autoID)
					{
						truck.get(i).setPurchaseAmount(tmpAmount);
					}
				}				
			}
			break;
		case 6:
			if (ct == 1)
			{
				for (int i = 0; i < car.size(); i++)
				{
					if (car.get(i).getID() == autoID)
					{
						car.get(i).setDiscount(tmpDiscount);
					}
				}
			}
			else 
			{
				for (int i = 0; i < truck.size(); i++)
				{
					if (truck.get(i).getID() == autoID)
					{
						truck.get(i).setDiscount(tmpDiscount);
					}
				}				
			}
			break;
		case 7:
			if (ct == 1)
			{
				for (int i = 0; i < car.size(); i++)
				{
					if (car.get(i).getID() == autoID)
					{
						car.get(i).setDoors(tmpDoors);
					}
				}
			}
			else 
			{
				for (int i = 0; i < truck.size(); i++)
				{
					if (truck.get(i).getID() == autoID)
					{
						truck.get(i).setTrans(tmpTrans);
					}
				}				
			}
			break;
		case 8:
			if (ct == 1)
			{
				for (int i = 0; i < car.size(); i++)
				{
					if (car.get(i).getID() == autoID)
					{
						car.get(i).setSeats(tmpSeats);
					}
				}
			}
			else 
			{
				for (int i = 0; i < truck.size(); i++)
				{
					if (truck.get(i).getID() == autoID)
					{
						truck.get(i).setWheelDrive(tmpDrive);
					}
				}				
			}
			break;
		}	

		System.out.print("*****INVENTORY UPDATE*****\n");
	}
	
	public static int addCustomer(ArrayList<customers> cust)
	{
		maxCustID++;
		customers c = new customers(maxCustID, null, null, null, null, null, null, null);

		System.out.print("Enter Customer Information\n");
		System.out.print("Customer ID: " + c.getID() + "\n");
		System.out.print("Customer Last Name:\t");
		c.setLastName(scan.next());
		System.out.print("Customer First Name:\t");
		c.setFirstName(scan.next());
		System.out.print("Customer Address:\t");
		c.setAddress(scan.next());
		System.out.print("Customer City:\t");
		c.setCity(scan.next());
		System.out.print("Customer Zip Code:\t");
		c.setZip(scan.next());
		System.out.print("Customer Phone:\t");
		c.setPhone(scan.next());
		System.out.print("Customer Email:\t");
		c.setEmail(scan.next());
		
		cust.add(c);
				
		return c.getID();
	}
	
	public static void sales(ArrayList<cars> car, ArrayList<trucks> truck, ArrayList<customers> cust, ArrayList<sales> sold)
	{
		sales s = new sales();
		
		int custID = 0;
		int ct = 0;
		int autoID = 0;
		String saleDate = "";
		int response = 0;
		
		System.out.print("*****NEW SALES*****\n");
		
		if(cust.size() == 0)
		{
			custID = addCustomer(cust);
		}
		else		
		{
			do
			{
				System.out.print("Is this a new customer?\n1.\tYes\n0.\tNo\n");
				response = scan.nextInt();
				if (verifyHL(0,1, response) == 0)
				{
					custID = 0;
				}
				else
				{
					if (response == 1)
					{
						custID = addCustomer(cust);
					}
					else
					{
						do
						{
							System.out.print("Please select customer ID\n");
							printCust(cust);
							custID = scan.nextInt();
							custID = verifyCust(cust, custID);
						}
						while(custID == 0);
					}
				}
			}
			while(custID == 0);
		}

		if (verifyYN() == 1)
		{
			do
			{
				System.out.print("Which car is being sold? Enter ID:\n");
				printCarSold(car, 0);
				autoID = scan.nextInt();
				autoID = verifyCar(car, autoID);
			}
			while(autoID == 0);
			ct = 1;
		}
		else
		{
			do
			{
				System.out.print("Which truck is being sold? Enter ID:\n");
				printTruckSold(truck, 0);
				autoID = scan.nextInt();
				autoID = verifyTruck(truck, autoID);
			}
			while(autoID == 0);
			ct = 2;
		}
		
		do
		{
			System.out.print("Enter Sale Date (MM/DD/YYYY):\t");
			saleDate = scan.next();
			saleDate = verifyDate(saleDate);
		}		
		while (saleDate == "");
		
		s.setAutoID(autoID);
		s.setCustID(custID);
		s.setSaleDate(saleDate);
		sold.add(s);
		soldAuto(car, truck, ct, autoID);

		System.out.print("*****SALE COMPLETE*****\n");
	}
	
	public static void soldAuto(ArrayList<cars> car, ArrayList<trucks> truck, int ct, int auto)
	{
		if (ct == 1)
		{
			for(int i = 0; i < car.size(); i++)
			{
				if(car.get(i).getID() == auto)
				{
					car.get(i).setSold(1);
				}
			}
		}
		else
		{
			for(int i = 0; i < truck.size(); i++)
			{
				if(truck.get(i).getID() == auto)
				{
					truck.get(i).setSold(1);
				}
			}
		}
	}
	
	public static void report(ArrayList<cars> car, ArrayList<trucks> truck, ArrayList<customers> cust, ArrayList<sales> sold)
	{
		String saleDate = "";

		do
		{
			System.out.print("Enter a report date (MM/DD/YYYY):\t");
			saleDate = scan.next();
			saleDate = verifyDate(saleDate);
		}		
		while (saleDate == "");
	
		System.out.print("*********************************\n******START OF SALES REPORT******\n");
		for (int i = 0; i < sold.size(); i++)
		{
			if (sold.get(i).getSaleDate().equals(saleDate))
			{
				for (int j = 0; j < cust.size(); j++)
				{
					if (cust.get(j).getID() == sold.get(i).getCustID())
					{
						System.out.print("Customer Name:\t" + cust.get(j).getLastName() + ", " + cust.get(j).getFirstName() + "\n");
						for (int k = 0; k < cust.size(); k++)
						{
							if (car.get(k).getID() == sold.get(i).getAutoID())
							{
								System.out.print("    Make: " + car.get(k).getMake() + "\tModel: " + car.get(k).getModel() + "\n");
							}
							if (truck.get(k).getID() == sold.get(i).getAutoID())
							{
								System.out.print("    Make: " + truck.get(k).getMake() + "\tModel: " + truck.get(k).getModel() + "\n");
							}
						}
					}
				}
			}
		}	
		System.out.print("******END OF SALES REPORT********\n*********************************\n");
	}

	public static int verifyYN()
	{
		int response = 0;
		
		do
		{
			System.out.print("What type of vehicle?\n1.\tCar\n2.\tTruck\n");
			response = scan.nextInt();
			
			if ((response < 1)||( response > 2))
			{			
				errorMessage();
			}
		}
		while ((response < 1)||( response > 2));
		
		return response;
	}
	
	
	public static int verifyHL(int min, int max, int input)
	{
		int valid = 0;
		
		if ((input >= min)&&(input <= max))
		{
			valid = 1;
		}
		else
		{
			errorMessage();
		}
		return valid;
	}
	
	public static int verifyCar(ArrayList<cars> car, int input)
	{
		int autoID = 0;
		
		for (int i = 0; i < car.size(); i++)
		{
			if (car.get(i).getSold() == 0)
			{
				if (car.get(i).getID() == input)
				{
					autoID = input;
				}
			}
			else
			{
				errorMessage();
				autoID = 0;
			}
		}
		return autoID;	
	}
	
	public static int verifyTruck(ArrayList<trucks> truck, int input)
	{
		int autoID = 0;
		
		for (int i = 0; i < truck.size(); i++)
		{
			if (truck.get(i).getSold() == 0)
			{
				if (truck.get(i).getID() == input)
				{
					autoID = input;
				}
			}
			else
			{
				errorMessage();
				autoID = 0;
			}
		}
		return autoID;	
	}
	
	public static int verifyCust(ArrayList<customers> cust, int input)
	{
		int custID = 0;
		
		for (int i = 0; i < cust.size(); i++)
		{
			if (cust.get(i).id == input)
			{
				custID = input;
			}
			else
			{
				errorMessage();
				custID = 0;
			}
		}
		return custID;
	}
	
	public static String verifyDate(String date)
	{
		String saleDate = "";
		String format = "Incorrect Format.\nPlease enter \"MM/DD/YYYY\"\n";

		int min = 1;
		int max = 0;
		
		if (date.length() == 10)
		{			
			if ((date.indexOf("/") == 2)&&(date.lastIndexOf("/") == 5))
				{
					int month = Integer.parseInt(date.substring(0, 2));
					int day = Integer.parseInt(date.substring(3, 5));
					int year = Integer.parseInt(date.substring(7, 10));
					if (month < 10)
					{
						month = Integer.parseInt(date.substring(1, 2));
					}
					if ((month >= 1)&&(month <= 12))
					{
						switch(month)
						{
						case 1:
							max = 31;
							break;
						case 2:
							max = 28;
							if ((year % 4 == 0)&& (year % 100 == 0)&&(year % 400 == 0))
							{
								max = 29;
							}
							break;
						case 3:
							max = 31;
							break;
						case 4:
							max = 30;
							break;
						case 5:
							max = 31;
							break;
						case 6:
							max = 30;
							break;
						case 7:
							max = 31;
							break;
						case 8:
							max = 31;
							break;
						case 9:
							max = 30;
							break;
						case 10:
							max = 31;
							break;
						case 11:
							max = 30;
							break;
						case 12:
							max = 31;
							break;
						}	
						if ((day >= min)&&(day <= max))
						{
							saleDate = date;
						}
						else
						{
							System.out.print(format);
							saleDate = "";
						}
					}
					else
					{
						System.out.print(format);
						saleDate = "";
					}
				}
				else
				{
					System.out.print(format);
					saleDate = "";
				}
			}
			else
			{
				System.out.print(format);
				saleDate = "";
			}
		return saleDate;
	}
	
	public static void errorMessage()
	{
		System.out.print("Please enter a valid option.\n");
	}
		
	public static void setAuto(ArrayList<cars> car, ArrayList<trucks> truck)
	{
		maxAutoID++;
		
		cars c = new cars(maxAutoID, null, null, null, null, 0.00, 1.00, 0, 1, 0, 0);
		c.setMake("Toyota");
		c.setModel("Corolla");
		c.setYear("2010");
		c.setPurchaseDate("10/01/15");
		c.setPurchaseAmount(3000.00);
		c.setDoors(4);
		c.setSeats(4);
		
		car.add(c);
		maxAutoID++;
		
		c = new cars(maxAutoID, null, null, null, null, 0.00, 1.00, 0, 1, 0, 0);
		c.setMake("Toyota");
		c.setModel("Camry");
		c.setYear("2010");
		c.setPurchaseDate("10/01/15");
		c.setPurchaseAmount(5500.00);
		c.setDoors(4);
		c.setSeats(4);
		
		car.add(c);
		maxAutoID++;
	
		trucks t = new trucks(maxAutoID, null, null, null, null, 0.00, 1.00, 0, 2, null, 0);
		t.setMake("Toyota");
		t.setModel("Tundra");
		t.setYear("2013");
		t.setPurchaseDate("10/01/15");
		t.setPurchaseAmount(4300.00);
		t.setTrans("Auto");
		t.setWheelDrive(2);		
		
		truck.add(t);
		maxAutoID++;

		c = new cars(maxAutoID, null, null, null, null, 0.00, 1.00, 0, 1, 0, 0);
		c.setMake("Toyota");
		c.setModel("Corolla");
		c.setYear("2011");
		c.setPurchaseDate("10/01/15");
		c.setPurchaseAmount(2800.00);
		c.setDoors(2);
		c.setSeats(4);
		
		car.add(c);
		maxAutoID++;
		
		t = new trucks(maxAutoID, null, null, null, null, 0.00, 1.00, 0, 2, null, 0);
		t.setMake("Toyota");
		t.setModel("Tacoma");
		t.setYear("2008");
		t.setPurchaseDate("10/01/15");
		t.setPurchaseAmount(1800.00);
		t.setTrans("Manual");
		t.setWheelDrive(4);
		
		truck.add(t);
		maxAutoID++;

		c = new cars(maxAutoID, null, null, null, null, 0.00, 1.00, 0, 1, 0, 0);
		c.setMake("Toyota");
		c.setModel("Tercel");
		c.setYear("1999");
		c.setPurchaseDate("10/01/16");
		c.setPurchaseAmount(8100.00);
		c.setDiscount(.90);
		c.setDoors(2);
		c.setSeats(4);
		
		car.add(c);		
		maxAutoID++;		
	}
	
	public static void printCarAll(ArrayList<cars> car)
	{
		for (int i = 0; i < car.size(); i++)
		{
				System.out.print("ID: "+ car.get(i).getID() 
				+ "\tMake: " + car.get(i).getMake ()
				+ "\tModel: " + car.get(i).getModel() 
				+ "\tYear: " + car.get(i).getYear() 
				+ "\tPurchase Date: " + car.get(i).getPurchaseDate()
				+ "\tPurchase Amount: " + car.get(i).getPurchaseAmount()
				+ "\tDiscount: " + car.get(i).getDiscount()
				+ "\tSale Amount: " + car.get(i).getPurchaseAmount() * car.get(i).getDiscount()
				+ "\tSold: " + car.get(i).getSold()
				+ "\tSeats: " + car.get(i).getSeats()
				+ "\tDoors: " + car.get(i).getDoors()
				+ "\n");			
		}
	}
	
	public static void printCarSold(ArrayList<cars> car, int sold)
	{
		for (int i = 0; i < car.size(); i++)
		{
			if (car.get(i).getSold() == sold)
			{
				System.out.print("ID: "+ car.get(i).getID() 
				+ "\tMake: " + car.get(i).getMake ()
				+ "\tModel: " + car.get(i).getModel() 
				+ "\tYear: " + car.get(i).getYear() 
				+ "\tPurchase Date: " + car.get(i).getPurchaseDate()
				+ "\tPurchase Amount: " + car.get(i).getPurchaseAmount()
				+ "\tDiscount: " + car.get(i).getDiscount()
				+ "\tSale Amount: " + car.get(i).getPurchaseAmount() * car.get(i).getDiscount()
				+ "\tSold: " + car.get(i).getSold()
				+ "\tSeats: " + car.get(i).getSeats()
				+ "\tDoors: " + car.get(i).getDoors()
				+ "\n");
			}
		}
	}
	
	public static void printTruckAll(ArrayList<trucks> truck)
	{
		for (int i = 0; i < truck.size(); i++)
		{
			System.out.print("ID: "+ truck.get(i).getID() 
					+ "\tMake: " + truck.get(i).getMake ()
					+ "\tModel: " + truck.get(i).getModel() 
					+ "\tYear: " + truck.get(i).getYear() 
					+ "\tPurchase Date: " + truck.get(i).getPurchaseDate()
					+ "\tPurchase Amount: " + truck.get(i).getPurchaseAmount()
					+ "\tDiscount: " + truck.get(i).getDiscount()
					+ "\tSale Amount: " + truck.get(i).getPurchaseAmount() * truck.get(i).getDiscount()
					+ "\tSold: " + truck.get(i).getSold()
					+ "\tTransmission: " + truck.get(i).getTrans()
					+ "\tWheel Drive: " + truck.get(i).getWheelDrive()
					+ "\n");
		}
	}
	
	public static void printTruckSold(ArrayList<trucks> truck, int sold)
	{
		for (int i = 0; i < truck.size(); i++)
		{
			if (truck.get(i).getSold() == sold)
			{
				System.out.print("ID: "+ truck.get(i).getID() 
					+ "\tMake: " + truck.get(i).getMake ()
					+ "\tModel: " + truck.get(i).getModel() 
					+ "\tYear: " + truck.get(i).getYear() 
					+ "\tPurchase Date: " + truck.get(i).getPurchaseDate()
					+ "\tPurchase Amount: " + truck.get(i).getPurchaseAmount()
					+ "\tDiscount: " + truck.get(i).getDiscount()
					+ "\tSale Amount: " + truck.get(i).getPurchaseAmount() * truck.get(i).getDiscount()
					+ "\tSold: " + truck.get(i).getSold()
					+ "\tTransmission: " + truck.get(i).getTrans()
					+ "\tWheel Drive: " + truck.get(i).getWheelDrive()
					+ "\n");
			}
		}
	}
	
	public static void printCust(ArrayList<customers> cust)
	{
		for (int i = 0; i < cust.size(); i++)
		{
			System.out.print("Cust ID: "+ cust.get(i).getID() 
					+ "\tLast Name: " + cust.get(i).getLastName()
					+ "\tFirst Name: " + cust.get(i).getFirstName() 
					+ "\tAddress: " + cust.get(i).getAddress() 
					+ "\tCity: " + cust.get(i).getCity()
					+ "\tZip: " + cust.get(i).getZip()
					+ "\tEmail: " + cust.get(i).getEmail()
					+ "\tPhone: " + cust.get(i).getPhone()
					+ "\n");
		}	
	}
	
	public static void printSold(ArrayList<sales> sold)
	{
		for (int i = 0; i < sold.size(); i++)
		{
			System.out.print("truck ID: "+ sold.get(i).getAutoID() 
					+ "\tCust ID: " + sold.get(i).getCustID()
					+ "\tSale Date: " + sold.get(i).getSaleDate() 
					+ "\n");
		}	
	}
}