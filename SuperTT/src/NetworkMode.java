
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
    public NetworkMode(){}
    
    public int playerMove(int move)
    {
        return 0;
    }
    
    
    protected void waitFam() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
    }
}
