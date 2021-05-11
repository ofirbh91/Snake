import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class GamePanel extends JPanel implements ActionListener {

//	private static Apple apple = new Apple();
	static final int WIDTH = 600;
	static final int HEIGHT = 600;
	static final int UNIT_SIZE = 25;
	static final int GAME_UNITS = (WIDTH * HEIGHT) / UNIT_SIZE;
	static int DELAY = 75;
	static char direction = 'U';
	static boolean gameRuning = false;
	static boolean first = false;
	static Timer timer;
	static Random random;

	GamePanel() {
		random = new Random();
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdaptor());
		this.setBorder(BorderFactory.createLineBorder(Color.WHITE));

		startGame();
	}

	public void startGame() {
		first = true;
		for (int i = 0; i < Snake.bodyParts; i++) {
			Snake.x[i] = GamePanel.WIDTH / 2;
			Snake.y[i] = GamePanel.HEIGHT / 2;
		}
		Apple.newApple();
		gameRuning = false;
		Apple.appleEaten = 0;
		Snake.bodyParts = 6;
		direction = 'U';
		timer = new Timer(DELAY, this);
		timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public void draw(Graphics g) {
		if (first)
			Draw.drawFirst(g);
		if (gameRuning)
			Draw.drawRunningGame(g);
		if (!gameRuning && !first) {
			Draw.gameOver(g);
			startGame();
		}
			
			
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (gameRuning) {
			first = false;
			Snake.move();
			Apple.checkApple();
			Snake.checkCollisions();
		}
		repaint();
	}

}
