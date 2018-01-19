import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class PlayerSelectionWindow extends JPanel {

	
	private JTextField firstPlayerName;
	private JTextField secondPlayerName;
	private JTextField thirdPlayerName ;
	private JTextField fourthPlayername ;
	
	private JLabel  firstPlayerLabel ;
	private JLabel  secondPlayerLabel ;
	private JLabel thirdplayerlabel ;
	private JLabel fourthplayerlabel ;
	
	
	
	
	
    public   String Player1 ;
    public   String Player2 ;
    public   String Player3 ;
    public   String Player4 ;
    
    
    private int playerNum ;
    
    
    private JButton playGameBtn ;
    private BufferedImage imag ;                                                    

	public PlayerSelectionWindow() {
		
		
		 try {
				imag = ImageIO.read(this.getClass().getResource("background.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error");
			}

		 playerNum = 4 ;
		setForeground(Color.BLACK);
		
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		
	    firstPlayerLabel = new JLabel("First Player Name");
		firstPlayerLabel.setBounds(73, 54, 111, 17);
		add(firstPlayerLabel);
		
		
		
		 secondPlayerLabel = new JLabel("Second Player Name");
		secondPlayerLabel.setBounds(73, 108, 123, 17);
		add(secondPlayerLabel);
		
		
		
		thirdplayerlabel = new JLabel("third Player Name ");
		thirdplayerlabel.setBounds(73, 162, 123, 17);
		add(thirdplayerlabel) ;
		
		
		fourthplayerlabel = new JLabel("fourth Player Name ") ;
		fourthplayerlabel.setBounds(73, 216, 123, 17);
		add(fourthplayerlabel);
		
		
		
		firstPlayerName = new JTextField();
		firstPlayerName.setText("Enter name here");
		firstPlayerName.setBounds(206, 52, 122, 28);
		add(firstPlayerName);
		firstPlayerName.setColumns(20);
		
		
		
		secondPlayerName = new JTextField();
		secondPlayerName.setText("Enter name here");
		secondPlayerName.setColumns(40);
		secondPlayerName.setBounds(206, 102, 122, 28);
		add(secondPlayerName);
		
		 
		thirdPlayerName= new JTextField();
		thirdPlayerName.setText("Enter name here");
		thirdPlayerName.setColumns(40);
		thirdPlayerName.setBounds(206, 152, 122, 28);
		add(thirdPlayerName);
		
		
		
		fourthPlayername= new JTextField();
		fourthPlayername.setText("Enter name here");
		fourthPlayername.setColumns(40);
		fourthPlayername.setBounds(206, 202, 122, 28);
		add(fourthPlayername);
		
		
		
		
		playGameBtn = new JButton("Play Game");
		playGameBtn.setBounds(320, 252, 114, 30);
		add(playGameBtn);
		
	
		
		firstPlayerName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				Player1 = firstPlayerName.getText() ;
				
			}
		});
		
		               
		 secondPlayerName.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent event) {
					
					Player2 = secondPlayerName.getText() ;
					
				}
			});
		
		
       thirdPlayerName.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				Player3 = thirdPlayerName.getText() ;
				
			}
		});
        
        
       fourthPlayername.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				Player4 = fourthPlayername.getText() ;
				
			}
		});    
       
        
        
        
        playGameBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (playerNum==2){
				
				new GameBoard(Player1,Player2) ;
				setVisible(false);
				}
				else if (playerNum ==3)
				{
					new GameBoard(Player1,Player2,Player3) ;
				}
				else if (playerNum ==4)
				{
					new GameBoard(Player1, Player2,Player3,Player4) ;
				}
				
			}
		});    
	}
	
	public void PlayerSelectionTwo()
	{
		
		playerNum = 2 ;
		thirdplayerlabel.setVisible(false);
		thirdPlayerName.setVisible(false);
		fourthplayerlabel.setVisible(false);
		fourthPlayername.setVisible(false);
	}
	
	public void PlayerSelectionThree()
	{
		playerNum = 3 ;
		fourthplayerlabel.setVisible(false);
		fourthPlayername.setVisible(false);
	}
	
	
@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(imag, 0, 0, getWidth(),getHeight(),null) ;
	}


}


