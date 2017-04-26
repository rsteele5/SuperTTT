
import java.util.concurrent.TimeUnit;
import java.lang.InterruptedException;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Remington Steele
 */
public class NetworkMode extends GameManager
{
    //Constructor calls base constructor
    public NetworkMode(){super();}
    
    public int playerMove(int move) throws STTT_Exception
    {
        super.setCurrentMove(move);
        super.validateMove();
        
        super.setCurrentMove(ai.makeMove(CurrentMove));
        super.validateMove();
        return CurrentMove;
    }
    
    
    protected void waitFam() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
    }
}