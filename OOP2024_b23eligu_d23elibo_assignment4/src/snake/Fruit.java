package snake;

import java.awt.Color;
import java.util.Random;

public class Fruit extends GameEntity {
	private int fruitScore;
	private int randomNumber;

	public Fruit(int x, int y, Color color) {
		super(x, y, color);
		Random random = new Random();
		fruitScore = 1;// if the random number does not fall in to one of the if blocks the value will be 1.
		randomNumber = random.nextInt(10) + 1;
		
		//assigning a value based on the result of the random value
		if (randomNumber >= 7 && randomNumber != 10) {//if it is between 7 and 10
			setColor(Color.blue);
			fruitScore = 2;
		}
		if (randomNumber == 10) {//if it is 10
			setColor(Color.YELLOW);
			fruitScore = 5;
		}
	}

	public int getFruitScore() {
		return fruitScore;
	}
}
