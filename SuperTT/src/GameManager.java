/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Remington Steele
 */
public abstract class GameManager 
{
    boolean activeGame = true;
    boolean readyToSendMove = false;
    int CurrentMove = -1;
    
    protected abstract boolean validateMove();
    
    protected void runGame()
    {
        /*
        decide who goes first
        
        loop until game is finshed
        {
            player move
            if(move ends the game)
                gameOver();
        }
        */
    }
    
    protected abstract void gameOver();
}
