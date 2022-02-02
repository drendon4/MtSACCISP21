package mainClass;
import java.util.Scanner;

public class mainClass 
{
	static Scanner scan = new Scanner(System.in);
	static int option;
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
//		2 classes: student, teacher
//		5 fields per class
//		create menu
//		1 enter student info
//		2 enter teacher info
//		3 display student info
//		4 display teacher info
//		5 update student
//		6 update teacher
//		0 exit

		System.out.print("How many Students?\n");
		studentClass[] students = new studentClass[scan.nextInt()];

		for (int i = 0; i < students.length; i++)
		{
			students[i] = new studentClass();
		}

		System.out.print("How many Teachers?\n");
		teacherClass[] teachers = new teacherClass[scan.nextInt()];		
		
		for (int i = 0; i < teachers.length; i++)
		{
			teachers[i] = new teacherClass();
		}
		
		do
		{
			System.out.print("\nPlease choose an option:\n1:\tAdd Student\n2:\tAdd Teacher\n3.\tView Students\n4.\tView Teachers\n5.\tUpdate Students\n6.\tUpdate Teachers\n0:\tExit\n");
			option = scan.nextInt();
			if ((option < 0) || (option > 6))
			{
				System.out.print("Please enter a valid menu option\n");
			}
			else
			{
				menu(students, teachers);
			}
		}
		while (option != 0);
	}
		
	public static void menu(studentClass students[], teacherClass teachers[])
	{
		switch(option)
		{
		case 1:
			addStudents(students);
			break;
		case 2:
			addTeachers(teachers);
			break;
		case 3:
			viewStudents(students);
			break;
		case 4:
			viewTeachers(teachers);
			break;
		case 5:
			updateStudents(students);
			break;
		case 6:
			updateTeachers(teachers);
			break;
		case 0:
			System.out.print("Good-bye!");
			break;
		}
	}
	public static void addStudents(studentClass students[])
	{
		for (int i = 0; i < students.length; i++)
		{
			students[i].setID(i + 1);
			System.out.print("Student id:\t" + students[i].getID() + "\n");
			System.out.print("Student Last Name:\t");
			students[i].setLastName(scan.next());
			System.out.print("Student First Name:\t");
			students[i].setFirstName(scan.next());
			System.out.print("Student Major Name:\t");
			students[i].setMajorName(scan.next());
			System.out.print("Student GPA:\t");
			students[i].setGPA(scan.next());
		}
	}
	
	public static void addTeachers(teacherClass teachers[])
	{
		for (int i = 0; i < teachers.length; i++)
		{
			teachers[i].setID(i + 1);
			System.out.print("Teacher id:\t" + teachers[i].getID() + "\n");
			System.out.print("Teacher Last Name:\t");
			teachers[i].setLastName(scan.next());
			System.out.print("Teacher First Name:\t");
			teachers[i].setFirstName(scan.next());
			System.out.print("Teacher Major Name:\t");
			teachers[i].setMajorName(scan.next());
			System.out.print("Teacher College Name:\t");
			teachers[i].setCollegeName(scan.next());
		}
	}
	
	public static void viewStudents(studentClass students[])
	{
		for (int i = 0; i < students.length; i++)
		{
			System.out.print("*****STUDENT " + students[i].getID() + " INFORMATION*****\n");
			System.out.print("Student ID:\t" + students[i].getID() + "\n");
			System.out.print("Last Name:\t" + students[i].getLastName() + "\n");
			System.out.print("First Name:\t" + students[i].getFirstName() + "\n");
			System.out.print("Major Name:\t" + students[i].getMajorName() + "\n");
			System.out.print("GPA:\t\t" + students[i].getGPA() + "\n");
			System.out.print("*****END OF STUDENT " + students[i].getID() + " INFORMATION*****\n\n");
		}
	}
	
	public static void viewTeachers(teacherClass teachers[])
	{
		for (int i = 0; i < teachers.length; i++)
		{
			System.out.print("*****TEACHER " + teachers[i].getID() + " INFORMATION*****\n");
			System.out.print("Teacher ID:\t" + teachers[i].getID() + "\n");
			System.out.print("Last Name:\t" + teachers[i].getLastName() + "\n");
			System.out.print("First Name:\t" + teachers[i].getFirstName() + "\n");
			System.out.print("Major Name:\t" + teachers[i].getMajorName() + "\n");
			System.out.print("College Name:\t" + teachers[i].getCollegeName() + "\n");
			System.out.print("*****END OF TEACHER " + teachers[i].getID() + " INFORMATION*****\n\n");
		}
	}
	public static void updateStudents(studentClass students[])
	{
		int stuID;
		int stuInfo;
		
		System.out.print("Which student would you like to update?\n");
		do
		{				
			for (int i = 0; i < students.length; i++)
			{			
				System.out.print("ID: " + students[i].getID() + "\t(" + students[i].getLastName() + ", " + students[i].getFirstName() + ")\n");
			}
			stuID = scan.nextInt();
			if ((stuID < 1)||(stuID >= students.length + 1))
			{
				System.out.print("Please choose a valid ID\n");
			}
		}
		while ((stuID < 1)||(stuID >= students.length + 1));
		stuID = stuID -1;
		
		System.out.print("What information would you like to update?\n");
		do
		{
			System.out.print("1.\tLast Name\n2.\tFirst Name\n3.\tMajor\n4.\tGPA\n");
			stuInfo = scan.nextInt();
			if ((stuInfo < 1)||( stuInfo > 4))
			{
				System.out.print("Please choose a valid option\n");
			}
		}
		while ((stuInfo < 1)||( stuInfo > 4));
		
		switch(stuInfo)
		{
		case 1:
			System.out.print("What is the student's Last Name?\t");
			students[stuID].setLastName(scan.next());
			break;
		case 2:
			System.out.print("What is the student's First Name?\t");
			students[stuID].setFirstName(scan.next());
			break;
		case 3:
			System.out.print("What is the student's Major?\t");
			students[stuID].setMajorName(scan.next());
			break;
		case 4:
			System.out.print("What is the student's GPA?\t");
			students[stuID].setGPA(scan.next());
			break;
		}		
	}
	
	public static void updateTeachers(teacherClass teachers[])
	{
		int teachID;
		int teachInfo;
		
		System.out.print("Which student would you like to update?\n");
		do
		{
			for (int i = 0; i < teachers.length; i++)
			{			
				System.out.print("ID: " + teachers[i].getID() + "\t(" + teachers[i].getLastName() + ", " + teachers[i].getFirstName() + ")\n");
			}
			teachID = scan.nextInt();
			if ((teachID < 1)||(teachID >= teachers.length + 1))
			{
				System.out.print("Please choose a valid ID\n");
			}
		}
		while ((teachID < 1)||(teachID >= teachers.length + 1));
	
		teachID = teachID - 1;
	
		System.out.print("What information would you like to update?\n");
		do
		{
			System.out.print("1.\tLast Name\n2.\tFirst Name\n3.\tMajor\n4.\tCollege\n");
			
			teachInfo = scan.nextInt();
			if ((teachInfo < 1)||( teachInfo > 4))
			{
				System.out.print("Please choose a valid option\n");
			}
		}
		while ((teachInfo < 1)||( teachInfo > 4));
	
		switch(teachInfo)
		{
		case 1:
			System.out.print("What is the teacher's Last Name?\t");
			teachers[teachID].setLastName(scan.next());
			break;
		case 2:
			System.out.print("What is the teacher's First Name?\t");
			teachers[teachID].setFirstName(scan.next());
			break;
		case 3:
			System.out.print("What is the teacher's Major?\t");
			teachers[teachID].setMajorName(scan.next());
			break;
		case 4:
			System.out.print("What is the teacher's College?\t");
			teachers[teachID].setCollegeName(scan.next());
			break;
		}		
	}
}
