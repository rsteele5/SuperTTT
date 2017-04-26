

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Remington Steele
 */

//standalone version enables a person to play against the game AI
public class Standalone extends GameManager
{
    public Standalone(){
      /* while game is active, make move against game AI
      while (activeGame == true){
          this.playerMove();
      }
      */
    }
    
    public int playerMove(int move){           
        //We set current move with the move the AI has made 
        this.setCurrentMove(ai.makeMove(move));
        
        try{
            //call super class validateMove() and use exception 
            //handling for invalid moves caught (outside of 0 and 24)
            super.validateMove(); 
        }
        catch(Exception e){
            //throw STTT_EXCEPTION("")for invalid move
        }
        
        //if there are no invalid moves, sending back valid move from AI
        return CurrentMove; 
    }
}