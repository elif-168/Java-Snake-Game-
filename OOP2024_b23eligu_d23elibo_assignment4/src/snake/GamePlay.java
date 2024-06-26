package snake;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

public class GamePlay {

	private int snakeLength = 4;
	private boolean continuePlaying = true; // the variable to continue or stop playing the game
	private boolean isPaused = false;// the variable indicating if the game is paused or not
	private ArrayList<SnakeBodyPart> snakeBodyPartList = new ArrayList<SnakeBodyPart>();
	private SnakeHead snakeHead;
	private int numberOfFruits = 3; // number of fruits in the game
	private ArrayList<Fruit> fruitsList = new ArrayList<Fruit>();// fruits in the game

	public GamePlay() {//the constructor
		createSnake();
	}
	public void controlCollision() {//changing the state of the game depending on if there is a collision or not
		continuePlaying = !snakeHead.checkCollision();//if there is a collision continue playing will be set to false
	}

	public void moveSnake() { 
		//moving the snake 
		snakeHead.headMove();
		for ( int j = snakeBodyPartList.size() - 1 ; j >= 0 ; j-- ) {
			//starting from the end of the list 
			//every body part moves to the place of the next one
			this.snakeBodyPartList.get(j).moveBodyPart();
		}
	}

	public void fruitSpawn() {//spawning fruits on random places

		int randX, randY;
		Boolean create = true;

		while (fruitsList.size() < numberOfFruits) {
			create = true;
			int widthWindow = ((400 - 20) / 10) - 2;
			int heightWindow = ((400 - 20) / 10) - 2;
			randX = (int) ((Math.random() * (widthWindow)) + 3);
			randY = (int) ((Math.random() * (heightWindow)) + 3);

			randX = (randX * 10);
			randY = (randY * 10);

			for (int i = 0; i < snakeBodyPartList.size(); i++) {
				//loop to check if the new random position is on  the snake's body 
				//do not create the fruit there
				SnakeBodyPart onTheBody = snakeBodyPartList.get(i);
				if (randX == onTheBody.getPosX() && randY == onTheBody.getPosY()) {
					create = false;
				}
			}
			if (randX == snakeHead.getPosX() && randY == snakeHead.getPosY()) {
				//if the new position is on where the head of the snake is do not create it there 
				create = false;
			}
			if (create == true) {//if the position is available create the fruit
				fruitsList.add(new Fruit(randX, randY, Color.GREEN));
			}

		}

	}

	public void createSnake() {
		//creating the snake's head
		this.snakeHead = new SnakeHead(Color.RED, fruitsList, snakeBodyPartList);//color can be removed from constructor
		
		for (int j = 0; j < snakeLength; j++) {//creating the body parts of the snake
			snakeBodyPartList.add(new SnakeBodyPart(j, 200 + (j * 10), 200, Color.black, snakeHead));
		}
	}
	
	public void deleteSnake() {//deleting snake from the panel
		Iterator<SnakeBodyPart> iterator = snakeBodyPartList.iterator();
		while (iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}

	}
	public void setContinuePlaying(boolean continuePlaying) {
		this.continuePlaying = continuePlaying;
	}
	public boolean isContinuePlaying() {
		return continuePlaying;
	}
	public SnakeHead getSnakeHead() { 
		return snakeHead;
	}
	public int getScore() {
		return snakeHead.getScore();
	}
	public void setScore(int score) { 
		snakeHead.setScore(score);
	}
	public ArrayList<SnakeBodyPart> getSnakeBodyPartList() {
		return snakeBodyPartList;
	}
	public int getDirection() { 
		return snakeHead.getDirection();
	}
	public void setDirection(int direction) { 
		snakeHead.setDirection(direction);
	}
	public ArrayList<Fruit> getFruitsList() {
		return fruitsList;
	}
	public boolean isPaused() {
		return isPaused;
	}
	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}
	
}
