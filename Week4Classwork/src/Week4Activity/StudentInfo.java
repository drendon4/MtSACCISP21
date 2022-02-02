package Week4Activity;

public class StudentInfo {
	
	private String student_name;
	private String student_id;
	private String student_major;
	private float student_gpa;
	private int student_age;
	
	//methods
	public void setName(String s)
	{
		student_name = s;
	}
	
	public String getName()
	{
		return student_name;
	}
	
	public void setID(String s)
	{
		student_id = s;
	}
	
	public String getID()
	{
		return student_id;
	}
	
	public void setMajor(String s)
	{
		student_major = s;
	}
	
	public String getMajor()
	{
		return student_major;
	}
	
	public void setGPA(float f)
	{
		student_gpa = f;
	}
	
	public float getGPA()
	{
		return student_gpa;
	}
	
	public void setAge(int i)
	{
		student_age = i;
	}
	
	public int getAge()
	{
		return student_age;
	}
	

}
