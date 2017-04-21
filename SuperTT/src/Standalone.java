/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Remington Steele
 */
public class Standalone extends GameManager
{
    //standalone version enables a person to play against the game AI
    
    //Decide who goes first
    //this.whoGoesFirst(); 
    
    /*create an instance of an AI
    AI myAI = new AI();
    
    // while game is active, make move against game AI
    this.playerMove(); 
    
    */
    protected boolean validateMove()
    {
        return true;
    }
    
    protected void gameOver(){
    
    }
    
    public int whoGoesFirst(){
        /*create random number from 0-100
        
        //assign random numbers to two int variables
        
        //compare the variables and see which one will go first...0 for human and 1 for AI
        
        */
        
        return 1; 
    }
}
