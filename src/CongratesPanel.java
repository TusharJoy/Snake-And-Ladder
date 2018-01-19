import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class CongratesPanel extends JPanel {
	
	private BufferedImage congratesicn ;
	private JLabel message  ;
	
	private JButton playaginbtn ;
	private JButton mainMenu ;
	public CongratesPanel(String p) 
	{
		//setForeground(Color.DARK_GRAY);
		
		playaginbtn= new JButton("Play Agin");
		mainMenu = new JButton("Qui To Main Menu");
		
		setLayout(new GridBagLayout());
		message = new JLabel(p) ;
		message.setFont(new Font("SansSerif", Font.BOLD, 40));
		message.setForeground(Color.GREEN);
		
		add(message);
		add(mainMenu);
		add(playaginbtn);
		
		
		mainMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		
		playaginbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		 try {
				congratesicn = ImageIO.read(this.getClass().getResource("congrates.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error");
			}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(congratesicn, 0, 0, getWidth(),getHeight(),null) ;
	}
}
