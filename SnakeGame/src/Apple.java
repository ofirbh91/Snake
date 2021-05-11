import java.util.Random;

public class Apple {

	static int appleEaten = 0;
	static int appleX = GamePanel.random.nextInt((int) (GamePanel.HEIGHT / GamePanel.UNIT_SIZE)) * GamePanel.UNIT_SIZE;
	static int appleY = GamePanel.random.nextInt((int) (GamePanel.HEIGHT / GamePanel.UNIT_SIZE)) * GamePanel.UNIT_SIZE;
	//static Random random = new Random();



	public static void newApple() {
		appleX = GamePanel.random.nextInt((int) (GamePanel.HEIGHT / GamePanel.UNIT_SIZE)) * GamePanel.UNIT_SIZE;
		appleY = GamePanel.random.nextInt((int) (GamePanel.HEIGHT / GamePanel.UNIT_SIZE)) * GamePanel.UNIT_SIZE;
		for (int i = 0; i < Snake.bodyParts; i++) {
			if (Snake.x[i] == appleX && Snake.y[i] == appleY) {
				newApple();
			}
		}
	}
	public static void checkApple() {

		if (Snake.x[0] == appleX && Snake.y[0] == appleY) {
			Snake.bodyParts++;
			appleEaten++;
			newApple();
		}
	}
}
