import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class GameHeader extends JPanel {
	
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 50;
	static JButton difficultyButton = new JButton("Difficulty");
	static JButton startButton = new JButton("Start"); 
	static JPopupMenu popupMenu = new JPopupMenu();
	JMenuItem menuItemCreateSpringProject = new JMenuItem("Spring Project");

	
	public GameHeader() {
		super();
		this.setLayout(null);
		popupMenu.setBounds(80, 13, 84, 25);
		popupMenu.add(menuItemCreateSpringProject);
		startButton.setBounds(450, 13, 84, 25);
		startButton.addActionListener((e)-> {GamePanel.gameRuning = true;});
		this.add(popupMenu).setFocusable(false);;
		this.add(startButton).setFocusable(false);
		this.add(difficultyButton).setFocusable(false);
		this.setBackground(Color.black);
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	

	public void draw(Graphics g) {
		
		g.setColor(Color.red);
		g.setFont(new Font("Ink Free", Font.BOLD, 35));
		FontMetrics metrics = getFontMetrics(g.getFont());
		
		g.drawString("Score: "+ Apple.appleEaten, (SCREEN_WIDTH - metrics.stringWidth("Score: "+Apple.appleEaten))/2, g.getFont().getSize());
		repaint();
	}
}
