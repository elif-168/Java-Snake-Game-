package snake;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

public class SnakeHead extends GameEntity {// a class for snake's head
	private int direction;//direction of the snake
	private int score = 0;
	private boolean collision = false;
	private ArrayList<Fruit> fruitsList;//we need the fruit list to check for collision
	private ArrayList<SnakeBodyPart> snakeBodyPartList;

	public SnakeHead(Color color, ArrayList<Fruit> fruitsList,ArrayList<SnakeBodyPart> snakeBodyPartList) {
		super(200, 200, color);//at the beginning we want the snake's head to be on x = 200, y = 200 
		this.direction = 1;
		this.fruitsList = fruitsList;
		this.snakeBodyPartList = snakeBodyPartList;
	}

	public void headMove() {
		if (this.direction == 1) {
			setPosY(getPosY() - 10); 
		}
		if (this.direction == 2) {
			setPosX(getPosX() + 10);
		}
		if (this.direction == 3) {
			setPosY(getPosY() + 10); 
		}
		if (this.direction == 4) {
			setPosX(getPosX() - 10);
		}

	}

	public boolean checkCollision() { // SnakeHead

		Iterator<Fruit> iterator = fruitsList.iterator();
		while (iterator.hasNext()) {// loop to check if the next game tile has a fruit on it
			Fruit fruit = iterator.next();
			if (getPosX() == fruit.getPosX() && getPosY() == fruit.getPosY()) {
				score+=fruit.getFruitScore(); //if there is a fruit increase the score by that fruit's score
				iterator.remove();
				snakeBodyPartList.add(new SnakeBodyPart(snakeBodyPartList.size(), 0, 0, Color.BLACK, this));
			}
		}

		for (int i = 1; i < snakeBodyPartList.size(); i++) {//a loop to check if there is a collision with snake's own body parts

			if (getPosX() == snakeBodyPartList.get(i).getPosX() && getPosY() == snakeBodyPartList.get(i).getPosY()) {

				collision = true;
			}
		}
		if (getPosX() < 0 || getPosY() < 0 || getPosX() > 470 || getPosY() > 390) {//Checking if the snake is out of bounds
			collision = true;

		}
		return collision;
	}

	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public ArrayList<SnakeBodyPart> getSnakeBodyPartList() {
		return snakeBodyPartList;
	}

}