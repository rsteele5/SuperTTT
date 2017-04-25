/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testai;


 /** sggServer3
  *
  * a TCP server - original appearing in Silberschatz, Galvin and Gagne - p 119
  *
  */
 import java.io.*;
 import java.net.*;
 import java.io.OutputStreamWriter;
 import java.io.DataInputStream;
 import java.io.DataOutputStream;
 import java.util.Scanner;

 
 public class ServerTest
   {
     static int recieved;
     ServerTest(int x){
         recieved = x;
     }
     public static void run()
	 
     throws IOException
       {
         Socket client = null;     // holds the socket for the client
         ServerSocket sock = null; // holds the server socket
         AI myAI = new AI();

        // ClientTest in = new ClientTest();
 
		
         try
           {
             sock = new ServerSocket(5195);    // Port for the server socket
 
             /** loop to listen for connections */
          //   while (true)
           //    {
                 /** Wait for a client to contact this machine */
                 client = sock.accept( );
                 /** at this point, we have a connection */ 
				 
 //while gamemanager object not ready for move, set bool to false
 
//                 OutputStreamWriter osw =
//                   new OutputStreamWriter(client.getOutputStream( ));
//                 BufferedWriter bw =
//                   new BufferedWriter(osw);
             DataInputStream  dis   = new DataInputStream(client.getInputStream());     // for reading bytes

		 DataOutputStream out = new DataOutputStream(client.getOutputStream());
 
		 Scanner sc = new Scanner(System.in);

                 /** Write the date to the socket */
				 
			 int i, j,x;
			 j = 0;
//	myAI.makeMove("12");
//        out.writeInt(12);
               //  input = sc.next();
                 String move = "";

                   //   x = in.receive();
                     
                  move = Integer.toString(recieved);
                //  move = Integer.toString(x);

//                 String aiMove = myAI.makeMove(move);
//
//		 System.out.println("Received number in server class1 from client2: " + recieved);
//                    System.out.print("I move to: ");
//                    System.out.println(aiMove);
               //     input = sc.next();
//                    i = Integer.parseInt(in.toString());

              //  i = Integer.parseInt(aiMove);
                    out.writeInt(recieved);

               recieved = dis.readInt();
               

                // bw.close();
 		 out.close();

//                 client.close();
               }
           //}
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


 
