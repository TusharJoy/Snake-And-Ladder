
public class Player {
	
	private String  name ;
	private int playerposition ;
	
	public Player() {
	  name = null;
	   playerposition = 0; 
	}
	
	
	public void setPlayer(String name) {
		this.name = name;
	}
	
	
	public String getname() {
		return name;
	}
	
	

	public void setPlayerposition(int playerposition) {
		this.playerposition = playerposition;
	}
	
	
	
	public int getPlayerposition() {
		return playerposition;
	}
	
	
}
