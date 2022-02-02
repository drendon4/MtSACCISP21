package mainClass;

public class cars extends vehicles
{
	int doors;
	int seats;
	
	public cars(int i, String ma, String mo, String yr, String pd, double pa, double dc, int sd, int ty, int dr, int st) 
	{
		super(i, ma, mo, yr, pd, pa, dc, sd, ty);
		doors = dr;
		seats = st;
	}
	
	public void setDoors(int i)
	{
		doors = i;
	}
	public int getDoors()
	{
		return doors;
	}
	public void setSeats(int i)
	{
		seats = i;
	}
	public int getSeats()
	{
		return seats;
	}
}
