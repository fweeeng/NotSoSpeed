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

	public Value getWordValue()
	{
		return value;
	}
	public String getSuit()
	{
		return suit.getSuit();
	}
	
	
	public String toString()
	{
		return this.suit.toString() + " " + this.value.toString();
	}
}//end class Card
