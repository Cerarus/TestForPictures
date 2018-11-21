package model;

public class Couple
{

	private Dancer man,lady;
	private int number;
	
	
	public Couple(int number)
	{
		this.number = number;
		man = new Dancer();
		lady = new Dancer();
	}
	
	public Dancer getMan()
	{
		return man;
	}

	public void setMan(Dancer man)
	{
		this.man = man;
	}

	public Dancer getLady()
	{
		return lady;
	}

	public void setLady(Dancer lady)
	{
		this.lady = lady;
	}

	public int getNumber()
	{
		return number;
	}
	
	
}
