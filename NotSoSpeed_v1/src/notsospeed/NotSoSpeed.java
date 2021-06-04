package notsospeed;

import javax.swing.*;
import java.awt.event.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.awt.*;

public class NotSoSpeed {

	public static void main(String[] args) {
		//Timers
		//4 decks
		//Create playing deck
		Deck playDeck = new Deck();
		playDeck.createFullDeck();
		//playDeck.shuffle();
		Deck handDeck = new Deck();
		
		//Deck sideDeckLeft = new Deck();
		
		//Deck sideDeckRight = new Deck();
		
		//test
		//System.out.println(playDeck);
		
		
		
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
		 


		
		
		
		
	}

}
