/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testai;

import java.util.Scanner;

/**
 *
 * @author cnelt
 */
public class TestAI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AI myAI = new AI();
        String input;
        Scanner keyboard = new Scanner(System.in);
        
        input = keyboard.next();
        while(input != "q"){
            System.out.print("I move to: ");
            System.out.println(myAI.makeMove(input));
            input = keyboard.next();
        }
    }
    
}
