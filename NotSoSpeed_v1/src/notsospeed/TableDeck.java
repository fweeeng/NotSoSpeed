package notsospeed;

public class TableDeck extends Deck {

	
	public TableDeck(String type) 
	{
		super(type);
		
	}
	
	public Deck higherDeck(Deck deck)
	{
		Deck higherDeck = deck;
		if(cardTotal() > deck.cardTotal())
		{
			higherDeck = this;
		}
		return higherDeck;
	}

	public boolean compare(Deck higher)
	{
		boolean win = false;
		if(this == higher)
		{
			win = true;
		}
		return win;
	}
}
