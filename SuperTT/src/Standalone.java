
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

//standalone version enables a person to play against the game AI
public class Standalone extends GameManager
{
    public Standalone(){
      //Decide who goes first
      this.whoGoesFirst(); 
      
      //create an instance of an AI
      //AI myAI = new AI();
    
      /* while game is active, make move against game AI
      while (activeGame == true){
          this.playerMove();
      }
      */
    }
    
    @Override
    protected boolean validateMove(int position){
    //if move hasn't been made previously, the move is ok
    
    //Grab button text from Gameboard. If it's set to either x or o, the move is not valid. If it's not set
    //the move is valid
    
    /*
    if(Gameboard.b[Gameboard.clickedButton].getText().equals('x') || Gameboard.b[Gameboard.clickedButton].getText().equals('o')){
        return false; 
    }
    else{
        return true; 
    }
    */
    
    if((CurrentMove >= 0) && (CurrentMove <= 24)){
        /*if(Spot is not currently taken){
                it is okay to 
        }
        else{Can't move there}
        */
            return true;
        }
        else{
        /*Move does not exist*/
        return false;
        }
    
    
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
    
    @Override
    public int whoGoesFirst(){
        //create random number from 0-100
        int human, AI = 0;
        Random r = new Random();
        
        //assign random numbers to two int variables
        human = r.nextInt(101);        
        AI = r.nextInt(101); 
        
        //compare the variables and see which one will go first...0 for human and 1 for AI
        if(human > AI){
            return 0; 
        }
        else{
            return 1; 
        }   
    }
    
    @Override
    public void playerMove(){
    //player and AI take turns making moves    
    }
}
