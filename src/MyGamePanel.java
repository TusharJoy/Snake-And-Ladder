import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class MyGamePanel  extends  JPanel{
	
	private BufferedImage img ; 
	
	public MyGamePanel() {
		
			try {
				img = ImageIO.read(this.getClass().getResource("snakeLadderBoard.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error");
			}
	}
	
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(img,0,0,getWidth(),getHeight(),null);
	}
	
}




