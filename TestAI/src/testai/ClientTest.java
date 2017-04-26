/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testai;


/** sggClient3.java
 //
 // a TCP client
 // from Silberschatz, Galvin and Gagne - p 120
 //
 //
  */
 import java.io.*;
 import java.net.*;
 import java.io.DataOutputStream;
 import java.io.DataInputStream;
 import java.net.Socket;
 import java.util.Scanner;
 import static testai.ServerTest.recieved;
 public class ClientTest
   {
     static int number = 0;
     public static int receive()
     throws IOException
       {
         String host;
 
         /*
          *  if (args.length == 0) host = "127.0.0.1"; else host = args[0].trim();
          */
        host = "10.28.38.185";
       //host = "127.0.0.1";
         Socket sock = null;
         ServerSocket client = null;
         String line;
		int number = 0;
		 Scanner sc = new Scanner(System.in);
 
         try
           {
             // make connection to a socket
             sock = new Socket("127.0.0.1", 5195);  // socket for contact with server
             InputStream       is   = sock.getInputStream();     // for reading bytes
             InputStreamReader isr  = new InputStreamReader(is); // for reading chars
             BufferedReader    br   = new BufferedReader(isr);   // for reading Lines 
 
             AI myAI = new AI();

             DataInputStream  dis   = new DataInputStream(sock.getInputStream());     // for reading bytes
             		 
             DataOutputStream out = new DataOutputStream(sock.getOutputStream());


			
			//sock.setSoTimeout(5000);


            number = dis.readInt();
            System.out.println("Read number in client1 from testai2 server: " + number);

            
            
            int i, j;
			 
            j = 0;
            
              String move= "";

                move = Integer.toString(recieved);
                // move = Integer.toString(number);

                 String aiMove = myAI.makeMove(move);

		 System.out.println("Received number in client 1: " + recieved);
                // System.out.println("Received number in client 1: " + number);

                    System.out.print("I move to from client1: ");
                    System.out.println(aiMove);

                i = Integer.parseInt(aiMove);
                    out.writeInt(i);

          }
         catch (IOException ioe)
           {
             System.err.println(ioe);
           }
         finally
           {
             if (sock != null) sock.close();
           }
           return number;
           
               
           }
private void send(){

    
}

       }


    
   
 

