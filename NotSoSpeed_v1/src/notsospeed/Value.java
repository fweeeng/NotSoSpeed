package notsospeed;

public enum Value 
{
	ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
	KING(13), QUEEN(12), JACK(11);
	
	private int value;
	
	private Value(int value)
	{
		this.value = value;
	}
	
	public int getValue()
	{
		return value;
	}
}
