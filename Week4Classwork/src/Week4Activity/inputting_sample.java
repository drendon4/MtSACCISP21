package Week4Activity;

//import java.util.Scanner;
import javax.swing.JOptionPane;


public class inputting_sample {

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		//variables
//		String my_fname, my_lname, my_sex;
//		int my_age;
//		
//		Scanner readin = new Scanner (System.in);
//		
//		System.out.print("Enter your first name: ");
//		my_fname = readin.nextLine();
//		
//		System.out.print("Enter your last name: ");
//		my_lname = readin.next();
//		
//		System.out.print("Enter your age: ");
//		my_age = readin.nextInt();
//		
//		System.out.print("Enter Sex (M or F): ");
//		my_sex = readin.next();
//		
//		//display student information
//		System.out.print("\n\n*****  Student Info *****\n");
//		System.out.print("Name:\t" +my_fname.toUpperCase().charAt(0) + my_fname.substring(1).toLowerCase() +" " + my_lname.toUpperCase().charAt(0) + my_lname.substring(1).toLowerCase() + "\nAge:\t"+my_age+"\nSex:\t"+my_sex.toUpperCase()+"\n");
//		System.out.print("*****  End of Info  *****\n");
		
		//variables
		String fname = JOptionPane.showInputDialog(null, "Please enter your first name: ");
		String lname = JOptionPane.showInputDialog(null, "Please enter your last name: ");
		String age = JOptionPane.showInputDialog(null, "Please enter your age: ");
				
		JOptionPane.showMessageDialog(null,  "Hello "+ fname + " " + lname + ".\nYou are " + age + " years old.");
	
//		student_info stul = new student_info();
//		stul.setStudentFname(JOptionPane.showInputDialog(null, "Please enter your first name: "))
		
		
		
		
		
	}

}
