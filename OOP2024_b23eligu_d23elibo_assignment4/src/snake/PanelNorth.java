package snake;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelNorth extends JPanel implements ActionListener{
	

	private static final long serialVersionUID = 1L;
	private static final int DELAY = 200; // Milliseconds between repaints
	private JLabel scoreNumber;
	private JLabel scoreLabel;
	private GamePlay gamePlay = new GamePlay();
	
	public PanelNorth( GamePlay gamePlay ) {
		this.gamePlay = gamePlay;
		
		scoreNumber = new JLabel();
		scoreLabel = new JLabel();
		
		scoreLabel.setText("Score:");
		scoreNumber.setText(String.valueOf(gamePlay.getScore()));
		
		//adding action listeners
		this.add(scoreLabel);
		this.add(scoreNumber);
		
		Color melon = new Color(0xFFDB97);
		this.setBackground(melon);
		
		Timer timer = new Timer(DELAY, this); // Creating a Timer with the specified delay and ActionListener
	    timer.start(); // Start the timer
	    
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		scoreNumber.setText(String.valueOf(gamePlay.getScore()));// changing the score label to match the gained points
	}
}
