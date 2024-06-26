package snake;

import java.awt.BorderLayout;

import javax.swing.*;

public class Frame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private GamePlay gamePlay = new GamePlay();
	private PanelNorth panelNorth;
	private PanelCenter panelCenter;
	private PanelSouth panelSouth;
	
	public Frame() {//the main frame	
		setBounds(100, 100, 500, 500);
		setLayout(new BorderLayout());
		
		panelNorth = new PanelNorth(gamePlay);
		panelSouth = new PanelSouth(gamePlay);
		panelCenter = new PanelCenter(gamePlay);
		
		//adding the panels
		add(panelNorth, BorderLayout.NORTH);
		add(panelSouth, BorderLayout.SOUTH);
		add(panelCenter, BorderLayout.CENTER);
		
		setLocationRelativeTo(null);//start the frame in the middle of the computer's screen
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false); 
		setVisible(true);
		
	}

}
