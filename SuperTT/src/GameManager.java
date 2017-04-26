
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
    protected int boardReference [][];
    protected int CurrentPlayer, CurrentMove, currCol, currRow, totalMoves;
    public Random rando;
    static public int r; 
    protected AI ai;
    
    public GameManager()
    {
        boardReference = new int[][] {{0,0,0,0,0},
                                      {0,0,0,0,0},
                                      {0,0,0,0,0},
                                      {0,0,0,0,0},
                                      {0,0,0,0,0}};
        CurrentPlayer = 1;
        CurrentMove = -1;
        currCol = 0;
        currRow = 0;
        totalMoves = 0;
        
        ai = new AI();
        rando = new Random();
        r = rando.nextInt(100) + 1; 
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
        if(CurrentMove >= 0 && CurrentMove <= 24)
        {    
            if(boardReference[currRow][currCol] == 0)
            {
                //put move on refernce board
                boardReference[currRow][currCol] = CurrentPlayer;
                
                if(totalMoves >= 9)
                {
                    //Check if move ends the game
                    int hLen = 0, vLen = 0, bsLen = 0, fsLen = 0;
                    for(int i = 0; i < 5; i++)
                    {
                        if(boardReference[i][currCol] == CurrentPlayer) ++vLen;
                        if(boardReference[currRow][i] == CurrentPlayer) ++hLen;
                        if(boardReference[i][i] == CurrentPlayer) ++bsLen;
                        if(boardReference[i][4-i] == CurrentPlayer) ++fsLen;
                    }
                    if(hLen == 5 || vLen == 5 || bsLen == 5 || fsLen == 5)
                    {throw new STTT_Exception(
                            "Player " +CurrentPlayer + " is the winner",
                            CurrentPlayer);}
                }
                
                ++totalMoves;
                if(totalMoves == 25)
                {/*Tie Game*/throw new STTT_Exception("Tie Game",0);}
                
                //Change Player    
                if(CurrentPlayer == 1)
                    ++CurrentPlayer;
                else
                    --CurrentPlayer;             
            }
            else
            {throw new STTT_Exception(CurrentMove + " has already been taken.");}
        }
        else if(CurrentMove == -99)
        {/*This is the first turn and the AI is Going first*/}
        else
        {throw new STTT_Exception(CurrentMove + " is out of bounds, fam");}     
    }
}
