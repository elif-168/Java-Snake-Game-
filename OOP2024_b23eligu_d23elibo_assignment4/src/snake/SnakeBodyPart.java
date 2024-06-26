package snake;

import java.awt.Color;
import java.util.ArrayList;

public class SnakeBodyPart extends GameEntity {//
	private int bodyNumber;
	private SnakeHead snakehead; //the head of the snake

	public SnakeBodyPart(int bodyNumber, int x, int y, Color color, SnakeHead snakehead) {
		super(x, y, color);

		this.snakehead = snakehead;
		this.bodyNumber = bodyNumber;
	}

	public void moveBodyPart() {
		if (bodyNumber != 0) {
			ArrayList<SnakeBodyPart> snakeBodyPartList = snakehead.getSnakeBodyPartList();//getting the snake body parts list from the head
			//because each body part will move onto the place of the previous one
			setPosX(snakeBodyPartList.get(bodyNumber - 1).getPosX());
			setPosY(snakeBodyPartList.get(bodyNumber - 1).getPosY());
			
		} else {//if the current body part is the one before head , it takes the place of the head
			setPosX(snakehead.getPosX());
			setPosY(snakehead.getPosY());
		}
	}

}