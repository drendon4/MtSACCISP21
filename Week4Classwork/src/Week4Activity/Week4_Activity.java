package Week4Activity;
//import java.util.Random;
import java.util.Scanner;

public class Week4_Activity 
{
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		// init fields
//		int age = 21;
//		String name = "dennis";
//		String name2 = "How much wood could a woodchuck chuck if a woodchuck could chuck wood?";
//		int str_len = name.length();
//		int str_len2 = name2.length();
//		char str_char = name2.charAt(5);
//		int die;
//		int die2;
				
		
		//Process Data
		// generate random number for two dice
//		Random ran_num = new Random();
//		die = ran_num.nextInt(6) + 1;
//		die2 = ran_num.nextInt(100 - 10 + 1);
		
//		String upper_name = name.toUpperCase();
		
		
		//Display
//		System.out.println(age);
//		System.out.println(name);
//		System.out.println(str_len);
//		System.out.println(str_len2);
//		System.out.println(str_char);
//		System.out.println(die);
//		System.out.println(die2);
//		System.out.println(upper_name);

		
		//call method
		StudentInfo student1 = new StudentInfo();
		StudentInfo student2 = new StudentInfo();
		StudentInfo student3 = new StudentInfo();
		Scanner readin = new Scanner (System.in);
		
		//init variables
		String temp_name;
		String temp_id;
		String temp_major;
		float temp_gpa;
		int temp_age;
		
		//get student 1 information
		System.out.print("Enter first student name: ");
		temp_name = readin.next();
		student1.setName(temp_name);
		
		System.out.print("Enter first student ID: ");
		temp_id = readin.next();
		student1.setID(temp_id);
		
		System.out.print("Enter first student Major: ");
		temp_major = readin.next();
		student1.setMajor(temp_major);
		
		System.out.print("Enter first student GPA: ");
		temp_gpa = readin.nextFloat();
		student1.setGPA(temp_gpa);
		
		System.out.print("Enter first student Age: ");
		temp_age = readin.nextInt();
		student1.setAge(temp_age);
		
		
		//get student 2 information
		System.out.print("Enter second student name: ");
		temp_name = readin.next();
		student2.setName(temp_name);
		
		System.out.print("Enter second student ID: ");
		temp_id = readin.next();
		student2.setID(temp_id);
		
		System.out.print("Enter second student Major: ");
		temp_major = readin.next();
		student2.setMajor(temp_major);
		
		System.out.print("Enter second student GPA: ");
		temp_gpa = readin.nextFloat();
		student2.setGPA(temp_gpa);
		
		System.out.print("Enter second student Age: ");
		temp_age = readin.nextInt();
		student2.setAge(temp_age);
		
		
		
		//get student 3 information		
		System.out.print("Enter third student name: ");
		temp_name = readin.next();
		student3.setName(temp_name);
		
		System.out.print("Enter third student ID: ");
		temp_id = readin.next();
		student3.setID(temp_id);
		
		System.out.print("Enter third student Major: ");
		temp_major = readin.next();
		student3.setMajor(temp_major);
		
		System.out.print("Enter third student GPA: ");
		temp_gpa = readin.nextFloat();
		student3.setGPA(temp_gpa);
		
		System.out.print("Enter third student Age: ");
		temp_age = readin.nextInt();
		student3.setAge(temp_age);
		
		
		
		//Display all student information		
		System.out.println("\nStudent Name:\t" + student1.getName() + "\nStudent ID:\t" +student1.getID()+ "\nStudent Major:\t" + student1.getMajor()+ "\nStudent GPA: \t" +student1.getGPA()+ "\nStudent Age:\t" +student1.getAge()+"\n");
		System.out.println("Student Name:\t" + student2.getName() + "\nStudent ID:\t" +student2.getID()+ "\nStudent Major:\t" + student2.getMajor()+ "\nStudent GPA: \t" +student2.getGPA()+ "\nStudent Age:\t" +student2.getAge()+"\n");
		System.out.println("Student Name:\t" + student3.getName() + "\nStudent ID:\t" +student3.getID()+ "\nStudent Major:\t" + student3.getMajor()+ "\nStudent GPA: \t" +student3.getGPA()+ "\nStudent Age:\t" +student3.getAge()+"\n");

		
		//		System.out.print(temp_name);
		
		
	}
}
