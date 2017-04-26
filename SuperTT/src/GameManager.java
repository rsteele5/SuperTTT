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
    protected boolean activeGame;
    protected boolean readyToSendMove;
    protected int boardReference [][];
    protected int CurrentMove, currCol, currRow;
    
    public GameManager()
    {
        activeGame = true;
        readyToSendMove = false;
        boardReference = new int[][] {{0,0,0,0,0},
                                      {0,0,0,0,0},
                                      {0,0,0,0,0},
                                      {0,0,0,0,0},
                                      {0,0,0,0,0}};
        CurrentMove = -1;
        currCol = 0;
        currRow = 0;
        this.whoGoesFirst();
    } 
    
    public abstract int whoGoesFirst();
    protected void playerMove(int move)
    {
        this.setCurrentMove(move);
        this.validateMove();
    }
    //sets the current variable to the index of the latest move 
    protected void setCurrentMove(int num) 
    {
        CurrentMove = num;
        
        if(num >= 0 && num <=24)
        {
            currCol = 0;
            currRow = 0;
            int temp = num;
            
            while(temp > 0)
            {
                if(currCol < 4)
                    ++currCol;
                else
                {
                    currCol = 0;
                    ++currRow;
                }
                --temp;
            }
        }
    }
    //validateMove will also be running gameOver()...keeping track of boardsize
    protected abstract void validateMove();
    protected abstract void gameOver();
    //validateMove() will be called inside of move()
    

}
