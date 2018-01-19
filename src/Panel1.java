import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Panel1 extends JPanel {
	
	
	private int dialogResult ; 
    private int dialogButton ;
    
    
    public  JButton NewGameButton ;
    private JButton aboutUsBtn ;
    private JButton btnExit ;
    private BufferedImage image ;
    
    
    private Icon newgameicn;
    private Icon abouticn ;
    private Icon exiticn ;
    
    public Panel1() {
    	
    	 try {
				image = ImageIO.read(this.getClass().getResource("back.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error");
			}
    	
    	 
    	 
    	 
    	 
    	 newgameicn = new ImageIcon(getClass().getResource("playgame.png")) ;
    	 abouticn = new ImageIcon(getClass().getResource("about.png")) ;
    	 exiticn = new ImageIcon(getClass().getResource("exit.png")) ;
    	 
    	 
    	 
    	 setLayout(null);
    	 NewGameButton = new JButton("New Game ");
    //	 NewGameButton.setOpaque(true);
		NewGameButton.setBounds(218, 131, 174, 52);
		NewGameButton.setIcon(newgameicn);
		NewGameButton.setBackground(Color.BLACK);
		NewGameButton.setForeground(Color.WHITE);
		add(NewGameButton);
		
		aboutUsBtn = new JButton("About Us");
		aboutUsBtn.setBounds(218, 214, 174, 52);
		aboutUsBtn.setBackground(Color.BLACK);
		aboutUsBtn.setForeground(Color.WHITE);
		aboutUsBtn.setIcon(abouticn); 
		add(aboutUsBtn);
		
		JButton btnExit = new JButton("Exit ");
		btnExit.setBounds(218, 300, 174, 52);
		btnExit.setBackground(Color.BLACK);
		btnExit.setForeground(Color.WHITE);
		btnExit.setIcon(exiticn);
		add(btnExit);	
	
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dialogResult = JOptionPane.showConfirmDialog (null, "Do You really wanna exit the game","Warning",dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
					System.exit(0);
			}
				
		}
		}
			);
		
		
		
		aboutUsBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
				JOptionPane.showMessageDialog(null, "This is a simple snake Ladder Game  which is devoloped by Tushar Ghosh && Alvi ");
				
			}
		});
		
		
		
		
	}
    protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(image,0,0,getWidth(),getHeight(),null);
	}
}
