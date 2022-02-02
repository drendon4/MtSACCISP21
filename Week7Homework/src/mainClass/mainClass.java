package mainClass;
import java.util.Scanner;


public class mainClass {

	static Scanner scan = new Scanner(System.in);
	static student stu = new student();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Write a program that will take 10 values 
//		representing exam scores (0-100) for a student.  
//		Then display a menu.
//
//		1 - display Ave score for Student
//		2 - display exam with the highest score
//		3 - display exam with the lowest score
//		4 - display all exam scores
//		0 - exit
//
//		REQUIREMENTS:
//		1.  user-defined class (student_exam_info)
//		2.  use loops, ifs, switch
//		3.  use methods for each menu item
//		4.  error check all entries (menu selections and score entries
		
		int option;
			
		setScore();
		System.out.print("***********************************\n\n");
		System.out.print("Please choose from the following menu option\n\n");
		
		do
		{
			System.out.print("1.\tDisplay Ave score for Student\n2.\tDisplay exam with the highest score\n3.\tDisplay exam with the lowest score\n4.\tDisplay all exam scores\n0.\tExit\n\n");
			option = scan.nextInt();
			if ((option >= 0) && (option <= 4))
			{
				menu(option);
			}
			else
			{
				System.out.print("\nInvalid selection. Must be between 0 - 4. Please select again.\n\n");
			}
		}
		while (option != 0);
	}
	
	public static void setScore()
	{
		int score;
		
		do
		{
		System.out.print("Enter a test value:\t");
		score = scan.nextInt();
		if ((score < 0)||(score > 100))
		{
			System.out.print("\nInvalid value. Please enter a value between 0 - 100.\n\n");
		}
		else
		{
			if (stu.getScore1() == -1)
			{
				stu.setScore1(score);
			}
			else if (stu.getScore2() == -1)
			{
				stu.setScore2(score);
			}
			else if (stu.getScore3() == -1)
			{
				stu.setScore3(score);
			}
			else if (stu.getScore4() == -1)
			{
				stu.setScore4(score);
			}
			else if (stu.getScore5() == -1)
			{
				stu.setScore5(score);
			}
			else if (stu.getScore6() == -1)
			{
				stu.setScore6(score);
			}
			else if (stu.getScore7() == -1)
			{
				stu.setScore7(score);
			}
			else if (stu.getScore8() == -1)
			{
				stu.setScore8(score);
			}
			else if (stu.getScore9() == -1)
			{
				stu.setScore9(score);
			}
			else
			{
				stu.setScore10(score);
			}
		}
		}
		while (stu.getScore10() == -1);
	}
	
	public static void menu(int i)
	{
		switch (i) 
		{
		case 1:
			avgScore();
			break;
		case 2:
			highScore();
			break;
		case 3:
			lowScore();
			break;
		case 4:
			allScore();
			break;
		case 0:
			System.out.print("Good bye!");
			break;
		}
	}
	
	public static void avgScore()
	{
		float avg;
		
		avg = 
		(stu.getScore1() + stu.getScore2() + stu.getScore3() + stu.getScore4() + stu.getScore5() + 
		stu.getScore6() + stu.getScore7() + stu.getScore8() + stu.getScore9() + stu.getScore10())/10;
		
		System.out.print("The average score is " + avg + ".\n\n");
	}
	
	public static void highScore()
	{
		float score;
		
		if (stu.getScore1() > stu.getScore2())
		{
			score = stu.getScore1();
		}
		else
		{
			score = stu.getScore2();
		}
		if (score < stu.getScore3())
		{
			score = stu.getScore3();
		}
		if (score < stu.getScore4())
		{
			score = stu.getScore4();
		}
		if (score < stu.getScore5())
		{
			score = stu.getScore5();
		}
		if (score < stu.getScore6())
		{
			score = stu.getScore6();
		}
		if (score < stu.getScore7())
		{
			score = stu.getScore7();
		}
		if (score < stu.getScore8())
		{
			score = stu.getScore8();
		}
		if (score < stu.getScore9())
		{
			score = stu.getScore9();
		}
		if (score < stu.getScore10())
		{
			score = stu.getScore10();
		}
		System.out.print("The high score is " + score + ".\n\n");
	}
	
	public static void lowScore()
	{
		float score;
		
		if (stu.getScore1() > stu.getScore2())
		{
			score = stu.getScore1();
		}
		else
		{
			score = stu.getScore2();
		}
		if (score > stu.getScore3())
		{
			score = stu.getScore3();
		}
		if (score > stu.getScore4())
		{
			score = stu.getScore4();
		}
		if (score > stu.getScore5())
		{
			score = stu.getScore5();
		}
		if (score > stu.getScore6())
		{
			score = stu.getScore6();
		}
		if (score > stu.getScore7())
		{
			score = stu.getScore7();
		}
		if (score > stu.getScore8())
		{
			score = stu.getScore8();
		}
		if (score > stu.getScore9())
		{
			score = stu.getScore9();
		}
		if (score > stu.getScore10())
		{
			score = stu.getScore10();
		}
		System.out.print("The low score is " + score + ".\n\n");
	}
	
	public static void allScore()
	{
		String score = "";
		
		score = score + "Score 1:\t" + stu.getScore1() + "\n";
		score = score + "Score 2:\t" + stu.getScore2() + "\n";
		score = score + "Score 3:\t" + stu.getScore3() + "\n";
		score = score + "Score 4:\t" + stu.getScore4() + "\n";
		score = score + "Score 5:\t" + stu.getScore5() + "\n";
		score = score + "Score 6:\t" + stu.getScore6() + "\n";
		score = score + "Score 7:\t" + stu.getScore7() + "\n";
		score = score + "Score 8:\t" + stu.getScore8() + "\n";
		score = score + "Score 9:\t" + stu.getScore9() + "\n";
		score = score + "Score 10:\t" + stu.getScore10() + "\n";
		
		System.out.print(score +  "\n\n");
	}
}
