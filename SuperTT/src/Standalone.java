

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
    
    
    
    @Override
    protected void gameOver(){
    //looking for the win condition or draw condition
     
    //0-4 equal x or o
    if(Gameboard.b[0].getText().equals('X') && Gameboard.b[1].getText().equals('X') && Gameboard.b[2].getText().equals('X')
            && Gameboard.b[3].getText().equals('X') && Gameboard.b[4].getText().equals('X')){
            //x's win
            //Gameboard.isGameOver();
            System.out.println("win");
    }
    else if(Gameboard.b[0].getText().equals('O') && Gameboard.b[1].getText().equals('O') && Gameboard.b[2].getText().equals('O')
            && Gameboard.b[3].getText().equals('O') && Gameboard.b[4].getText().equals('O')){
            //o's win
    }
    
    //5-9 equal x or o
    else if(Gameboard.b[5].getText().equals('X') && Gameboard.b[6].getText().equals('X') && Gameboard.b[7].getText().equals('X')
            && Gameboard.b[8].getText().equals('X') && Gameboard.b[9].getText().equals('X')){
            //x's win
    }
    else if(Gameboard.b[5].getText().equals('O') && Gameboard.b[6].getText().equals('O') && Gameboard.b[7].getText().equals('O')
            && Gameboard.b[8].getText().equals('O') && Gameboard.b[9].getText().equals('O')){
            //o's win
    }
    
    //10-14 equal x or o
    else if(Gameboard.b[10].getText().equals('X') && Gameboard.b[11].getText().equals('X') && Gameboard.b[12].getText().equals('X')
            && Gameboard.b[13].getText().equals('X') && Gameboard.b[14].getText().equals('X')){
            //x's win
    }
    else if(Gameboard.b[10].getText().equals('O') && Gameboard.b[11].getText().equals('O') && Gameboard.b[12].getText().equals('O')
            && Gameboard.b[13].getText().equals('O') && Gameboard.b[14].getText().equals('O')){
            //o's win
    }
    
    //15-19 equal x or o
    else if(Gameboard.b[15].getText().equals('X') && Gameboard.b[16].getText().equals('X') && Gameboard.b[17].getText().equals('X')
            && Gameboard.b[18].getText().equals('X') && Gameboard.b[19].getText().equals('X')){
            //x's win
    }
    else if(Gameboard.b[15].getText().equals('O') && Gameboard.b[16].getText().equals('O') && Gameboard.b[17].getText().equals('O')
            && Gameboard.b[18].getText().equals('O') && Gameboard.b[19].getText().equals('O')){
            //o's win
    }
    
    //20-24 equal x or o
    else if(Gameboard.b[20].getText().equals('X') && Gameboard.b[21].getText().equals('X') && Gameboard.b[22].getText().equals('X')
            && Gameboard.b[23].getText().equals('X') && Gameboard.b[24].getText().equals('X')){
            //x's win
    }
    else if(Gameboard.b[20].getText().equals('O') && Gameboard.b[21].getText().equals('O') && Gameboard.b[22].getText().equals('O')
            && Gameboard.b[23].getText().equals('O') && Gameboard.b[24].getText().equals('O')){
            //o's win
    }
    
    //4,8,12,16,20 equal x or o
    else if(Gameboard.b[4].getText().equals('X') && Gameboard.b[8].getText().equals('X') && Gameboard.b[12].getText().equals('X')
            && Gameboard.b[16].getText().equals('X') && Gameboard.b[20].getText().equals('X')){
            //x's win
    }
    else if(Gameboard.b[4].getText().equals('O') && Gameboard.b[8].getText().equals('O') && Gameboard.b[12].getText().equals('O')
            && Gameboard.b[16].getText().equals('O') && Gameboard.b[20].getText().equals('O')){
            //x's win
    }
    
    //0,6,12,18,24 equal x or o
    else if(Gameboard.b[0].getText().equals('X') && Gameboard.b[6].getText().equals('X') && Gameboard.b[12].getText().equals('X')
            && Gameboard.b[18].getText().equals('X') && Gameboard.b[24].getText().equals('X')){
            //x's win
    }
    else if(Gameboard.b[0].getText().equals('O') && Gameboard.b[6].getText().equals('O') && Gameboard.b[12].getText().equals('O')
            && Gameboard.b[18].getText().equals('O') && Gameboard.b[24].getText().equals('O')){
            //x's win
    }
    else{
        //draw
        System.out.println("draw");
    }
    
    }
    
}
