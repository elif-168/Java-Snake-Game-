package snake;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelSouth extends JPanel implements ActionListener{


	private static final long serialVersionUID = 1L;
	
	private JButton pauseButton;
	private JButton stopButton;
	private GamePlay gamePlay;
	
	
	public PanelSouth(GamePlay gamePlay) {
		// initializing the buttons
		pauseButton = new JButton();
		stopButton = new JButton();
		this.gamePlay = gamePlay;
		
		//setting the texts for the buttons
		pauseButton.setText("Pause Game");
		stopButton.setText("Stop Game");
		
		//setting the background for the panel
		Color melon = new Color(0xFFDB97);
		this.setBackground(melon);
		
		//setting the background for the buttons
		Color lightPurple = new Color(0xDEF0FF);
		pauseButton.setBackground(lightPurple);
		stopButton.setBackground(lightPurple);
		
		//adding the ActionListener to the buttons
		pauseButton.addActionListener(this);
		stopButton.addActionListener(this);
		
		//adding the buttons to the panel
		this.add(pauseButton);
		this.add(stopButton);
		
		this.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if( gamePlay.isContinuePlaying() ) {//if the game is still going
			
			if( e.getSource().equals(pauseButton) ) {//if pause button is clicked 
				
				if( !gamePlay.isPaused() ) {//if the game is not already paused, pause the game
					gamePlay.setPaused(true);
					pauseButton.setText("Continue Game");
				}else {//if it was paused then continue the game
					gamePlay.setPaused(false);
					pauseButton.setText("Pause Game");					
				}
			}
		}
		
		if( e.getSource().equals(stopButton) ) {//if stop button is clicked 
			if( gamePlay.isContinuePlaying() ) {// and if the game hasn't already been stopped
				gamePlay.setContinuePlaying(false);	//set continue flag to false
				gamePlay.setPaused(false);//and the pause flag to false 
				//otherwise when you restart it you would need to press continue once again
			}
		}
	}
	

}
