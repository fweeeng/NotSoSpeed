package notsospeed;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	static JTextField playerInput = new JTextField("");
	
	public static void main(String[] args) 
	{
		
		
		//include start (optional)
		//4 decks
		//Create playing deck
		Deck dealDeck = new DrawDeck("Deal Deck");
		dealDeck.shuffle();
		
		HandDeck handDeck = new HandDeck("Player Hand");
		dealDeck.deal(handDeck, 5);
		handDeck.show();
		
		
		TableDeck leftDeck = new TableDeck("Left Deck");
		dealDeck.deal(leftDeck, 1);
		
		TableDeck rightDeck = new TableDeck("Right Deck");
		dealDeck.deal(rightDeck, 1);
		
		Deck drawDeck = new Deck("Deal Deck");
		dealDeck.dealLeftover(drawDeck);
			
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
			frame1.setSize(screenSize.width/2, screenSize.height-35);
			
			
			//Panel 1 for shuffle button
			JPanel gamePanel = new JPanel(new GridBagLayout());
			gamePanel.setLayout(new BoxLayout(gamePanel, 3));
			gamePanel.setBorder(BorderFactory.createTitledBorder("NOT SO SPEED"));
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
			
			JPanel enterPanel = new JPanel();
			enterPanel.setLayout(new BoxLayout(enterPanel, 1));
			
			JPanel flipPanel = new JPanel();
			flipPanel.setLayout(new BoxLayout(flipPanel, 1));
			
			//Panel 2 for exit button
			JPanel exitPanel = new JPanel(new GridBagLayout());
			
			
			JLabel drawCardsLeft = new JLabel("Cards Left: ");
			
			JPanel leftPanel = new JPanel();
			leftPanel.setLayout(new BoxLayout(leftPanel, 1));
			
			JPanel rightPanel = new JPanel(new GridLayout(0, 2));
			rightPanel.setLayout(new BoxLayout(rightPanel, 1));
			
			//--------------PLAYER-----------------
			JTextArea handLabel = new JTextArea();
			handLabel.setEditable(false);
			JLabel enterArea = new JLabel("Enter a card (1-5) from your hand");
			
			playerInput.setPreferredSize(new Dimension(50, 25));
			//---Shuffle Button---
			JButton shuffleBttn = new JButton("Shuffle");
			shuffleBttn.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					handDeck.shuffle();
					handLabel.setText(handDeck.show());
				}
				
			}); //end AL for shuffle
			
			
			
			//------------DRAW-----------------
			JButton drawBttn = new JButton("Draw");
			drawBttn.setEnabled(false);
			drawBttn.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if(handDeck.verifyAmt())
					{
						if(drawDeck.isEmpty())
						{
							drawBttn.setEnabled(false);
						}
						handDeck.draw(drawDeck);
						handLabel.setText(handDeck.show());
						drawCardsLeft.setText("Cards Left: " + String.valueOf(drawDeck.size()));
					}
					else
					{
						handLabel.setText(handDeck.show());
					}
					
				}
				
			}); //end AL for draw
			
			//------------TABLE--------------
			
			
			JLabel leftText = new JLabel("_");
			JButton leftBttn = new JButton("Left Deck");
			leftBttn.setEnabled(false);
			
			JLabel rightText = new JLabel("_");
			JButton rightBttn = new JButton("Right Deck");
			rightBttn.setEnabled(false);

			JButton staleMateBttn = new JButton("Stalemate");
			staleMateBttn.setEnabled(false);
			
			JButton flipBttn = new JButton("Flip to start");
			Color lime = new Color(205, 255, 0);
			flipBttn.setBackground(lime);
			flipBttn.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					leftText.setText(leftDeck.getLast().getSuit() + " " + leftDeck.getLast().getWordValue());
					rightText.setText(rightDeck.getLast().getSuit() + " " + rightDeck.getLast().getWordValue());
					flipBttn.setVisible(false);
					leftBttn.setEnabled(true);
					rightBttn.setEnabled(true);
					drawBttn.setEnabled(true);
					staleMateBttn.setEnabled(true);
					handLabel.setText(handDeck.show());
					drawCardsLeft.setText("Cards Left: " + String.valueOf(drawDeck.size()));
				}
				
			});
			
			staleMateBttn.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if(drawDeck.size() == 1)
					{
						leftDeck.draw(drawDeck);
						leftText.setText(leftDeck.getLast().getSuit() + " " + leftDeck.getLast().getWordValue());
						drawCardsLeft.setText("Cards Left: " + String.valueOf(drawDeck.size()));
						staleMateBttn.setEnabled(false);
						drawBttn.setEnabled(false);
					}
					leftDeck.draw(drawDeck);
					leftText.setText(leftDeck.getLast().getSuit() + " " + leftDeck.getLast().getWordValue());
					rightDeck.draw(drawDeck);
					rightText.setText(rightDeck.getLast().getSuit() + " " + rightDeck.getLast().getWordValue());
					drawCardsLeft.setText("Cards Left: " + String.valueOf(drawDeck.size()));

				}
				
			});
			
			/*
			JLabel enterOutput = new JLabel("Chosen card: ");
			JButton enterBttn = new JButton("Enter");
			enterBttn.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					System.out.println(getInput());
					enterOutput.setText("Chosen card: " + String.valueOf(getInput()));
				}
					
			});
			*/
			if(handDeck.isEmpty() && drawDeck.isEmpty())
			{
				leftText.setText("Choose which deck has the higher total value to WIN");
				rightText.setText("");
				//if(leftDeck.higherDeck(rightDeck))
			}
			leftBttn.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					if(handDeck.isEmpty() && drawDeck.isEmpty())
					{
						if(leftDeck.compare(rightDeck))
						{
							leftText.setText("You win!");
							rightBttn.setEnabled(false);
						}
						else
						{
							leftText.setText("Wrong, you lose");
							leftBttn.setEnabled(false);
							rightBttn.setEnabled(false);
						}
					}
					handDeck.place(getInput()-1, leftDeck);
					handLabel.setText(handDeck.show());
					leftText.setText(leftDeck.getLast().getSuit() + " " + leftDeck.getLast().getWordValue());
					playerInput.setText("");
				}
					
			});
			
			rightBttn.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{	
					if(handDeck.isEmpty() && drawDeck.isEmpty())
					{
						if(rightDeck.compare(leftDeck))
						{
							leftText.setText("You win!");
							leftBttn.setEnabled(false);
						}
						else
						{
							leftText.setText("Wrong, you lose");
							leftBttn.setEnabled(false);
							rightBttn.setEnabled(false);
						}
					}

					handDeck.place(getInput()-1, rightDeck);
					handLabel.setText(handDeck.show());
					rightText.setText(rightDeck.getLast().getSuit() + " " + rightDeck.getLast().getWordValue());
					playerInput.setText("");
				}
						
			});
			
			
			
			//---Exit Button---
			JButton exitBttn = new JButton("Exit Game");
			exitBttn.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					System.exit(0);
				}
					
			}); //end AL for exit
			
			
			drawPanelRInside.add(drawCardsLeft);
			drawPanelRInside.add(drawBttn);
			drawPanel.add(drawPanelRInside);

			leftPanel.add(leftText);
			leftPanel.add(leftBttn);
			rightPanel.add(rightText);
			rightPanel.add(rightBttn);
			tablePanel.add(staleMateBttn);
			tablePanel.add(leftPanel);
			tablePanel.add(rightPanel);
			flipPanel.add(flipBttn);
			tablePanel.add(flipPanel);
			
			//playerPanel.add(label1);
			handPanel.add(handLabel);
			handPanel.add(shuffleBttn);
			enterPanel.add(enterArea);
			enterPanel.add(getTextF());
			//enterPanel.add(enterBttn);
			//enterPanel.add(enterOutput);
			playerPanel.add(handPanel);
			playerPanel.add(enterPanel);
			
			gamePanel.add(drawPanel);
			gamePanel.add(tablePanel);
			gamePanel.add(playerPanel);
			
			exitPanel.add(exitBttn);
			
			frame1.getContentPane().add(BorderLayout.CENTER,gamePanel);
			frame1.getContentPane().add(BorderLayout.SOUTH,exitPanel);
			frame1.setVisible(true);
			//frame1.pack();
		 
		
	}
	
		public static int getInput()
		{
			String strInput = getTextF().getText();
			int input = Integer.valueOf(strInput);
			return input;
		}
		public static JTextField getTextF()
		{
			return playerInput;
		}
		

}
