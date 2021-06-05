package notsospeed;

import java.util.ArrayList;
import java.util.Random;

public class Deck 
{
	//instance variables
	private ArrayList<Card> cards;
	
	//constructor
	public Deck()
	{
		cards = new ArrayList<Card>();
	}//end constructor
		
	//loop thru the full deck(suit*value)
	public void createFullDeck()
	{
		for(Suit cardSuit: Suit.values())
		{
			for(Value cardValue: Value.values())
			{
				//add NEW cards to the list
				cards.add(new Card(cardSuit,cardValue));
			}
		}
	}
	
	public void shuffle()
	{
		ArrayList<Card> offDeck = new ArrayList<Card>(); //deck off to the side to use as storage
		//use random
		Random random = new Random();
		int randomCardIndex = 0;
		//get size of deck
		int originalSize = cards.size();
		for(int i = 0; i < originalSize; i++)
		{
			//generate random index: rand.nextInt((max - min) + 1) + min(0)
			randomCardIndex = random.nextInt((cards.size()-1 - 0) + 1) + 0;
			offDeck.add(cards.get(randomCardIndex));
			//remove from original deck
			cards.remove(randomCardIndex);
		}
		cards = offDeck;
	}//end shuffle method
	
	public void addCard(Card plus)
	{
		cards.add(plus);
	}
	
	public void removeCard(Card minus)
	{
		cards.remove(minus);
	}
	
	public Card getCard(int i)
	{
		return cards.get(i);
	}
	
	//draw a card from the deck
	public void draw(Deck drawFrom)
	{
		cards.add(drawFrom.getCard(0));
	}//end draw method
	
	public int cardsValue()
	{
		int total = 0;
		return total;
	}
	
	
	public String toString()
	{
		String listOfCards = "";
		int i = 0;
		
		//REMOVE OR FIX
//		Card aCard = new Card();
//		for(int i = 0; i < cards.size(); i++)
//		{
//			cardListOutput += "\n" + i + " " + aCard.toString();
//		}
		
		for(Card c: cards)
		{
			listOfCards += "\n" + i + " " + c.toString();
			i++;
		}
		return listOfCards;
	}
	
}
