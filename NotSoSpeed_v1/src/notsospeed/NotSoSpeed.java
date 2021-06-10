package notsospeed;

import java.util.Scanner;

public class NotSoSpeed 
{

	public static void main(String[] args) 
	{
		
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Not So Speed!");
		//include start (optional)
		//4 decks
		//Create playing deck
		Deck drawDeck = new DrawDeck("Draw Deck");
		drawDeck.shuffle();
		
		HandDeck handDeck = new HandDeck("Player Hand");
		drawDeck.deal(handDeck, 5);
		handDeck.show();
		
		
		Deck leftDeck = new TableDeck("Left Deck");
		drawDeck.deal(leftDeck, 1);
		
		Deck rightDeck = new TableDeck("Right Deck");
		drawDeck.deal(rightDeck, 1);
		
		Deck leftover = new Deck("Leftover Deck");
		drawDeck.dealLeftover(leftover);
		
		//TEST AREA
		//System.out.println("# of cards left: " + leftover.size());
		//System.out.println("Hand Card Total: " + handDeck.cardTotal());
		//System.out.println("value of first: " + handDeck.getCard(0).getValue());
		
		//System.out.println();
		//handDeck.place(0, leftDeck);
		//leftDeck.show();
		//-----------GAMEPLAY------------
		//Display hand
		System.out.println("Left Deck: " + leftDeck.getLast());
		System.out.println("Right Deck: " + rightDeck.getLast());
		handDeck.show();
		System.out.println("Select a card from your hand:");
		int card = scan.nextInt();
		System.out.println("Select deck to place card (left = 'l' or right = 'r'):");
		String deck = scan.next();
		if(deck.equals("r"))
		{
			handDeck.place(card, rightDeck);
		}
		else if(deck.equals("l"))
		{
			handDeck.place(card, leftDeck);
		}
		else
		{
			System.out.println("Invalid");
		}
		
		
		
		
		/*
		 * 1. Create decks
		 * 2. Display player hand
		 * 3. Tell player top cards of table decks
		 * 4. Player decides which card to place in chosen deck
		 * 5. Check if card can be placed in table deck
		 * if can place, repeat 2
		 * if cannot place, say "invalid, choose another card: ", repeat 2
		 * Display: hand, table deck top card values, draw deck count
		 */
		
		
		
		
		/*
		  //-----------------JAVA SWING GUI----------------
			
			JFrame frame1 = new JFrame("Not So Speed");
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //MUST HAVE		
			frame1.setSize(1000,5000);
			
			//Panel 1 for shuffle button
			JPanel panel1 = new JPanel(new GridBagLayout());
			panel1.setBorder(BorderFactory.createTitledBorder("Gameplay"));
			
			//Panel 2 for exit button
			JPanel panel2 = new JPanel(new GridBagLayout());
			//panel2.setBorder(BorderFactory.createTitledBorder("Exit Game"));
			
			//JTextArea textArea = new JTextArea(timer);
			
			JLabel label1 = new JLabel("Test");
			//---Shuffle Button---
			JButton shuffleDeck = new JButton("Shuffle");
			shuffleDeck.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					playDeck.shuffle();
					shuffleDeck.setBackground(Color.yellow);
					shuffleDeck.setOpaque(true);
				}
					
			}); //end AL for shuffle
			
			JButton drawFrom = new JButton("Draw");
			drawFrom.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					handDeck.draw(playDeck);
					drawFrom.setBackground(Color.cyan);
					drawFrom.setOpaque(true);
				}
					
			}); //end AL for draw
			
			//---Exit Button---
			JButton exitScreen = new JButton("Exit Game");
			exitScreen.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					System.exit(0);
				}
					
			}); //end AL for exit
			
			
			Insets insets = panel2.getInsets();
			Dimension size = exitScreen.getPreferredSize();
			exitScreen.setBounds(25 + insets.left, 5 + insets.top,
					size.width, size.height);
			
			
			panel1.add(label1);
			panel1.add(shuffleDeck);
			panel1.add(drawFrom);
			panel2.add(exitScreen);
			
			frame1.getContentPane().add(BorderLayout.CENTER,panel1);
			frame1.getContentPane().add(BorderLayout.SOUTH,panel2);
			frame1.setVisible(true);
			//frame1.pack();
		 
	*/

		
		
		
		
	}

}
