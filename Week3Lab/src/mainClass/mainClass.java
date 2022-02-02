package mainClass;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO calculate the shipping charge for a package, based on weight
		// TODO Display customer name, package id, weight (oz), shipping charge (2 per lbs)
		
		double weightDouble = 16;
		String custNameString = "Dennis Rendon";
		String packageIDString = "abc123";
		double totalShipChgDouble = weightDouble / 16 * 2;
		
		System.out.print("Customer Name:\t\t" + custNameString + "\nPackageID:\t\t" + packageIDString + "\nWeight:\t\t\t"+ weightDouble + " oz.\nShipping Charge:\t" + totalShipChgDouble);		
		
		
		

	}

}
