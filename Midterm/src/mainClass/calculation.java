package mainClass;

public class calculation {
	
	float solInt;
	
	public float setAdd(String a, int f, int s)
	{
		System.out.print("You choose addition.\n" + f + a + s + " = \n");
		return solInt = f + s;
	}
	public float setSub(String a, int f, int s)
	{
		System.out.print("You choose subtraction.\n"+ f + a + s + " = \n");
		return solInt = f - s;
	}

	public float setMul(String a, int f, int s)
	{
		System.out.print("You choose multiplication.\n"+ f + a + s + " = \n");
		return solInt = f * s;
	}

	public float setDiv(String a, int f, int s)
	{
		System.out.print("You choose division.\n"+ f + a + s + " = \n");
		return solInt = (float)f / s;
	}
}
