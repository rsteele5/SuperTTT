/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Remington Steele
 */
public class Standalone extends GameManager
{
    //standalone version enables a person to play against the game AI
    
    //while game is active, make move again game AI
    /*while(activeGame){
    
    
    }
    */
    public int whoGoesFirst(){return 0;}
    public void playerMove(){}
    protected boolean validateMove()
    {
        return true;
    }
    
    protected void gameOver(){
    
    }
}
