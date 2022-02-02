package mainClass;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Write a program that converts 10, 50, and 100 kilograms to pounds.  (1lb = .0454kg)
		// TODO Use variables and constants
		// TODO Display the results for each 
		
		int kilo10Int = 10;
		int kilo50Int = 50;
		int kilo100Int = 100;
		final double lbsDouble = 0.0454;
		double conv10Double;
		double conv50Double;
		double conv100Double;
		
		conv10Double = kilo10Int * lbsDouble;
		conv50Double = kilo50Int * lbsDouble;
		conv100Double = kilo100Int * lbsDouble;
		
		System.out.println(conv10Double);
		System.out.println(conv50Double);
		System.out.println(conv100Double);
		
	}

}
