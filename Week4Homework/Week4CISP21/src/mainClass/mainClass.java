package mainClass;
import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO calculate the shipping charge for a package, based on weight
		// TODO Display customer name, package id, weight (oz), shipping charge (2 per lbs)
		
		double weightDouble;
		String custNameString;
		String packageIDString;
		
		Scanner readin = new Scanner(System.in);
		
		System.out.print("Enter Name:");
		custNameString = readin.next();
		System.out.print("Enter Package ID");
		packageIDString = readin.next();
		System.out.print("Enter Package Weight");
		weightDouble = readin.nextDouble();

		System.out.println("*******************Start Order Information*******************");
		System.out.print("Customer Name:\t\t" + custNameString + "\nPackageID:\t\t" + packageIDString + "\nWeight:\t\t\t"+ weightDouble + " oz.\nShipping Charge:\t" + weightDouble / 16 * 2+ "\n");		
		System.out.println("*******************End Order Information*******************");
		

	}

}
