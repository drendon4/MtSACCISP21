package mainClass;

public class customers 
{
	int id;
	String lastName;
	String firstName;
	String address;
	String city;
	String zip;
	String email;
	String phone;
	
	public customers(int i, String ln, String fn, String ad, String ct, String zp, String em, String ph)
	{
		id = i;
		lastName = ln;
		firstName = fn;
		address = ad;
		city = ct;
		zip = zp;
		email = em;
		phone = ph;
	}
	
	public void setID(int i)
	{
		id = i;
	}
	public int getID()
	{
		return id;
	}
	public void setLastName(String s)
	{
		lastName = s;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setFirstName(String s)
	{
		firstName = s;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setAddress(String s)
	{
		address= s;
	}
	public String getAddress()
	{
		return address;
	}	
	public void setCity(String s)
	{
		city = s;
	}
	public String getCity()
	{
		return city;
	}	
	public void setZip(String s)
	{
		zip = s;
	}
	public String getZip()
	{
		return zip;
	}	
	public void setEmail(String s)
	{
		email = s;
	}
	public String getEmail()
	{
		return email;
	}	
	public void setPhone(String s)
	{
		phone = s;
	}
	public String getPhone()
	{
		return phone;
	}	
}
