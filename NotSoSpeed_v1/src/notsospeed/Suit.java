package notsospeed;

public enum Suit 
{
	HEART("@"), DIAMOND("#"), CLOVE("%"), SPADE("^");
	
	private String suit;
	
	private Suit(String suit)
	{
		this.suit = suit;
	}
	
	public String getSuit()
	{
		return suit;
	}
}

 
