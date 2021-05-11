import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Draw extends JPanel {

	
	public static void drawFirst(Graphics g) {
		g.setColor(Color.red);
		g.setFont(new Font("ink Free", Font.BOLD, 40));
		FontMetrics metrics = g.getFontMetrics(g.getFont());
		g.drawString("PRESS START BUTTON", (GamePanel.WIDTH - metrics.stringWidth("PRESS START BUTTON"))/2, GamePanel.HEIGHT/2);
	}
	
	public static void drawRunningGame(Graphics g) {
		//grid
		for (int i = 0; i < GamePanel.HEIGHT/GamePanel.UNIT_SIZE; i++) {
			g.drawLine(i*GamePanel.UNIT_SIZE, 0, i*GamePanel.UNIT_SIZE, GamePanel.HEIGHT);
			g.drawLine(0, i*GamePanel.UNIT_SIZE, GamePanel.WIDTH, i*GamePanel.UNIT_SIZE);
		}
		
		g.setColor(Color.red);
		g.fillOval(Apple.appleX, Apple.appleY, GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);
		
		for (int i = 0; i < Snake.bodyParts; i++) {
			if(i == 0) {
			g.setColor(Color.green);
			g.fillRect(Snake.x[i], Snake.y[i], GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);
			} else {
				g.setColor(Color.GRAY);
				g.fillRect(Snake.x[i], Snake.y[i], GamePanel.UNIT_SIZE, GamePanel.UNIT_SIZE);
			}
		}
	}
	
	public static void gameOver(Graphics g) {
		//game over text
		g.setColor(Color.red);
		g.setFont(new Font("�nk Free", Font.BOLD, 75));
		FontMetrics metrics = g.getFontMetrics(g.getFont());
		g.drawString("GAME OVER", (GamePanel.WIDTH - metrics.stringWidth("GAME OVER"))/2, GamePanel.HEIGHT/2);
		
	}
}
