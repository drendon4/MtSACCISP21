package mainClass;

public class results 
{
	int correct;
	int incorrect;
	
	public void setCor()
	{
		correct = correct + 1;
	}
	public int getCor()
	{
		return correct;
	}
	public void setInc()
	{
		incorrect = incorrect + 1;
	}
	public int getInc()
	{
		return incorrect;
	}
}