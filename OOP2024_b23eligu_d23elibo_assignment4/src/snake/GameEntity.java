package snake;

import java.awt.Color;

public class GameEntity {

	private int posX, posY;
	private Color color;
	
	public GameEntity(int x, int y, Color color) {//sets the position and the color of game entities
		this.posX = x;
		this.posY = y;
		this.color = color;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	

}
