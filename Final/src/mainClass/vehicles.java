package mainClass;

public class vehicles 
{
	int id;
	String make;
	String model;
	String year;
	String purchaseDate;
	double purchaseAmount;
	double discount;
	int sold;
	int type;
	
	public vehicles(int i, String ma, String mo, String yr, String pd, double pa, double dc, int sd, int ty)
	{
		id = i;
		make = ma;
		model = mo;
		year = yr;
		purchaseDate = pd;
		purchaseAmount = pa;
		discount = dc;
		sold = sd;
		type  = ty;
	}

	public void setID(int i)
	{
		id = i;
	}
	public int getID()
	{
		return id;
	}
	public void setMake(String s)
	{
		make = s;
	}
	public String getMake()
	{
		return make;
	}
	public void setModel(String s)
	{
		model = s;
	}
	public String getModel()
	{
		return model;
	}
	public void setYear(String s)
	{
		year = s;
	}
	public String getYear()
	{
		return year;
	}
	public void setPurchaseDate(String s)
	{
		purchaseDate = s;
	}
	public String getPurchaseDate()
	{
		return purchaseDate;
	}
	public void setPurchaseAmount(double d)
	{
		purchaseAmount = d;
	}
	public double getPurchaseAmount()
	{
		return purchaseAmount;
	}
	public void setDiscount(double d)
	{
		discount = d;
	}
	public double getDiscount()
	{
		return discount;
	}
	public void setSold(int i)
	{
		sold = i;
	}
	public int  getSold()
	{
		return sold;
	}
	public void setType(int i)
	{
		type = i;
	}
	public int getType()
	{
		return type;
	}
}