 import java.io.*;
 import java.net.Socket;

 public class Client
   {
     static int number;
     static Socket sock;   // holds the server socket
     String myIP = GetAddr.IP;
//     static int send;
     Client()throws IOException{
         try{
             sock = new Socket(myIP, 5195); //sets up socket with ip from input on port number
         }
         catch(IOException ioe){
             System.err.println(ioe);
         }
     }
     public static int receive()
     throws IOException
       {
         try
           {
             DataInputStream  dis   = new DataInputStream(sock.getInputStream());     // for reading ints
             number = dis.readInt(); //gets integer from talker  			
             sock.setSoTimeout(10000); //connection times out after 10 seconds
             return number;
           }
         catch (IOException ioe)
           {
             System.err.println(ioe);
             System.err.println("Opponent timed out. ");
             return 999;
           }    
       }
     public static void send(int aiMove)throws IOException
       {
         try
           {
             DataOutputStream out = new DataOutputStream(sock.getOutputStream());  //for writing ints
             out.writeInt(aiMove); //sends AI's move to enemy

            //sock.setSoTimeout(5000);
           }
         catch (IOException ioe)
           {
             System.err.println(ioe);
           }         
       }

   }
 

