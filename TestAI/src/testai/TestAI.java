/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testai;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author cnelt
 */
public class TestAI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
            throws IOException {
        AI myAI = new AI();
        int received=12;
        String move = "";
        String aiMove;
        
        ServerTest server = new ServerTest(received);

              
      //  ClientTest client = new ClientTest();
                for(int plays = 0; plays < 12; plays++){
                    ;
                     aiMove = myAI.makeMove(Integer.toString(received));
                     received = Integer.parseInt(aiMove);
                     server = new ServerTest(received);

        server.run();
        //received = client.number;

                }
       // client.receive();
       /* String input;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter player move: ");
        input = keyboard.next();
        while(input != "q"){
            System.out.print("I move to: ");
            System.out.println(myAI.makeMove(input));
            input = keyboard.next();
        }*/
    }
    
}
