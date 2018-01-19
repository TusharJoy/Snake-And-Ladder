import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class CongratesWindow extends JFrame {
	
	private CongratesPanel ob ;

	private String s ;
         public CongratesWindow(String in) {
	
        	 super("Congratulation") ;
        	 s = in ;
        	// setForeground(Color.DARK_GRAY);
        	 setSize(400,400);
        	 setLocationRelativeTo(null);
        	 setVisible(true);
        	 setForeground(Color.GREEN);
        	 setLayout(new BorderLayout());
        	 ob =  new CongratesPanel(s);
        
        	 add(ob);
        	
          }

}
