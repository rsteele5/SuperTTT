/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testai2;


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
 import java.net.Socket;
 import java.util.Scanner;

 public class ClientTest2
   {
     public static int receive()
     throws IOException
       {
         String host;
 
         /*
          *  if (args.length == 0) host = "127.0.0.1"; else host = args[0].trim();
          */
        host = "127.0.1.1";
         Socket sock = null;
         String line;
		 int number=0;
		 Scanner sc = new Scanner(System.in);
 
         try
           {
             // make connection to a socket
             sock = new Socket(host, 5195);  // socket for contact with server
             InputStream       is   = sock.getInputStream();     // for reading bytes
             InputStreamReader isr  = new InputStreamReader(is); // for reading chars
             BufferedReader    br   = new BufferedReader(isr);   // for reading Lines 
 
             DataInputStream  dis   = new DataInputStream(sock.getInputStream());     // for reading bytes
			
			//sock.setSoTimeout(5000);


		  while ((number = dis.readInt()) < 25)  // repeat readLine to eof
             {
                System.out.println(number);           // print out one line 


              }
      /*       while ((line = br.readLine()) != null)  // repeat readLine to eof
               {
                System.out.println(line);           // print out one line 
              }
*/
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
   /*  public int getMove(){
         int number;
         DataInputStream  dis   = new DataInputStream(sock.getInputStream());     // for reading bytes

           while ((number = dis.readInt()) < 25)  // repeat readLine to eof
             {
                System.out.println(number);           // print out one line 


              }
         return number;
     }*/
 
   }
 

