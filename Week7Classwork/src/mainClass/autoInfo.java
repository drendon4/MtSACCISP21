package mainClass;

public class autoInfo 
{
	private String makeString;
	private String modelString;
	private int mpgInt;
	private int mpgRatingInt;
		
	public void setMake(String s)
	{
		makeString = s;
	}
	public String getMake()
	{
		return makeString;
	}
	public void setModel(String s)
	{
		modelString = s;
	}
	public String getModel()
	{
		return modelString;
	}
	public void setMPG(int i)
	{
		mpgInt = i;
	}
	public int getMPG()
	{
		return mpgInt;
	}
	public void setMPGRating(int i)
	{
		mpgRatingInt = i;
	}
	public int getMPGRating()
	{
		return mpgRatingInt;
	}
}