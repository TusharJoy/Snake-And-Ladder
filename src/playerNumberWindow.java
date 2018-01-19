import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class playerNumberWindow extends JPanel {
    
	public JButton twoplayerbtn ;
	public JButton threeplayerbtn;
	public JButton fourplayerbtn ;
	private BufferedImage imag ;
	private int playerNumber ;
	public playerNumberWindow()
	{
		
		 try {
				imag = ImageIO.read(this.getClass().getResource("background.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error");
			}
		
		setLayout( null );
		
		twoplayerbtn = new JButton("Two Player") ;
		threeplayerbtn = new JButton("Three Player") ;
		fourplayerbtn = new JButton("Four Player") ;
		
		
		add(twoplayerbtn) ;
		twoplayerbtn.setBounds(218, 114, 174, 52);
		
		add(threeplayerbtn);
		threeplayerbtn.setBounds(218, 214, 174, 52);
		
		add(fourplayerbtn) ;
		fourplayerbtn.setBounds(218, 300, 174, 52);
		
	}
	

	
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(imag, 0, 0, getWidth(),getHeight(),null) ;
	}
	
}
