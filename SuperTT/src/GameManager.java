
import java.util.Random;

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
    public Random rando;
    protected AI ai;
    
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
        
        ai = new AI();
        rando = new Random();
        rando.nextInt(101);
        
//        jtextfield ("Random number is: " + random);
//        if (client)
//        client.send(rando);
//        else
//        server.send(rando);
    } 
    
    public abstract int playerMove(int move) throws STTT_Exception;
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
    protected void validateMove() throws STTT_Exception
    {
        if(CurrentMove >= 0 || CurrentMove <= 24)
        {    
            if(boardReference[currRow][currCol] == 0)
            {
                //Move is Valid
            }
            else
            {throw new STTT_Exception(CurrentMove + " has already been taken.");}
        }
        else
        {throw new STTT_Exception(CurrentMove + " is out of bounds, fam");}
    }
  
    protected void gameOver(){}
}
