import java.io.*;
 import java.net.*;

 public class Server
   {
     static int received;
     static int send;
     static ServerSocket sock; // holds the server socket
     static Socket client;  // holds the socket for the client
     Server() throws IOException{
         try{
             sock = new ServerSocket(9001);
             client = sock.accept();
         }
         catch(IOException ioe){
              System.err.println(ioe);
         }
     }

     public static int receive()
     throws IOException
       {
//         Socket client = null;     // holds the socket for the client
//         ServerSocket sock = null; // holds the server socket
         try
           {
            DataInputStream  in   = new DataInputStream(client.getInputStream());     // for reading integer            
            received = in.readInt();//waits here until an integer is read in
            client.setSoTimeout(10000); //connection times out after 10 seconds
            return received;
           }
         catch (IOException ioe)
           {
             System.err.println(ioe);
             System.err.println("Opponent timed out. ");
             return 999;
           }
       }
     
     public static void send(int x)
     throws IOException
       {
//         Socket client = null;     // holds the socket for the client
//         ServerSocket sock = null; // holds the server socket
         send = x;
         try
           {
//            sock = new ServerSocket(5195);    // Port for the server socket
//            client = sock.accept( );  //new computer we are talking to
            DataOutputStream out = new DataOutputStream(client.getOutputStream());  //for writings ints
//            DataInputStream  in   = new DataInputStream(client.getInputStream());     // for reading bytes
            out.writeInt(send); //sends AI's move to enemy
//            out.close(); //close the data outstream
            
//            received = in.readInt();//waits here until an integer is read in
           }
         catch (IOException ioe)
           {
             System.err.println(ioe);
           }
//         finally
//           {
//             if (client != null) client.close();
//             if (sock != null) sock.close();
//           }
       }
 
   }


 
