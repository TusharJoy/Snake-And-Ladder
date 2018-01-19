import java.awt.EventQueue;

import javax.swing.UIManager;


public class Application {
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					try 
				    { 
				        UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
				    } 
				    catch(Exception e){ 
				    }
					new MainWindow() ;
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
