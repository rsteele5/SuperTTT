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
    
<<<<<<< HEAD
<<<<<<< HEAD
    protected abstract boolean validateMove();
    
    
    
    protected abstract void gameOver();
    public abstract int whoGoesFirst();
=======
    protected void runGame()
    {
        this.whoGoesFirst();
=======
    public void setCurrentMove(int num) {CurrentMove = num;}
>>>>>>> refs/remotes/origin/master
        
    public abstract int whoGoesFirst();
    public abstract void playerMove();
    //validateMove() will be called inside of move()
    protected abstract boolean validateMove();
    protected abstract void gameOver();
>>>>>>> refs/remotes/origin/master
}
