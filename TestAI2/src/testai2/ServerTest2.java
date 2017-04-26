/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testai2;


 /** sggServer3
  *
  * a TCP server - original appearing in Silberschatz, Galvin and Gagne - p 119
  *
  */
 import java.io.*;
 import java.net.*;
 import java.io.OutputStreamWriter;
 import java.io.DataInputStream;
 import java.util.Scanner;

 
 public class ServerTest2
   {
     public static void run()
	 
     throws IOException
       {
         Socket client = null;     // holds the socket for the client
         ServerSocket sock = null; // holds the server socket
         AI myAI = new AI();

         ClientTest2 in = new ClientTest2();
 
		
         try
           {
             sock = new ServerSocket(5195);    // Port for the server socket
 
             /** loop to listen for connections */
             while (true)
               {
                 /** Wait for a client to contact this machine */
                 client = sock.accept( );
                 /** at this point, we have a connection */ 
				 
 //while gamemanager object not ready for move, set bool to false
 
                 OutputStreamWriter osw =
                   new OutputStreamWriter(client.getOutputStream( ));
                 BufferedWriter bw =
                   new BufferedWriter(osw);
		 DataOutputStream out = new DataOutputStream(client.getOutputStream());
 
		 Scanner sc = new Scanner(System.in);

                 /** Write the date to the socket */
				 
			 int i, j,x;
			 j = 0;
	myAI.makeMove("12");
               //  input = sc.next();
                  x = in.receive();
                 String move = Integer.toString(x);
		 System.out.println("Received number: " + x);

                 while(j < 25)
                 {
                    System.out.print("I move to: ");
                    System.out.println(myAI.makeMove(move));
               //     input = sc.next();
//                    i = Integer.parseInt(in.toString());
                    out.writeInt(x);
                    j++;
                 }

                // bw.close();
 		 out.close();

                 client.close();
               }
           }
         catch (IOException ioe)
           {
             System.err.println(ioe);
           }
         finally
           {
             if (client != null) client.close();
             if (sock != null) sock.close();
           }
       }
 
   }


 
