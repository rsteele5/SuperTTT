

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
<<<<<<< HEAD
    public Standalone(){
      super();
    }
=======
    public Standalone(){super();}
>>>>>>> origin/master
    
    public int playerMove(int move) throws STTT_Exception {           
        //We set current move with the move the AI has made 
        this.setCurrentMove(ai.makeMove(move));
        
        try{
            //call super class validateMove() and use exception 
            //handling for invalid moves caught (outside of 0 and 24)
            super.validateMove(); 
        }
        catch(STTT_Exception e){
            //throw STTT_EXCEPTION("")for invalid move
            throw  STTT_Exception("Your move is outside of the acceptable bounds of 0 < moves < 24"); 
        }
        
        //if there are no invalid moves, sending back valid move from AI
        return CurrentMove; 
    }
}