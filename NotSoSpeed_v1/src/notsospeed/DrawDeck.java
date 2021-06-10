package notsospeed;

public class DrawDeck extends Deck 
{

	public DrawDeck(String type) 
	{
		super(type);
		//this.count = count;
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
	

}
