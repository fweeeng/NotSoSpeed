package notsospeed;

public class DrawDeck extends Deck 
{
	private static int count = 0;

	public DrawDeck(String type) 
	{
		super(type);
		this.count = count;
		this.createFullDeck();
	}
	
	public void createFullDeck()
	{
		for(Suit cardSuit: Suit.values())
		{
			for(Value cardValue: Value.values())
			{
				//add NEW cards to the list
				getCards().add(new Card(cardSuit,cardValue));
			}
		}
	}
	
	//display number of cards left to place in table decks
	public int getCount()
	{
		return count;
	}
	
	

}
