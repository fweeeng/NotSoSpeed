package notsospeed;

import java.util.ArrayList;
import java.util.Random;

public class Deck 
{
	//instance variables
	private ArrayList<Card> cards;
	private String type;
	
	//constructor
	public Deck(String type)
	{
		setCards(new ArrayList<Card>());
		this.type = type;
	}//end constructor
			
	//REMOVE LATER
	/*
	public void show()
	{
		System.out.println(getType() + ": ");
		for(int i = 0; i < size(); i++)
		{
			System.out.println(getCard(i));
		}
		System.out.println();
	}
	*/
	
	
	public void shuffle()
	{
		ArrayList<Card> offDeck = new ArrayList<Card>(); //deck off to the side to use as storage
		//use random
		Random random = new Random();
		int randomCardIndex = 0;
		//get size of deck
		int originalSize = getCards().size();
		for(int i = 0; i < originalSize; i++)
		{
			//generate random index: rand.nextInt((max - min) + 1) + min(0)
			randomCardIndex = random.nextInt((getCards().size()-1 - 0) + 1) + 0;//second source
			offDeck.add(getCards().get(randomCardIndex));
			//remove from original deck
			getCards().remove(randomCardIndex);
		}
		setCards(offDeck);
	}//end shuffle method
	
	public ArrayList<Card> getCards() 
	{
		return cards;
	}
	
	public Card getCard(int i)
	{
		return getCards().get(i);
	}
	
	public Card getLast()
	{
		return cards.get(cards.size()-1);
	}
	
	public String getType()
	{
		return type;
	}
	
	public void setCards(ArrayList<Card> cards) 
	{
		this.cards = cards;
	}

	
	public void addCard(Card c)
	{
		getCards().add(c);
	}
	//overloaded method
	public Card removeCard(int i)
	{
		return getCards().remove(i);
	}
	
	public Card removeCard()
	{
		return removeCard(cards.size()-1);//removes last card from cards
	}
	
	public boolean isEmpty()
	{
		return getCards().isEmpty();//checks if there are no more cards
	}
	
	public int size()
	{
		return getCards().size();
	}
	
	//draw a card from the deck
	public void draw(Deck drawOut)
	{
		getCards().add(drawOut.getCard(0)); 
		drawOut.removeCard(0); //remove so that the first card isn't the same for all objects
	}//end draw method
	
	//KEY METHOD TO HANDING OUT CARDS
	public void deal(Deck d, int j)
	{
		for(int i = 0; i < j; i++)
		{
			Card c = removeCard();
			d.addCard(c);
		}
	}
	
	public void dealLeftover(Deck d)
	{
		deal(d, cards.size());
	}
	
	public int cardTotal()
	{
		int total = 0;
		for(Card card : getCards())
		{
			total+=card.getValue();
		}
		return total;
	}
	
	
	
	public String toString()
	{
		String listOfCards = "";
		
		for(Card c: getCards())
		{
			listOfCards += "\n" + c.toString();
		}
		return listOfCards;
	}
	
	
}
