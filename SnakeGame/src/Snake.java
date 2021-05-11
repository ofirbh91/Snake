
public class Snake {
	static int x[] = new int[GamePanel.GAME_UNITS];
	static int y[] = new int[GamePanel.GAME_UNITS];
	static int bodyParts = 6;
	
	public static void move() {
		for (int i = bodyParts; i > 0; i--) {
			x[i] = x[i - 1];
			y[i] = y[i - 1];
		}
		switch (GamePanel.direction) {
		case 'U':
			y[0] = y[0] - GamePanel.UNIT_SIZE;

			break;
		case 'D':
			y[0] = y[0] + GamePanel.UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - GamePanel.UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + GamePanel.UNIT_SIZE;
			break;
		}
	}

	public static void checkCollisions() {

		for (int i = bodyParts; i > 0; i--) {
			if ((x[0] == x[i]) && y[0] == y[i]) {
				GamePanel.gameRuning = false;
			}
		}
		if (x[0] < 0 || x[0] > GamePanel.WIDTH || y[0] < 0 || y[0] > GamePanel.HEIGHT) {
			GamePanel.gameRuning = false;
		}
		if (!GamePanel.gameRuning) {
			GamePanel.timer.stop();
		}
	}
}
