package notsospeed;

public enum Suit 
{
	HEART("HEART"), DIAMOND("DIAMOND"), CLOVE("CLOVE"), SPADE("SPADE");
	
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

 
