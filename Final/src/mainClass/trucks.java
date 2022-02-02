package mainClass;

public class trucks extends vehicles
{
	String trans;
	int wheelDrive;
	
	public trucks(int i, String ma, String mo, String yr, String pd, double pa, double dc, int sd, int ty, String tr, int wd) 
	{
		super(i, ma, mo, yr, pd, pa, dc, sd, ty);
		trans = tr;
		wheelDrive = wd;
	}
	public void setTrans(String s)
	{
		trans = s;
	}
	public String getTrans()
	{
		return trans;
	}
	public void setWheelDrive(int i)
	{
		wheelDrive = i;
	}
	public int getWheelDrive()
	{
		return wheelDrive;
	}
}
