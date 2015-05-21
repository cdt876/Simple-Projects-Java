import java.awt.Color; 
import java.awt.Graphics; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.KeyEvent; 
import java.awt.event.KeyListener; 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.Timer; 

public class ball extends JPanel implements ActionListener, KeyListener { 
	Timer t = new Timer(5, this); 
	int x = 0;
	int y = 0;
	int velx = 0;
	int vely = 0; 

public ball() { 
	t.start(); 
	addKeyListener(this); 
	setFocusable(true); 
	setFocusTraversalKeysEnabled(false); 
} 

public void paintComponent(Graphics g) { 
	super.paintComponent(g);
	g.setColor(Color.BLUE); 
	g.fillRect(x, y, 80, 50); 
	g.setColor(Color.RED);
	g.drawOval(480, 480, 200, 200);
} 

public void actionPerformed(ActionEvent e) { 
	if(x < 0) { 
	  velx = 0; 
	  x = 0; 
	} 
	
	if(x > 530) { 
	  velx = 0; 
	  x = 530;
	} 
	
	if(y < 0) { 
	  vely = 0; 
	  y = 0; 
	} 
	
	if(y > 330) { 
	  vely = 0; 
	  y = 330; 
	} 
	
	x += velx; 
	y += vely; 
	repaint(); 
}

public void keyPressed(KeyEvent e) { 
	int code = e.getKeyCode(); 
		if (code == KeyEvent.VK_DOWN) { 
			vely = 1; 
			velx = 0; 
		} 

		if (code == KeyEvent.VK_UP) { 
			vely = -1; 
			velx = 0; 
		}  

		if (code == KeyEvent.VK_LEFT) {
			vely = 0; 
			velx = -1; 
		}

		if (code == KeyEvent.VK_RIGHT) {
			vely = 0; 
			velx = 1; 
		} 
}

public void keyTyped(KeyEvent e) {
} 

public void keyReleased(KeyEvent e) { 
	velx = 0; 
	vely = 0;
} 

public static void main (String arge[]) { 
	JFrame f = new JFrame();
	ball s = new ball(); 
	f.add(s); 
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	f.setSize(600, 400); 
	f.setVisible(true); 
}
}