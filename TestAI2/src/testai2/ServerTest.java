package testai2;

 import java.io.*;
 import java.net.*;

 public class ServerTest
   {
     static int received;
     static int send;
     static ServerSocket sock;
     static Socket client;
     ServerTest() throws IOException{
         try{
             sock = new ServerSocket(5195);
             client = sock.accept();
         }
         catch(IOException ioe){
              System.err.println(ioe);
         }
     }

     public static void receive()
     throws IOException
       {
//         Socket client = null;     // holds the socket for the client
//         ServerSocket sock = null; // holds the server socket
         try
           {
//            sock = new ServerSocket(5195);    // Port for the server socket
//            client = sock.accept( );  //new computer we are talking to
//            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            DataInputStream  in   = new DataInputStream(client.getInputStream());     // for reading bytes
//            out.writeInt(send); //sends AI's move to enemy
//            out.close(); //close the data outstream
            
            received = in.readInt();//waits here until an integer is read in
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
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
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


 
