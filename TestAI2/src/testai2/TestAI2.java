/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testai2;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author cnelt
 */
public class TestAI2 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) 
            throws IOException {
        AI myAI = new AI();
        ServerTest2 server = new ServerTest2();
        ClientTest2 client = new ClientTest2();

        ServerTest2.run();
        ClientTest2.receive();

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
