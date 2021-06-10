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
	
	public boolean checkPlacement(int index, Deck d)
	{
		//check if card can be placed on table deck
		//by comparing card with previous card
		int handCard = getCard(index).getValue();
		int tableCard = d.getLast().getValue();
		if(handCard == tableCard + 1 || handCard == tableCard - 1)
		{
			System.out.println("it's a go!");
			return true;
		}
		return false;
	}
	
	
	public void place(int index, Deck d)
	{
		//if(checkPlacement() == true)
		//add card to tableDeck and remove from handDeck
		if(checkPlacement(index, d))
		{
			d.addCard(getCard(index));
			removeCard(index);
		}
		else
		{
			System.out.println("false");
		}
	}
	
	/*
	@Override
	public String toString()
	{
		String listOfCards = "";
		int i = 0;
		
		for(Card c: handCards)
		{
			listOfCards += "\n" + i + " " + c.toString();
			i++;
		}
		return listOfCards;
	}
	*/

//OPTIONAL FEATURE
//	public void validateTotal()
//	{
//		boolean val = false;
//		while(!val)
//		{
//			if(total < 9 && total > 2)
//			{
//				val = true;
//			}
//			System.out.println("Invalid total: only 3-8 cards");
//		}
//	}
	//setters
	//set total cards
}
