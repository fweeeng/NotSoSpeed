package notsospeed;

public class Card 
{
	private Suit suit;
	private Value value;
	
	public Card(Suit suit, Value value)
	{
		this.suit = suit;
		this.value = value;
		
	}//end constructor
	
	public int getValue()
	{
		return value.getValue();
	}
	/*
	public int getVal()
	{
		//card = Integer.parseInt(value[i]);
	}
	*/
	
	public Suit getSuit()
	{
		return this.suit;
	}
	
	
//returns the color of the placed card's suit
//	public String getColor()
//	{
//		if()
//		{
//			
//		}
//	}
	
	public String toString()
	{
		return this.suit.toString() + " " + this.value.toString();
	}
}//end class Card
