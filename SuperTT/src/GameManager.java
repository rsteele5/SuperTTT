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
    
    protected abstract boolean validateMove();
    
    
    
    protected abstract void gameOver();
    public abstract int whoGoesFirst();
}
