package notsospeed;

public class HandDeck extends Deck {

	
	public HandDeck(String type)
	{
		super(type);
		//this.total = total;
	}
	
	public void systemShow()
	{
		System.out.println(getType() + ": ");
		for(int i = 0; i < size(); i++)
		{
			System.out.println(getCard(i));
		}
		System.out.println();
	}
	
	public String show()
	{
		String hand = "";
		for(int i = 0; i < size(); i++)
		{
			String s = String.valueOf(i+1);
			hand += s + "- " + getCard(i) + "\n";
		}
		return hand;
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
	
	public boolean verifyAmt()
	{
		boolean size = false;
		if(size() < 5)
		{
			size = true;
		}
		return size;
	}
	

}
