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
    protected boolean activeGame = true;
    protected boolean readyToSendMove = false;
    protected int CurrentMove = -1;
    
    protected void runGame()
    {
        this.whoGoesFirst();
        
        while(this.activeGame) {this.move();}
        
        this.gameOver();
    }
    protected abstract void whoGoesFirst();
    protected abstract void move();
    //validateMove() will be called inside of move()
    protected abstract boolean validateMove();
    protected abstract void gameOver();
}
