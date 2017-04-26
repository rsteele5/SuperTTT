package testai2;

 import java.io.*;
 import java.net.Socket;

 public class ClientTest
   {
     static int number;
     static Socket sock;
//     static int send;
     ClientTest(String host)throws IOException{
         try{
             sock = new Socket(host, 5195);
         }
         catch(IOException ioe){
             System.err.println(ioe);
         }
     }
     public static void receive()
     throws IOException
       {
//         String host;          
//         host = "10.32.38.32";
//         Socket sock = null;
         try
           {
             // make connection to a socket
//             sock = new Socket(host, 5195);  // socket for contact with server

             DataInputStream  dis   = new DataInputStream(sock.getInputStream());     // for reading ints
             number = dis.readInt(); //gets integer from talker  
			
            //sock.setSoTimeout(5000);
           
           }
         catch (IOException ioe)
           {
             System.err.println(ioe);
           }
    
       }
     public static void send(int aiMove)throws IOException
       {
//         String host;          
//         host = "10.32.38.32";
//         Socket sock = null;
         try
           {
             // make connection to a socket
//             sock = new Socket(host, 5195);  // socket for contact with server

             DataOutputStream out = new DataOutputStream(sock.getOutputStream());
             
             out.writeInt(aiMove); //sends AI's move to enemy
//             out.close();
			
            //sock.setSoTimeout(5000);
           
           }
         catch (IOException ioe)
           {
             System.err.println(ioe);
           }         
       }

   }
 

