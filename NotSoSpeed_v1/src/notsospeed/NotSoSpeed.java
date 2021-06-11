package notsospeed;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
		/*
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
		
		
		
		
		
		  //-----------------JAVA SWING GUI----------------
			
			JFrame frame1 = new JFrame("Not So Speed");
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //MUST HAVE		
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			frame1.setSize(screenSize.width, screenSize.height-35);
			
			
			//Panel 1 for shuffle button
			JPanel gamePanel = new JPanel(new GridBagLayout());
			gamePanel.setLayout(new BoxLayout(gamePanel, 3));
			gamePanel.setBorder(BorderFactory.createCompoundBorder());
			gamePanel.setBackground(Color.GRAY);

			JPanel drawPanel = new JPanel(new GridBagLayout());
			JPanel drawPanelRInside = new JPanel();
			drawPanelRInside.setLayout(new BoxLayout(drawPanelRInside, 1));
			drawPanel.setBorder(BorderFactory.createTitledBorder("Draw"));
			
			JPanel tablePanel = new JPanel(new GridBagLayout());
			tablePanel.setBorder(BorderFactory.createTitledBorder("Table"));

			JPanel playerPanel = new JPanel(new GridBagLayout());
			playerPanel.setBorder(BorderFactory.createTitledBorder("Player"));
			
			JPanel handPanel = new JPanel();
			handPanel.setLayout(new BoxLayout(handPanel, 1));
			
			JTextArea handLabel = new JTextArea(handDeck.show());
			
			//Panel 2 for exit button
			JPanel exitPanel = new JPanel(new GridBagLayout());
			
			
			JLabel drawCardsLeft = new JLabel("Number of Draw Cards Left: ");
			
			JPanel leftPanel = new JPanel();
			leftPanel.setLayout(new BoxLayout(leftPanel, 1));
			
			//------------DRAW-----------------
			JButton drawFrom = new JButton("Draw");
			drawFrom.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					//handDeck.draw(playDeck);
					drawFrom.setBackground(Color.cyan);
					drawFrom.setOpaque(true);
				}
				
			}); //end AL for draw
			
			//------------TABLE--------------
			JLabel leftText = new JLabel("Flip Left");
			
			JButton leftBttn = new JButton("Left Deck");
			leftBttn.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					
				}
					
			});
			
			JPanel rightPanel = new JPanel(new GridLayout(0, 2));
			rightPanel.setLayout(new BoxLayout(rightPanel, 1));

			
			JLabel rightText = new JLabel("Flip Right");
			
			JButton rightBttn = new JButton("Right Deck");
			rightBttn.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					
				}
					
			});
			
			//--------------PLAYER-----------------
			JTextField playerInput = new JTextField("Enter a card (1-5) from your hand");
			
			
			
			//---Shuffle Button---
			JButton shuffleDeck = new JButton("Shuffle");
			shuffleDeck.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					handDeck.shuffle();
					handLabel.setText(handDeck.show());
				}
					
			}); //end AL for shuffle
			
			
			//---Exit Button---
			JButton exitScreen = new JButton("Exit Game");
			exitScreen.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					System.exit(0);
				}
					
			}); //end AL for exit
			
			
			Insets insets = exitPanel.getInsets();
			Dimension size = exitScreen.getPreferredSize();
			exitScreen.setBounds(25 + insets.left, 5 + insets.top,
					size.width, size.height);
			
			drawPanelRInside.add(drawCardsLeft);
			drawPanelRInside.add(drawFrom);
			drawPanel.add(drawPanelRInside);

			leftPanel.add(leftText);
			leftPanel.add(leftBttn);
			rightPanel.add(rightText);
			rightPanel.add(rightBttn);
			tablePanel.add(leftPanel);
			tablePanel.add(rightPanel);
			
			//playerPanel.add(label1);
			handPanel.add(handLabel);
			playerPanel.add(handPanel);
			playerPanel.add(playerInput);
			playerPanel.add(shuffleDeck);
			
			gamePanel.add(drawPanel);
			gamePanel.add(tablePanel);
			gamePanel.add(playerPanel);
			
			exitPanel.add(exitScreen);
			
			frame1.getContentPane().add(BorderLayout.CENTER,gamePanel);
			frame1.getContentPane().add(BorderLayout.SOUTH,exitPanel);
			frame1.setVisible(true);
			//frame1.pack();
		 
	

		
		
		
		
	}

}
