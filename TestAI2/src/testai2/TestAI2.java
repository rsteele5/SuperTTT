/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testai2;

import java.io.IOException;

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
            int received = 0, sent;
            String aiMove;

            if(received == -1){
                 ServerTest server = new ServerTest(); //create server with move we will make
                 for(int plays = 0; plays < 12; plays++){
                    System.out.println("Move recieved: " + received);
                    sent = myAI.makeMove(received);//call AI and make move
                    System.out.println("Move played: " + sent);

                    server.send(sent); //send that move and wait for response
                    server.receive();
                    received = server.received; //retrives the number sent from enemy
                }
            }else{
                ClientTest client = new ClientTest("127.0.0.1");
                for(int plays = 0; plays < 12; plays++){
                    int recieved;
                    client.receive();
                    recieved = client.number;

                    System.out.println("move recieved: " + recieved);
                    sent = myAI.makeMove(recieved);
                    System.out.println("Move played: " + sent);

                    client.send(sent); //send AI move
                }
            }
            //if playing first

            //if playing second


    }
    
}
