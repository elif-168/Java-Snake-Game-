package snake;

import javax.swing.JPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverPanel extends JPanel implements ActionListener{
    
	private static final long serialVersionUID = 1L;
	private JButton restartButton;
    private JLabel gameOverLabel;
    private GamePlay gamePlay = new GamePlay();

    public GameOverPanel( GamePlay gamePlay ) {
        setLayout(new BorderLayout());
        this.gamePlay = gamePlay;
        // Creating the "Game Over" label
        gameOverLabel = new JLabel("Game Over");
        gameOverLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(gameOverLabel, BorderLayout.CENTER);

        // Creating the "Restart" button
        restartButton = new JButton("Restart");
        restartButton.addActionListener(this);
        restartButton.setFont(new Font("Arial", Font.PLAIN, 18));
        restartButton.setFocusPainted(false);
        restartButton.setPreferredSize(new Dimension(120, 40));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(restartButton);
        add(buttonPanel, BorderLayout.SOUTH);
        
        Color lightPurple = new Color(0xDEF0FF);
		restartButton.setBackground(lightPurple);
		
        this.setVisible(false);
	    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(restartButton)) {//if restart button is clicked
			//set flags and score to their initial values
			this.setVisible(false);
			gamePlay.deleteSnake();
			gamePlay.createSnake();
			gamePlay.setScore(0);
			gamePlay.setContinuePlaying(true);
			
		}
	}
}

