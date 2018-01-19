import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class GameBoard extends JFrame {
 
	
	private static final long serialVersionUID = 2447991659261979908L;
	
	
	int startplayer1 ;
	int startplayer2  ;
	int startplayer3   ;
	int startplayer4  ;
	
	private Icon redImage          ;
    private Icon yellowImage       ; 
    private Icon buttonImage       ;
    private Icon redPlayerImage    ;
    private Icon DiceImage         ;
    private Icon yellowPlayerImage ;
    private Icon bluePlayer        ;
    private Icon greenPlayer       ;
    private Icon whitePlayer       ;
    
    
    private JButton btnRollDice  ;
    
    
    private JLabel PlayerNameLabel1 ;
    private JLabel PlayerNameLabel2 ; 
    private JLabel PlayerNameLabel3 ;
    private JLabel PlayerNameLabel4 ; 
    private JLabel ShowDiceNumberLabel  ;
    private JLabel showDice          ;
    
    private int pos1 ;
    private int pos2 ;
    private int pos3 ;
    private int pos4 ;
    
    private int turn ;    
	private Rectangle[] location ;  

	
	private Player one   ;
	private Player two   ;
	private Player three ;
	private Player four  ;
	
	private JLabel showMessage ;
	
	private JLabel showPlayer1 ; 
	private JLabel showPlayer2 ;
	private JLabel showPlayer3 ;
	private JLabel showPlayer4 ;
	
	private JPanel  controllPanel  ;
    private MyGamePanel Board  ;
	
	public GameBoard(String s1,String s2) {
		
		 redImage = new ImageIcon(getClass().getResource("red.png")) ;
	    yellowImage = new ImageIcon(getClass().getResource("yellow.png")); 
		 buttonImage = new ImageIcon(getClass().getResource("Dice.png")) ;
		redPlayerImage = new ImageIcon(getClass().getResource("RedPlayer.png"));
		yellowPlayerImage = new ImageIcon(getClass().getResource("yellowPlayer.png"));
		bluePlayer = new ImageIcon(getClass().getResource("bluePlayer.png")) ;
		greenPlayer = new ImageIcon(getClass().getResource("greenPlayer.png")) ;
		whitePlayer = new ImageIcon(getClass().getResource("whitePlayer.png")) ;
		
		//setFont(UIManager.getFont("Panel.font"));
           
		
		showMessage = new JLabel() ;
		showDice = new JLabel();
		
		one = new Player() ;
		two = new Player() ;
		
		
		pos1 = 0;
		pos2 = 0;
		turn =0 ;
		one.setPlayer(s1);
		two.setPlayer(s2);

		
   		

		
		
		
		
		//Initialisation of the PlayerPosition which is Zero by Default 

		
		showPlayer1 = new JLabel(redPlayerImage);
		showPlayer2 = new JLabel(yellowPlayerImage) ;
		//setting the location of each square of the snakeLadderBoard on Rectangle 
        
    	location = new Rectangle[101]; 
		
		
		//set window Method For App GUI
		
		setResizable(false);
		setTitle("Snake Ladder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1920,1080);
		setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		
		//set SnakeLadderBoard Image Panel On MainFrame 
		
		Board = new MyGamePanel();
	//	Board.setBackground(Color.WHITE);
		Board.setBounds(6, 0,1072, 743);
		getContentPane().add(Board) ;
		Board.setLayout(null);
		
		
		//  showing red and yellow icon on every square of the Snake Ladder Panel for showing the movement of the Dice of Player//
		//By this method we are getting the position of each square in the SnakeLadderBoard Panel so that we can track the movement
		//of the Player
		
		int index = 1 ;
		int i=36 ;
		int k = 672 ;
		int j  ;
		int count = 10 ;
		
		while(count!=0)
		{
			if (count%2==0)
			{
				for ( j=1;j<=10;j++)
				{
					JLabel label = new JLabel("");
					label.setIcon(new ImageIcon(getClass().getResource("redPlayer.png")) );
					label.setBounds(i, k, 50, 45);
					location[index] = label.getBounds() ;
					i = i+105 ;
					index++ ;
					label.setVisible(false);
				}
				count-- ;
				 k = (k-73) ;
				 i = i-105 ;
			}
			else if (count%2==1)
			{
				for (j=1;j<=10;j++)
				{
					JLabel label = new JLabel("");
					label.setIcon(new ImageIcon(getClass().getResource("redPlayer.png")) );
					label.setBounds(i, k, 50, 45);
					location[index] = label.getBounds() ;
					i = i-105 ;
					index++ ;
				}
				k= k-73 ;
				i = i+105 ;
				count-- ;
			}
		}

        controllPanel = new JPanel();
		controllPanel.setBackground(Color.WHITE);
		controllPanel.setBounds(1078, 0, 286, 743);
		getContentPane().add(controllPanel);
		controllPanel.setLayout(null);
		
		

		PlayerNameLabel1 = new JLabel(one.getname());
		PlayerNameLabel1.setFont(new Font("SansSerif", Font.BOLD, 14));
		PlayerNameLabel1.setIcon(redPlayerImage);
	
		
		
		PlayerNameLabel1.setBounds(32, 7, 125, 48);
		controllPanel.add(PlayerNameLabel1);
		
		//showing player 2 label
		
	 
		
		PlayerNameLabel2 = new JLabel(two.getname());
		PlayerNameLabel2.setFont(new Font("SansSerif", Font.BOLD, 14));
		PlayerNameLabel2.setIcon(yellowPlayerImage);	
		PlayerNameLabel2.setBounds(32, 57, 125, 48);
		controllPanel.add(PlayerNameLabel2);
		
		
		
	    btnRollDice = new JButton(buttonImage);		
		btnRollDice.setBounds(27, 162-30, 128, 128);
		btnRollDice.setBackground(Color.WHITE);
		controllPanel.add(btnRollDice);
		
		ShowDiceNumberLabel = new JLabel("Dice Number ");
		ShowDiceNumberLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
		ShowDiceNumberLabel.setBounds(15, 299-30, 110, 36);
		controllPanel.add(ShowDiceNumberLabel);
		RandomGenerator ob = new RandomGenerator() ;
		
		
		
		showMessage.setText("Now is "+one.getname()+"'s Turn");
		showMessage.setBounds(50, 500-30, 180, 150);
		showMessage.setFont(new Font("SansSerif", Font.BOLD, 14));
		controllPanel.add(showMessage) ; 
		
		startplayer1 = 0 ;
		startplayer2 = 0 ;
		
		btnRollDice.addActionListener(new ActionListener() {
			int  dice ;
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				dice = ob.getDiceNum() ;
              
                if (turn%2==1)
                {
                	showMessage.setText("Now is "+one.getname()+"'s Turn");
                }
				
                else {
                	showMessage.setText("Now is "+two.getname()+"'s Turn");
                }
           
				if (dice==1)
				{
					DiceImage  = new ImageIcon(getClass().getResource("dice1.png")) ;
			    
					if (turn%2==0 && pos1<=99 && startplayer1==1)
					{
						pos1 = pos1+1 ;
					}
					else if(turn%2==1 && pos2<=99 && startplayer2== 1 ) {
						pos2  = pos2 + 1 ;
					}
				}
		     		
				else if (dice==2)
				{
					DiceImage  = new ImageIcon(getClass().getResource("dice2.png")) ;
					
					if (turn%2==0 && pos1<=98 && startplayer1==1)
					{
						pos1 = pos1+2 ;
					}
					else if(turn%2==1 && pos2<=100 && startplayer2== 1){
						pos2  = pos2 + 2 ;
					}
				}
				
				else if (dice==3)
				{
					DiceImage  = new ImageIcon(getClass().getResource("dice3.png")) ;
					if (turn%2==0 && pos1<=97 && startplayer1==1)
					{
						pos1 = pos1+3 ;
					}
					else if (turn%2==1 && pos2<=100 && startplayer2== 1){
						pos2  = pos2 + 3 ;
					}
				}
				
				else if (dice==4)
				{
					DiceImage  = new ImageIcon(getClass().getResource("dice4.png")) ;
					if (turn%2==0 && pos1<=96 && startplayer1==1)
					{
						pos1 = pos1+4 ;
					}
					else if(turn%2==1 && pos2<=96 && startplayer2== 1){
						pos2  = pos2 + 4 ;
					}
				}
				
				else if (dice==5)
				{
					DiceImage  = new ImageIcon(getClass().getResource("dice5.png")) ;
					if (turn%2==0 && pos1<=95 && startplayer1==1)
					{
						pos1 = pos1+5 ;
		                
					}
					else if(turn%2==1 && pos2<=95 && startplayer2== 1){
						pos2  = pos2 + 5 ;
					}
				}
				
				else if (dice==6)
				{
					DiceImage  = new ImageIcon(getClass().getResource("dice6.png")) ;
					if (turn%2==0 && pos1<=94  && startplayer1==0)
					{
						pos1 = pos1+6 ;
						JOptionPane.showMessageDialog(null, "Game Has started for"+one.getname());
		                startplayer1 =1 ;
					}
					else if (turn%2==0 && pos1<=94  && startplayer1==1)
					{
						pos1 = pos1+6 ;
					}
					else if(turn%2==1 && pos2<=94 && startplayer2==0){
						pos2  = pos2 + 6 ;
						JOptionPane.showMessageDialog(null,"Game Has started for"+two.getname() );
						startplayer2 = 1 ;
					}
					else if (turn%2==1 && pos2<=94 && startplayer2==1)
					{
						pos2 = pos2 +6 ;
					}
				}
				
			
				
			//	Condition for laddr PositionMovement
				
				//
				if (pos1==1 || pos2== 1)
				{
				if (pos1==1){	pos1= 38 ; }
				else{
					pos2=38 ; }
				}
				else if (pos1==4 || pos2==4)
				{
					if (pos1==4 ){pos1 = 14; }
					else {pos2= 14 ; }
				}
				
				else if (pos1 ==9 || pos2==9)
				{
					if (pos1==9){pos1=31 ; }
					else {pos2= 31 ; }
				}
				
				else if (pos1==28 || pos2==28)
				{
					if (pos1 == 28){ pos1=84 ; }
					
					else{ pos2 = 84 ; }
				}
				
				else if (pos1 ==80 || pos2==80)
				{
					if (pos1==80){ pos1 = 100 ; }
					
					else {pos2 =100; } 
				}
				
				/*
				Condition for Snake Movement Position
				
				*/
				
				else if (pos1==17 || pos2==17 )
				{
					if (pos1==17)
					{
						pos1 = 7 ;
					}
					else{
						pos2 = 7 ;
					}
				}
				
				
				else if (pos1==62 || pos2== 62 )
				{
					if (pos1==62)
					{
						pos1 = 19 ;
					}
					else{
						pos2 = 19 ;
					}
				}
				
				else if (pos1==54 || pos2==54 )
				{
					if (pos1==54)
					{
						pos1 = 34 ;
					}
					else{
						pos2 = 34 ;
					}
				}
				
				
				else if (pos1==64 || pos2==64 )
				{
					if (pos1==64)
					{
						pos1 = 60 ;
					}
					else{
						pos2 = 60 ;
					}
				}
				
				
				else if (pos1==87 || pos2==87 )
				{
					if (pos1==87)
					{
						pos1 = 24 ;
					}
					else{
						pos2 = 24 ;
					}
				}
				
				
				else if (pos1==93 || pos2==93 )
				{
					if (pos1==93)
					{
						pos1 = 73 ;
					}
					else{
						pos2 = 73 ;
					}
				}
				
				else if (pos1==95 || pos2==95 )
				{
					if (pos1==95)
					{
						pos1 = 75 ;
					}
					else{
						pos2 = 75 ;
					}
				}
				
				else if (pos1==98 || pos2==98 )
				{
					if (pos1==98)
					{
						pos1 = 72 ;
					}
					else{
						pos2 = 72 ;
					}
				}
				
				
				showDice.setIcon(DiceImage);
				
				showDice.setBounds(100, 350, 128, 128);
				
				controllPanel.add(showDice);
				
				
				try {
					showPlayer1.setBounds(location[pos1]);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				//	System.out.println("Array is out of bound");
					
				}
			    showPlayer1.setVisible(true);
			    Board.add(showPlayer1);
			
			    
			    
				try {
					showPlayer2.setBounds(location[pos2]);
				} catch (Exception e) {
					
			//	System.out.println("Array is out bound");
				}
				showPlayer2.setVisible(true);
				Board.add(showPlayer2) ;
				
				System.out.println(dice+"  "+pos1+" "+pos2);
				
			            if (pos1==100)
					{
						
			            	new CongratesWindow(one.getname());
					}
				if (pos2==100)
				{
					
					new CongratesWindow(two.getname()) ;
				}
				
				turn++ ;				
			}
		}
		);	
	}
	
	
	public GameBoard(String s1 ,String s2,String s3,String s4)
	{	
		redImage = new ImageIcon(getClass().getResource("red.png")) ;
	    yellowImage = new ImageIcon(getClass().getResource("yellow.png")); 
		buttonImage = new ImageIcon(getClass().getResource("Dice.png")) ;
		redPlayerImage = new ImageIcon(getClass().getResource("RedPlayer.png"));
		yellowPlayerImage = new ImageIcon(getClass().getResource("yellowPlayer.png"));
		bluePlayer = new ImageIcon(getClass().getResource("bluePlayer.png")) ;
		greenPlayer = new ImageIcon(getClass().getResource("greenPlayer.png")) ;
		whitePlayer = new ImageIcon(getClass().getResource("whitePlayer.png")) ;
		
           
		
		showMessage = new JLabel() ;
		JLabel showDice = new JLabel();
		
		one = new Player() ;
		two = new Player() ;
		three = new Player() ;
		four = new Player() ;
		
		pos1 = 0;
		pos2 = 0;
		pos3 = 0;
		pos4 = 0 ;
		
		turn =0 ;
		
		one.setPlayer(s1);
		two.setPlayer(s2);
        three.setPlayer(s3);
		four.setPlayer(s4);
   	
		//Initialisation of the PlayerPosition which is Zero by Default 

		
		showPlayer1 = new JLabel(redPlayerImage);
		showPlayer2 = new JLabel(yellowPlayerImage) ;
		showPlayer3 = new JLabel(bluePlayer) ;
        showPlayer4 = new JLabel(greenPlayer);
    	location = new Rectangle[101]; 
		
		
		//set window Method For App GUI
		
		setResizable(false);
		setTitle("Snake Ladder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1920,1080);
		setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		
		//set SnakeLadderBoard Image Panel On MainFrame 
		
		Board = new MyGamePanel();
		Board.setBackground(Color.WHITE);
		Board.setBounds(0, 0,1072, 743);
		getContentPane().add(Board) ;
		Board.setLayout(null);
		
		
		//  showing red and yellow icon on every square of the Snake Ladder Panel for showing the movement of the Dice of Player//
		//By this method we are getting the position of each square in the SnakeLadderBoard Panel so that we can track the movement
		//of the Player
		
		int index = 1 ;
		int i=36 ;
		int k = 672 ;
		int j  ;
		int count = 10 ;
		
		while(count!=0)
		{
			if (count%2==0)
			{
				for ( j=1;j<=10;j++)
				{
					JLabel label = new JLabel("");
					//label.setIcon(new ImageIcon(getClass().getResource("redPlayer.png")) );
					label.setBounds(i, k, 50, 45);
					location[index] = label.getBounds() ;
					i = i+105 ;
					index++ ;
					label.setVisible(false);
				}
				count-- ;
				 k = (k-73) ;
				 i = i-105 ;
			}
			else if (count%2==1)
			{
				for (j=1;j<=10;j++)
				{
					JLabel label = new JLabel("");
					//label.setIcon(new ImageIcon(getClass().getResource("redPlayer.png")) );
					label.setBounds(i, k, 50, 45);
					location[index] = label.getBounds() ;
					i = i-105 ;
					index++ ;
				}
				k= k-73 ;
				i = i+105 ;
				count-- ;
			}
		}

		
		//set Control Method or Button ,Jlabel on Control Panel
		
		controllPanel = new JPanel();
		controllPanel.setBackground(Color.WHITE);
		controllPanel.setBounds(1078, 0, 286, 743);
		getContentPane().add(controllPanel);
		controllPanel.setLayout(null);
		
		//showing player 2 label
		
		PlayerNameLabel1 = new JLabel(one.getname());
		PlayerNameLabel1.setFont(new Font("SansSerif", Font.BOLD, 14));
		PlayerNameLabel1.setIcon(redPlayerImage);
		PlayerNameLabel1.setBounds(32, 7, 125, 48);
		controllPanel.add(PlayerNameLabel1);
		
		PlayerNameLabel2 = new JLabel(two.getname());
		PlayerNameLabel2.setFont(new Font("SansSerif", Font.BOLD, 14));
		PlayerNameLabel2.setIcon(yellowPlayerImage);	
		PlayerNameLabel2.setBounds(32, 57, 125, 48);
		controllPanel.add(PlayerNameLabel2);
		
		
		PlayerNameLabel3 = new JLabel(three.getname());
		PlayerNameLabel3.setFont(new Font("SansSerif", Font.BOLD, 14));
		PlayerNameLabel3.setIcon(bluePlayer);
		PlayerNameLabel3.setBounds(32, 107, 125, 48);
		controllPanel.add(PlayerNameLabel3) ;
		
		PlayerNameLabel4 = new JLabel(four.getname());
		PlayerNameLabel4.setFont(new Font("SansSerif", Font.BOLD, 14));
		PlayerNameLabel4.setIcon(greenPlayer);
		PlayerNameLabel4.setBounds(32, 157, 125, 48);
		controllPanel.add(PlayerNameLabel4) ;
		
		btnRollDice = new JButton(buttonImage);
		btnRollDice.setBounds(50, 207, 128, 128);
		btnRollDice.setBackground(Color.WHITE);
		controllPanel.add(btnRollDice);
		
		
		ShowDiceNumberLabel = new JLabel("Dice Number ");
		ShowDiceNumberLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
		ShowDiceNumberLabel.setBounds(15, 335, 110, 36);
	    
		
		controllPanel.add(ShowDiceNumberLabel);
		RandomGenerator ob = new RandomGenerator() ;
		
		
		
		showMessage.setText("Now is "+one.getname()+"'s Turn");
		showMessage.setBounds(50, 500-30, 180, 150);
		showMessage.setFont(new Font("SansSerif", Font.BOLD, 14));
		controllPanel.add(showMessage) ; 
		
		showDice.setBounds(100, 405, 128, 128);
		
		
		startplayer1 = 0 ;
		startplayer2 = 0 ;
		startplayer3 = 0 ;
		startplayer4 = 0 ;
		
		btnRollDice.addActionListener(new ActionListener() {
			int  dice ;
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				dice = ob.getDiceNum() ;
              
                if (turn%4==0)
                {
                	showMessage.setText("Now is "+two.getname()+"'s Turn");
                }
				
                else if (turn%4==1) {
                	showMessage.setText("Now is "+three.getname()+"'s Turn");
                }
                else if (turn%4==2) {
                	showMessage.setText("Now is "+four.getname()+"'s Turn");
                }
                else {
                	showMessage.setText("Now is "+one.getname()+"'s Turn");
                }
                
                
				if (dice==1)
				{
					DiceImage  = new ImageIcon(getClass().getResource("dice1.png")) ;
			    
					if (turn%4==0 && pos1<=99 && startplayer1 == 1)
					{
						pos1 = pos1+1 ;
					}
					else if(turn%4==1 && pos2<=99 && startplayer2 == 1 ) {
						pos2  = pos2 + 1 ;
					}
					else if (turn%4==2 && pos3<=99 && startplayer3 == 1)
					{
						pos3 = pos3 +1 ;
					}
					else if (turn%4==3 && pos4<=99 && startplayer4 == 1)
					{
						pos4 = pos4 +1 ;
					}
				}
		     		
				else if (dice==2)
				{
					DiceImage  = new ImageIcon(getClass().getResource("dice2.png")) ;
					
					if (turn%4==0 && pos1<=98 && startplayer1 == 1)
					{
						pos1 = pos1+2 ;
					}
					else if(turn%4==1 && pos2<=98 && startplayer2 == 1){
						pos2  = pos2 + 2 ;
					}
					else if (turn%4==2 && pos3<=98 && startplayer3 == 1)
					{
						pos3 = pos3 +2 ;
					}
					else if (turn%4==3 && pos4<=98 && startplayer4 == 1)
					{
						pos4 = pos4+2 ;
					}
				}
				
				else if (dice==3)
				{
					DiceImage  = new ImageIcon(getClass().getResource("dice3.png")) ;
					if (turn%4==0 && pos1<=97 && startplayer1 == 1)
					{
						pos1 = pos1+3 ;
					}
					else if (turn%4==1 && pos2<=97 && startplayer2 == 1){
						pos2  = pos2 + 3 ;
					}
					else if (turn%4==2 && pos3<=97 && startplayer3 == 1)
					{
						pos3 = pos3 +3 ;
					}
					else if (turn%4==3 && pos4<=97 && startplayer4 == 1)
					{
						pos4 = pos4 +3 ;
					}
				}
				
				else if (dice==4)
				{
					DiceImage  = new ImageIcon(getClass().getResource("dice4.png")) ;
					if (turn%4==0 && pos1<=96 && startplayer1 == 1)
					{
						pos1 = pos1+4 ;
					}
					else if(turn%4==1 && pos2<=96 && startplayer2 == 1){
						pos2  = pos2 + 4 ;
					}
					else if (turn%4==2 && pos3<=96 && startplayer3 == 1)
					{
						pos3 = pos3 + 4 ;
					}
					else if (turn%4==2 && pos4<=96 && startplayer4 == 1)
					{
						pos4 = pos4 +4 ;
					}
				}
				
				else if (dice==5)
				{
					DiceImage  = new ImageIcon(getClass().getResource("dice5.png")) ;
					if (turn%4==0 && pos1<=95 && startplayer1 == 1)
					{
						pos1 = pos1+5 ;
		                
					}
					else if(turn%4==1 && pos2<=95 && startplayer2 == 1){
						pos2  = pos2 + 5 ;
					}
					else if (turn%4==2 && pos3<=95 && startplayer3 == 1)
					{
						pos3 = pos3 +5 ;
					}
					else if(turn%4==3 && pos4<=95 && startplayer4 == 1)
					{
						pos4 = pos4 + 5 ;
					}
				}
				
				else if (dice==6)
				{
					DiceImage  = new ImageIcon(getClass().getResource("dice6.png")) ;
					
					if (turn%4==0 && pos1<=94 && startplayer1==0)
					{
						startplayer1 = 1 ; 
						pos1 = pos1+6 ;
						JOptionPane.showMessageDialog(null, "Game has started for  "+one.getname());
						  
					}
					else if (turn%4==0 && pos1<=94 && startplayer1==1)
					{
						pos1 = pos1+6 ; 
					}
					
					else if (turn%4==1 && pos2<=94 && startplayer2==0)
					{
						startplayer2 = 1 ;
						pos2  = pos2 + 6 ;
						JOptionPane.showMessageDialog(null, "Game has started for  "+two.getname());
						 
					}
					else if(turn%4==1 && pos2<=94 && startplayer2== 1){
						pos2  = pos2 + 6 ;
						
					}
					else if (turn%4==2 && pos3<=94 && startplayer3==0)
					{
						startplayer3 = 1 ;
						pos3 = pos3 +6 ;
						JOptionPane.showMessageDialog(null, "Game has started for  "+three.getname());
						
					}
					
					else if (turn%4==2 && pos3<=94 && startplayer3==1){
						pos3 = pos3 +6 ;
					}
					
					else if (turn%4==3 && pos4<=94 && startplayer4==0)
					{
						startplayer4 = 1 ;
						pos4 = pos4 +6 ;
						JOptionPane.showMessageDialog(null, "Game has started for  "+four.getname());
					}
					
					else if (turn%4==3 && pos4<=94 && startplayer4==1){
						pos4 = pos4 +6 ;
					}
				}
				
			//	Condition for ladder PositionMovement
				
				if (pos1==1 || pos2== 1 || pos3==1 || pos4==1)
				{
				if (pos1==1){	pos1= 38 ; }
				else if (pos3==1){pos3 = 38 ;}
				else if (pos4==1){ pos4 = 38 ;}
				else{pos2=38 ; }
				}
				
				else if (pos1==4 || pos2==4 || pos3==4 || pos4==4)
				{
					if (pos1==4 ){pos1 = 14; }
					
					else if (pos4==4){ pos4 =14 ;}
					else if (pos3==4){
						pos3 = 14 ;
					}
					else { pos2= 14 ; }
				}
				
				else if (pos1 ==9 || pos2==9 || pos3==9 || pos4 ==9)
				{
					if (pos1==9){pos1=31 ; }
					else if (pos4==9){	pos4 = 31 ; }
					else if (pos3==9){	pos3 = 31 ; }
					else {pos2= 31 ; }
				}
				
				else if (pos1==28 || pos2==28 || pos3==28 || pos4==9)
				{
					if (pos1 == 28){ pos1=84 ; }
					
					else if (pos4==28){	pos4 = 84 ; }
					
					else if (pos3==1){	pos3 = 84 ; }
					else{ pos2 = 84 ; }
				}
				
				else if (pos1 ==80 || pos2==80 || pos3==80 || pos4==80)
				{
					if (pos1==80){ pos1 = 100 ; }
					else if (pos4==80){	pos4 = 100 ; }
					else if (pos3==80){	pos3 = 100 ; }
					else {pos2 =100; } 
				}
				
				/*
				Condition for Snake Movement Position
				
				*/
				
				else if (pos1==17 || pos2==17 || pos3==17 || pos4==17 )
				{
					if (pos1==17){pos1 = 7;}
					else if (pos4==17)     {pos4=7;}
					else if (pos3==17)     {pos3=7;}
					else{pos2 = 7 ; }
				}
				
				
				else if (pos1==62 || pos2== 62 || pos3==62 ||pos4==62)
				{
					if (pos1==62){pos1=19 ;}
					else if (pos4==62){pos4=19;}   
					else if (pos3==62){pos3=19;}    
					else{
						pos2 = 19 ;
					}
				}
				
				else if (pos1==54 || pos2==54 || pos3 ==54 || pos4==54)
				{
					if (pos1==54)
					{
						pos1 = 34 ;
					}
					else if (pos4==54) {  pos4 = 34;}
					else if (pos3==54) {  pos3 = 34;}
					else{
						pos2 = 34 ;
					}
				}
				
				
				else if (pos1==64 || pos2==64 || pos3==64  || pos4==64)
				{
					if (pos1==64)
					{
						pos1 = 60 ;
					}
					else if (pos4==64){ pos4 = 60   ;}
					else if (pos3==64){ pos3 = 60   ;}
					else{
						
						pos2 = 60 ;
					}
				}
				
				
				else if (pos1==87 || pos2==87  || pos3==87||pos4==87)
				{
					if (pos1==87)
					{
						pos1 = 24 ;
					}
					else if (pos3==87){pos3=24;}
					else if (pos4==87){pos4=24;}
					
					else{
						pos2 = 24 ;
					}
				}
				
				
				else if (pos1==93 || pos2==93 || pos3==93 || pos4==93)
				{
					if (pos1==93)
					{
						pos1 = 73 ;
					}
					else if (pos4==93){pos4=73;}
					else if (pos3==93){pos3=73;}
					else{
						pos2 = 73 ;
					}
				}
				
				else if (pos1==95 || pos2==95 || pos3==95 || pos4==95)
				{
					if (pos1==95)
					{
						pos1 = 75 ;
					}
					else if (pos4==95){pos4 = 75;}
					else if (pos3==95){pos3 = 75;}
					else{
						pos2 = 75 ;
					}
				}
				
				else if (pos1==98 || pos2==98 || pos3==98 || pos4==98)
				{
					if (pos1==98)
					{
						pos1 = 72 ;
					}
					else if (pos4==98){pos4=72;}
					else if (pos3==98){pos3=72;}
					else{
						pos2 = 72 ;
					}
				}
				
				
				showDice.setIcon(DiceImage);
				
				controllPanel.add(showDice);
				
				
				try {
					showPlayer1.setBounds(location[pos1]);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println("Array is out of bound");
					
				}
			    showPlayer1.setVisible(true);
			    Board.add(showPlayer1);
			
			    
			    
				try {
					showPlayer2.setBounds(location[pos2]);
				} catch (Exception e) {
					
			//	System.out.println("Array is out bound");
				}
				showPlayer2.setVisible(true);
				Board.add(showPlayer2) ;
				
				
				
				try {
					showPlayer3.setBounds(location[pos3]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
				//	System.out.println("Array is out bound");
				}
				showPlayer3.setVisible(true);
				Board.add(showPlayer3) ;
				
				try {
					showPlayer4.setBounds(location[pos4]);
				} catch (Exception e) {
					
			//	System.out.println("Array is out bound");
				}
				showPlayer4.setVisible(true);
				Board.add(showPlayer4) ;
				
				
			//	System.out.println(dice+"  "+pos1+" "+pos2+" "+pos3);
				
			            if (pos1==100)
					{
						
			            	new CongratesWindow(one.getname());
					}
			            else if (pos2==100)
				{
					
					new CongratesWindow(two.getname()) ;
				}
			            else if (pos3==100)
			            {
			            	new CongratesWindow(three.getname());
			            }
			            else if (pos4==100)
			            {
			            	new CongratesWindow(four.getname());
			            }
				
				turn++ ;				
			}
		}
		);	
		
	}
	
	public GameBoard(String s1 ,String s2,String s3)
	{	
		redImage = new ImageIcon(getClass().getResource("red.png")) ;
	    yellowImage = new ImageIcon(getClass().getResource("yellow.png")); 
		buttonImage = new ImageIcon(getClass().getResource("Dice.png")) ;
		redPlayerImage = new ImageIcon(getClass().getResource("RedPlayer.png"));
		yellowPlayerImage = new ImageIcon(getClass().getResource("yellowPlayer.png"));
		bluePlayer = new ImageIcon(getClass().getResource("bluePlayer.png")) ;
		greenPlayer = new ImageIcon(getClass().getResource("greenPlayer.png")) ;
		whitePlayer = new ImageIcon(getClass().getResource("whitePlayer.png")) ;
		
           
		
		showMessage = new JLabel() ;
		JLabel showDice = new JLabel();
		
		one = new Player() ;
		two = new Player() ;
		three = new Player() ;
		
		pos1 = 0;
		pos2 = 0;
		pos3 = 0;
		
		
		turn =0 ;
		
		one.setPlayer(s1);
		two.setPlayer(s2);
        three.setPlayer(s3);
		
   	
		//Initialisation of the PlayerPosition which is Zero by Default 

		
		showPlayer1 = new JLabel(redPlayerImage);
		showPlayer2 = new JLabel(yellowPlayerImage) ;
		showPlayer3 = new JLabel(bluePlayer) ;
        
    	location = new Rectangle[101]; 
		
		
		//set window Method For App GUI
		
		setResizable(false);
		setTitle("Snake Ladder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,1920,1080);
		setBackground(Color.BLACK);
		getContentPane().setLayout(null);
		setVisible(true);
		setLocationRelativeTo(null);
		
		//set SnakeLadderBoard Image Panel On MainFrame 
		
		Board = new MyGamePanel();
		Board.setBackground(Color.WHITE);
		Board.setBounds(6, 0,1072, 743);
		getContentPane().add(Board) ;
		Board.setLayout(null);
		
		
		//  showing red and yellow icon on every square of the Snake Ladder Panel for showing the movement of the Dice of Player//
		//By this method we are getting the position of each square in the SnakeLadderBoard Panel so that we can track the movement
		//of the Player
		
		int index = 1 ;
		int i=36 ;
		int k = 672 ;
		int j  ;
		int count = 10 ;
		
		while(count!=0)
		{
			if (count%2==0)
			{
				for ( j=1;j<=10;j++)
				{
					JLabel label = new JLabel("");
					//label.setIcon(new ImageIcon(getClass().getResource("redPlayer.png")) );
					label.setBounds(i, k, 50, 45);
					location[index] = label.getBounds() ;
					i = i+105 ;
					index++ ;
					label.setVisible(false);
				}
				count-- ;
				 k = (k-73) ;
				 i = i-105 ;
			}
			else if (count%2==1)
			{
				for (j=1;j<=10;j++)
				{
					JLabel label = new JLabel("");
					//label.setIcon(new ImageIcon(getClass().getResource("redPlayer.png")) );
					label.setBounds(i, k, 50, 45);
					location[index] = label.getBounds() ;
					i = i-105 ;
					index++ ;
				}
				k= k-73 ;
				i = i+105 ;
				count-- ;
			}
		}

		
		//set Control Method or Button ,Jlabel on Control Panel
		
		controllPanel = new JPanel();
		controllPanel.setBackground(Color.WHITE);
		controllPanel.setBounds(1078, 0, 286, 743);
		getContentPane().add(controllPanel);
		controllPanel.setLayout(null);
		
		//showing player 2 label
		
		PlayerNameLabel1 = new JLabel(one.getname());
		PlayerNameLabel1.setFont(new Font("SansSerif", Font.BOLD, 14));
		PlayerNameLabel1.setIcon(redPlayerImage);
		PlayerNameLabel1.setBounds(32, 7, 125, 48);
		controllPanel.add(PlayerNameLabel1);
		
		PlayerNameLabel2 = new JLabel(two.getname());
		PlayerNameLabel2.setFont(new Font("SansSerif", Font.BOLD, 14));
		PlayerNameLabel2.setIcon(yellowPlayerImage);	
		PlayerNameLabel2.setBounds(32, 57, 125, 48);
		controllPanel.add(PlayerNameLabel2);
		
		
		PlayerNameLabel3 = new JLabel(three.getname());
		PlayerNameLabel2.setFont(new Font("SansSerif", Font.BOLD, 14));
		PlayerNameLabel3.setIcon(bluePlayer);
		PlayerNameLabel3.setBounds(32, 107, 125, 48);
		controllPanel.add(PlayerNameLabel3) ;
		
		
		
		btnRollDice = new JButton(buttonImage);
		btnRollDice.setBounds(50, 177, 128, 128);
		btnRollDice.setBackground(Color.WHITE);
		controllPanel.add(btnRollDice);
		
		
		ShowDiceNumberLabel = new JLabel("Dice Number ");
		ShowDiceNumberLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
		ShowDiceNumberLabel.setBounds(15, 315, 110, 36);
	
		
		controllPanel.add(ShowDiceNumberLabel);
		RandomGenerator ob = new RandomGenerator() ;
		
		
		
		showMessage.setText("Now is "+one.getname()+"'s Turn");
		showMessage.setBounds(50, 500-30, 180, 150);
		showMessage.setFont(new Font("SansSerif", Font.BOLD, 14));
		controllPanel.add(showMessage) ; 
		
		showDice.setBounds(100, 355, 128, 128);
		
		
		startplayer1 = 0 ;
		startplayer2 = 0 ;
		startplayer3 = 0 ;
		
		
		btnRollDice.addActionListener(new ActionListener() {
			int  dice ;
			
			@Override
			public void actionPerformed(ActionEvent event) {
				
				dice = ob.getDiceNum() ;
              
                if (turn%3==0)
                {
                	showMessage.setText("Now is "+two.getname()+"'s Turn");
                }
				
                else if (turn%3==1) {
                	showMessage.setText("Now is "+three.getname()+"'s Turn");
                }
                else {
                	showMessage.setText("Now is "+one.getname()+"'s Turn");
                }
           
				if (dice==1)
				{
					DiceImage  = new ImageIcon(getClass().getResource("dice1.png")) ;
			    
					if (turn%3==0 && pos1<=99 && startplayer1 == 1)
					{
						pos1 = pos1+1 ;
					}
					else if(turn%3==1 && pos2<=99 && startplayer2 == 1 ) {
						pos2  = pos2 + 1 ;
					}
					else if (turn%3==2 && pos3<=99 && startplayer3 == 1)
					{
						pos3 = pos3 +1 ;
					}
				}
		     		
				else if (dice==2)
				{
					DiceImage  = new ImageIcon(getClass().getResource("dice2.png")) ;
					
					if (turn%3==0 && pos1<=98 && startplayer1 == 1)
					{
						pos1 = pos1+2 ;
					}
					else if(turn%3==1 && pos2<=98 && startplayer2 == 1){
						pos2  = pos2 + 2 ;
					}
					else if (turn%3==2 && pos3<=98 && startplayer3 == 1)
					{
						pos3 = pos3 +2 ;
					}
				}
				
				else if (dice==3)
				{
					DiceImage  = new ImageIcon(getClass().getResource("dice3.png")) ;
					if (turn%3==0 && pos1<=97 && startplayer1 == 1)
					{
						pos1 = pos1+3 ;
					}
					else if (turn%3==1 && pos2<=97 && startplayer2 == 1){
						pos2  = pos2 + 3 ;
					}
					else if (turn%3==2 && pos3<=97 && startplayer3 == 1)
					{
						pos3 = pos3 +3 ;
					}
				}
				
				else if (dice==4)
				{
					DiceImage  = new ImageIcon(getClass().getResource("dice4.png")) ;
					if (turn%3==0 && pos1<=96 && startplayer1 == 1)
					{
						pos1 = pos1+4 ;
					}
					else if(turn%3==1 && pos2<=96 && startplayer2 == 1){
						pos2  = pos2 + 4 ;
					}
					else if (turn%3==2 && pos3<=96 && startplayer3 == 1)
					{
						pos3 = pos3 + 4 ;
					}
				}
				
				else if (dice==5)
				{
					DiceImage  = new ImageIcon(getClass().getResource("dice5.png")) ;
					if (turn%3==0 && pos1<=95 && startplayer1 == 1)
					{
						pos1 = pos1+5 ;
		                
					}
					else if(turn%3==1 && pos2<=95 && startplayer3 == 1){
						pos2  = pos2 + 5 ;
					}
					else if (turn%3==2 && pos3<=95 && startplayer2 == 1)
					{
						pos3 = pos3 +5 ;
					}
				}
				
				else if (dice==6)
				{
					DiceImage  = new ImageIcon(getClass().getResource("dice6.png")) ;
					
					if (turn%3==0 && pos1<=94 && startplayer1==0)
					{
						startplayer1 = 1 ; 
						pos1 = pos1+6 ;
						JOptionPane.showMessageDialog(null, "Game has started for  "+one.getname());
						  
					}
					else if (turn%3==0 && pos1<=94 && startplayer1==1)
					{
						pos1 = pos1+6 ; 
					}
					
					else if (turn%3==1 && pos2<=94 && startplayer2==0)
					{
						startplayer2 = 1 ;
						pos2  = pos2 + 6 ;
						JOptionPane.showMessageDialog(null, "Game has started for  "+two.getname());
						 
					}
					else if(turn%3==1 && pos2<=94 && startplayer2== 1){
						pos2  = pos2 + 6 ;
						
					}
					else if (turn%3==2 && pos3<=94 && startplayer3==0)
					{
						startplayer3 = 1 ;
						pos3 = pos3 +6 ;
						JOptionPane.showMessageDialog(null, "Game has started for  "+three.getname());
						
					}
					
					else if (turn%3==2 && pos3<=94 && startplayer3==1){
						pos3 = pos3 +6 ;
					}
				}
				
			//	Condition for ladder PositionMovement
				
				if (pos1==1 || pos2== 1 || pos3==1)
				{
				if (pos1==1){	pos1= 38 ; }
				else if (pos3==1){pos3 = 38 ;}
				else{pos2=38 ; }
				}
				
				else if (pos1==4 || pos2==4 || pos3==4)
				{
					if (pos1==4 ){pos1 = 14; }
					else if (pos3==4){
						pos3 = 14 ;
					}
					else { pos2= 14 ; }
				}
				
				else if (pos1 ==9 || pos2==9 || pos3==9)
				{
					if (pos1==9){pos1=31 ; }
					else if (pos3==9){	pos3 = 31 ; }
					else {pos2= 31 ; }
				}
				
				else if (pos1==28 || pos2==28 || pos3==28 )
				{
					if (pos1 == 28){ pos1=84 ; }
					else if (pos3==1){	pos3 = 84 ; }
					else{ pos2 = 84 ; }
				}
				
				else if (pos1 ==80 || pos2==80 || pos3==80)
				{
					if (pos1==80){ pos1 = 100 ; }
					else if (pos3==80){	pos3 = 100 ; }
					else {pos2 =100; } 
				}
				
				/*
				Condition for Snake Movement Position
				
				*/
				
				else if (pos1==17 || pos2==17 || pos3==17 )
				{
					if (pos1==17){pos1 = 7;}
					else if (pos3==17)     {pos3=7;}
					else{pos2 = 7 ; }
				}
				
				
				else if (pos1==62 || pos2== 62 || pos3==62 )
				{
					if (pos1==62){pos1=19 ;}
					else if (pos3==62){pos3=19;}    
					else{
						pos2 = 19 ;
					}
				}
				
				else if (pos1==54 || pos2==54 || pos3 ==54 )
				{
					if (pos1==54)
					{
						pos1 = 34 ;
					}
					else if (pos3==54) {  pos3 = 34            ;}
					else{
						pos2 = 34 ;
					}
				}
				
				
				else if (pos1==64 || pos2==64 || pos3==64 )
				{
					if (pos1==64)
					{
						pos1 = 60 ;
					}
					else if (pos3==64){ pos3 = 60   ;}
					else{
						
						pos2 = 60 ;
					}
				}
				
				
				else if (pos1==87 || pos2==87  || pos3==87)
				{
					if (pos1==87)
					{
						pos1 = 24 ;
					}
					else if (pos3==87){pos3=24;}
					else{
						pos2 = 24 ;
					}
				}
				
				
				else if (pos1==93 || pos2==93 || pos3==93 )
				{
					if (pos1==93)
					{
						pos1 = 73 ;
					}
					else if (pos3==93){pos3=73;}
					else{
						pos2 = 73 ;
					}
				}
				
				else if (pos1==95 || pos2==95 || pos3==95)
				{
					if (pos1==95)
					{
						pos1 = 75 ;
					}
					else if (pos3==95){pos3 = 75;}
					else{
						pos2 = 75 ;
					}
				}
				
				else if (pos1==98 || pos2==98 || pos3==98)
				{
					if (pos1==98)
					{
						pos1 = 72 ;
					}
					else if (pos3==98){pos3=72;}
					else{
						pos2 = 72 ;
					}
				}
				
				
				showDice.setIcon(DiceImage);
				
				controllPanel.add(showDice);
				
				
				try {
					showPlayer1.setBounds(location[pos1]);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
				//	System.out.println("Array is out of bound");
					
				}
			    showPlayer1.setVisible(true);
			    Board.add(showPlayer1);
			
			    
			    
				try {
					showPlayer2.setBounds(location[pos2]);
				} catch (Exception e) {
					
			//	System.out.println("Array is out bound");
				}
				showPlayer2.setVisible(true);
				Board.add(showPlayer2) ;
				
				
				
				try {
					showPlayer3.setBounds(location[pos3]);
				} catch (Exception e) {
					// TODO Auto-generated catch block
			//		System.out.println("Array is out bound");
				}
				showPlayer3.setVisible(true);
				Board.add(showPlayer3) ;
				
			//	System.out.println(dice+"  "+pos1+" "+pos2+" "+pos3);
				
			            if (pos1==100)
					{
						
			            	new CongratesWindow(one.getname());
					}
			            else if (pos2==100)
				{
					
					new CongratesWindow(two.getname()) ;
				}
			            else if (pos3==100)
			            {
			            	new CongratesWindow(three.getname());
			            }
				
				turn++ ;				
			}
		}
		);	
		
	}
}
