import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;



public class GameFrame extends JFrame {

	public GameFrame() {
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		this.add(new GameHeader(), BorderLayout.NORTH);
		this.add(new GamePanel(), BorderLayout.CENTER);
		
		
		
		this.setTitle("Snake_OBH");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

}
