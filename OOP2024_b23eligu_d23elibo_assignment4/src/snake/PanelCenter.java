package snake;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class PanelCenter extends JPanel implements KeyListener, ActionListener{
	
	
	private static final long serialVersionUID = 1L;
	private static final int DELAY = 200; // Milliseconds between repaints
	private int tileSize = 15;
	private GamePlay gamePlay;
	private GameOverPanel gameOverPanel;
	
	public PanelCenter( GamePlay gamePlay ) {//the panel game is played on
		this.gamePlay = gamePlay;
		this.gameOverPanel = new GameOverPanel(gamePlay);
		Color grassGreen = new Color(0xB5FF9E);
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		setBackground(grassGreen);
		setFocusable(true);
		this.addKeyListener(this);
		//timer to repaint the scene in equal intervals
		Timer timer = new Timer(DELAY, this); // Creating a Timer with the specified delay and ActionListener
	    timer.start(); // Start the timer
	}
	
	@Override
	protected void paintComponent(Graphics g) {//painting the component
		super.paintComponent(g);
		
		SnakeHead snakehead = gamePlay.getSnakeHead();
		int panelHeight = getHeight();
		int panelWidth = getWidth();
		Color grassYellow = new Color(0xD9BB47);
		g.setColor(grassYellow);
		
		//painting the lines vertically and horizontally to help the user 
		for(int i = 0 ; i <= panelHeight / tileSize ; i++){
            g.drawLine(0,i*tileSize,panelWidth,i*tileSize);
        }
		
		for(int i = 0 ; i <= panelWidth / tileSize ; i++){ 
			g.drawLine(i*tileSize,0,i*tileSize,panelHeight);
         
        }
		//painting the fruits
		for (Fruit fruit: gamePlay.getFruitsList()) {	
			g.setColor(fruit.getColor());
			g.fillOval(fruit.getPosX(), fruit.getPosY(),10,10);
		}
		//painting the snake
		for (SnakeBodyPart sb: gamePlay.getSnakeBodyPartList()) {
			g.setColor(sb.getColor());
			g.fillOval(sb.getPosX(), sb.getPosY(),10,10);
		}
		g.setColor(snakehead.getColor());
		g.fillOval(snakehead.getPosX(), snakehead.getPosY(), 10, 10);
		
	}
	@Override
    public void actionPerformed(ActionEvent e) {
        // Repainting the panel on each timer tick
		
		if( gamePlay.isContinuePlaying() ) {//if game continues repaint the scene
			if(!gamePlay.isPaused()) {//and if the game is not paused
				gamePlay.controlCollision();
				gamePlay.fruitSpawn();
				gamePlay.moveSnake();
		        repaint();
			}
			else {
				requestFocusInWindow();//for the program to focus again so it registers the key strokes
			}
		}else {
			if (!gameOverPanel.isVisible()) { // Check if the game over panel is not already visible
	            this.add(gameOverPanel);
	            gameOverPanel.setVisible(true);
	            repaint(); // Repaint after adding game over panel
	        }
		}
    }
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {//setting the direction of the snake based on key strokes
		
		if(e.getKeyCode() == KeyEvent.VK_UP && gamePlay.getDirection()!= 3 ) {
			gamePlay.setDirection(1);
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT && gamePlay.getDirection()!= 4)  {
			gamePlay.setDirection(2);
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN && gamePlay.getDirection()!= 1) {
			gamePlay.setDirection(3);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT && gamePlay.getDirection()!= 2) {
			gamePlay.setDirection(4);
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
