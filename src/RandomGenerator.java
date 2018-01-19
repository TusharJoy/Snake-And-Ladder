import java.util.Random;


public class RandomGenerator  {
	
 private   int  diceNum ;
 private  Random num  = new Random();
  
  public RandomGenerator() {
	diceNum =0 ;
}
  public int getDiceNum()
  {
	  diceNum = 1 + num.nextInt(6) ; 
	  return diceNum ;
  }
 
}
