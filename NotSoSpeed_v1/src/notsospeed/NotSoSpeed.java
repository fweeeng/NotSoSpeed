package notsospeed;

import java.util.Scanner;

public class NotSoSpeed {

	public static void main(String[] args) {
		
		
		//-----------GAMEPLAY------------
		System.out.println("Welcome to Not So Speed!");
		//4 decks
		//Create playing deck
		//Deck playDeck = new DrawDeck();
		//playDeck.createFullDeck();
		//playDeck.shuffle();
		//Scanner scan = new Scanner(System.in);
		
		//Deck handDeck = new HandDeck(5);
		//handDeck.draw(playDeck);
		//handDeck.createFullDeck();
		//handDeck.validateTotal();
		//handDeck.createFullDeck();
		//handDeck.creatFullDeck(); overriden method
		//TableDeck leftDeck = new TableDeck(playDeck);
		//leftDeck.draw();
		//Deck rightDeck = new Deck();
		//rightDeck.draw(playDeck);
		
		//System.out.println(playDeck.toString());
		/*
		System.out.println("Your card:" + handDeck.toString());
		System.out.println("Left deck: " + leftDeck.toString());
		System.out.println("Right deck: " + rightDeck.toString());
		System.out.println("Place on LEFT deck, RIGHT deck, or DRAW?");
		String response = scan.nextLine();
		
		if(response.equals("left"))
		{
		}
		*/
		
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
		
		boolean play = true;
		while(play)
		{
			
		}
		//test
		//System.out.println(playDeck);
		
		
		
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
