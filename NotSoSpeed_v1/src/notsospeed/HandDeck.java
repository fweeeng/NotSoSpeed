package notsospeed;

public class HandDeck extends Deck {

	private int total;
	
	public HandDeck(String type, int total)
	{
		super(type);
		this.total = total;
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
	
	/*
	public void placeCard(TableDeck TBDeck)
	{
		TBDeck.removeCard
	}
	*/
	
	//setters
	//set total cards
//	public void setTotal(int total)
//	{
//		this.total = total;
//	}

}
