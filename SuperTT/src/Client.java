 import java.io.*;
 import java.net.Socket;

 public class Client
   {
     static int number;
     static Socket sock;
//     static int send;
     Client(String host)throws IOException{
         try{
             sock = new Socket(host, 5195);
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
             return number = dis.readInt(); //gets integer from talker  			
            //sock.setSoTimeout(5000);
           
           }
         catch (IOException ioe)
           {
             System.err.println(ioe);
             return 25;
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
 

