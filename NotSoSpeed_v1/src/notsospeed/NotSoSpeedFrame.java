package notsospeed;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NotSoSpeedFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotSoSpeedFrame frame = new NotSoSpeedFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NotSoSpeedFrame() 
	{
		
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
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton exitBtn = new JButton("Exit");
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		exitBtn.setBounds(335, 227, 89, 23);
		contentPane.add(exitBtn);
		
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
				drawDeck.shuffle();
				shuffleDeck.setBackground(Color.yellow);
				shuffleDeck.setOpaque(true);
			}
				
		}); //end AL for shuffle
		
		JButton drawFrom = new JButton("Draw");
		drawFrom.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				handDeck.draw(drawDeck);
				drawFrom.setBackground(Color.cyan);
				drawFrom.setOpaque(true);
			}
				
		}); //end AL for draw
	}
}
