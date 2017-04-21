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
    protected boolean validateMove()
    {
        if((CurrentMove >= 0) && (CurrentMove <= 24))
        {
            /*if(Spot is not currently taken)
            {
                it is okay to 
            }
            else{Can't move there}
            */
            return true;
        }
        else{/*Move does not exist*/return false;}
        
    }
    protected void gameOver(){
    
    }
    public int whoGoesFirst(){
         return 1; 
    }
    
}
