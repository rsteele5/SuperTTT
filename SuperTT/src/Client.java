 import java.io.*;
 import java.net.Socket;

 public class Client
   {
     static int number;
     static Socket sock;
     String myIP = GetAddr.IP;
//     static int send;
     Client()throws IOException{
         try{
             sock = new Socket(myIP, 5195);
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
             sock.setSoTimeout(5000);
             return number;
           }
         catch (IOException ioe)
           {
             System.err.println(ioe);
             return 999;
           }    
       }
     public static void send(int aiMove)throws IOException
       {
         try
           {
             DataOutputStream out = new DataOutputStream(sock.getOutputStream());
             out.writeInt(aiMove); //sends AI's move to enemy

            //sock.setSoTimeout(5000);
           }
         catch (IOException ioe)
           {
             System.err.println(ioe);
           }         
       }

   }
 

