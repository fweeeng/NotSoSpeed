package notsospeed;

public class HandDeck extends Deck {

	private int total;
	
	public HandDeck(String type)
	{
		super(type);
		//this.total = total;
	}
	
	public void show()
	{
		System.out.println(getType() + ": ");
		for(int i = 0; i < size(); i++)
		{
			System.out.println(getCard(i));
		}
		System.out.println();
	}
	
	//getters
	public int getTotal()
	{
		return total;
	}
	
	public boolean checkPlacement(int index, Deck deck)
	{
		//check if card can be placed on table deck
		//by comparing card with previous card
		int handCard = getCard(index).getValue();
		int tableCard = deck.getLast().getValue();
		if(handCard == tableCard + 1 || handCard == tableCard - 1)
		{
			System.out.println("it's a go!");
			return true;
		}
		return false;
	}
	
	
	public void place(int index, Deck deck)
	{
		//if(checkPlacement() == true)
		//add card to tableDeck and remove from handDeck
		if(checkPlacement(index, deck))
		{
			deck.addCard(getCard(index));
			removeCard(index);
		}
		else
		{
			System.out.println("Cannot place card. Choose another");
		}
	}
	

}
