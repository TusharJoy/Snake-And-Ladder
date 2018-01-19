import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainWindow extends JFrame {

	
	private PlayerSelectionWindow secondPanel ;
	private Panel1 firstPanel ;
	private CardLayout cardLayout ;
    private playerNumberWindow  playernumberwindow ;
    
	public MainWindow() {
		
		super("Snake & Ladder ") ;
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 539);
		setVisible(true);
		setLocationRelativeTo(null);
		
		
		cardLayout = new CardLayout() ;
		secondPanel = new PlayerSelectionWindow() ;
		firstPanel = new Panel1() ;
        playernumberwindow = new playerNumberWindow() ;
		setLayout(cardLayout);
		add(firstPanel,"card1");
		add(secondPanel, "card2");
		add(playernumberwindow,"card3") ;
		
		
		
		playernumberwindow.twoplayerbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				secondPanel.PlayerSelectionTwo() ;
				cardLayout.show(getContentPane(), "card2");
			}
		});
	
		   
	playernumberwindow.threeplayerbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				secondPanel.PlayerSelectionThree();
				cardLayout.show(getContentPane(), "card2");
			}
		});
         
	playernumberwindow.fourplayerbtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			cardLayout.show(getContentPane(), "card2");
			
		}
	});
		


     firstPanel.NewGameButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				cardLayout.show(getContentPane(), "card3");
				
			}
		});
	}
}
