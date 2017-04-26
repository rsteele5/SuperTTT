import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

//GB LOGIC DONE
public class NetworkGB extends JFrame {
 
    final JButton[] b = new JButton[25];
    public static JTextField display;
    private static final JButton quit = new JButton("Quit");
    private char currentPlayer = 'X';
    private int unplayedCount = 25;
  
    //Create GameManager Object
    NetworkMode saManager = new NetworkMode(); 
    GameManager gm = new NetworkMode();
    
    //AI myAI = new AI();
    
    
                



    public NetworkGB() throws IOException, STTT_Exception
    {    
	//Create content pane and display
        //Display is unable to be edited
        Container cp = getContentPane();
        //GetAddr.IP is a GLOBAL - Accesses IP from GetAddr class
	display = new JTextField("This game is connected to " + GetAddr.IP);
	display.setEditable(false);

        //Set display to north frame
	Font DisplayFont = new Font("Courier New", 1, 18);
	display.setFont(DisplayFont);
	cp.add(display, "North");

        //New JPanel and grid
        //Set JPanel to center
	JPanel panel = new JPanel();
	panel.setLayout(new GridLayout(5, 5));
	cp.add(panel, "Center");
                
        //New JPanel
        //Set panel to south
        JPanel quitPanel = new JPanel();
        quitPanel.add(quit);
        cp.add(quitPanel,"South");
		
        //Initialize arr of 25 JButtons
        //create buttons 0-24
	JButton[] b = new JButton[25];
	for(int i=0;i<25;i++){
		b[i] = new JButton("");
	}
        
        //Set JButton font and size
        Font buttonFont = new Font("Courier New", 1, 56);
            for(int i=0;i<25;i++){
            b[i].setFont(buttonFont);
        }

        //Add JButtons to panel
	for(int i=0;i<b.length; i++){
                panel.add(b[i]);
	}
        
        //Disable Human Input fo AI v AI
        for(int i=0;i<b.length;i++){
            b[i].setEnabled(false);
        }
             
        //Add listeners to JButtons
        NetworkGB.ButtonListener listener = new NetworkGB.ButtonListener();
        quit.addActionListener(listener);
        
        boolean isClient = HoN.isClient;
        boolean isServer = GetAddr.isServer;
        System.out.println("is Host set to: " + isClient);
        System.out.println("is Client is set to: " + isServer);

         int ourRand = GameManager.r;
         int send, received;
         System.out.println("Our random number is: " + ourRand);

       
    
         //client side
        if(isClient == true){
            Client client = new Client();
            client.send(ourRand);
            int theirRand = client.receive();
            System.out.println("Their random number is: " + theirRand);

            
            while( ourRand == theirRand){
               Random r = new Random();
               ourRand = r.nextInt(100) + 1;
               System.out.println("Our random number is: " + ourRand);
               client.send(ourRand);
               
               theirRand = client.receive();
               System.out.println("Their random number is: " + theirRand);

            }
            if(ourRand > theirRand){
                try{
                    send = gm.playerMove(-99);
                    client.send(send);
                    System.out.println("Move played: " + send);

                                    
                    while(true){
                        client.receive();
                        received = client.number;                                               
                        System.out.println("Move recieved: " + received);

                        send = gm.playerMove(received);
                        client.send(send);
                        System.out.println("Move played: " + send);

                    }
                }
                catch(STTT_Exception ex){
                     switch(ex.result){
                        case -1: //Something has gone wrong
                            System.out.println(ex.getMessage());
                            break;
                        case 0:
                            System.out.println(ex.getMessage());
                            break;
                        case 1:
                            System.out.println(ex.getMessage());
                            break;
                        case 2:
                            System.out.println(ex.getMessage());
                            break;
                     
                     }
                }       
            }
           
            
            else if(ourRand < theirRand){
                try{
                while(true){            
                client.receive();
                received = client.number;
                System.out.println("move recieved: " + received);

                send = gm.playerMove(received);
                client.send(send);
                System.out.println("Move played: " + send);

                }       
                }
                catch(STTT_Exception ex){
                     switch(ex.result){
                        case -1: //Something has gone wrong
                            System.out.println(ex.getMessage());
                            break;
                        case 0:
                            System.out.println(ex.getMessage());
                            break;
                        case 1:
                            System.out.println(ex.getMessage());
                            break;
                        case 2:
                            System.out.println(ex.getMessage());
                            break;
                     
                     }
        }
        }
        }
        
        //serverside
        if(isServer == true){
            Server server = new Server();
            server.send(ourRand);
            int theirRand = server.receive();
            System.out.println("Their random number is: " + theirRand);

            
            while(ourRand == theirRand){
               Random r = new Random();
               ourRand = r.nextInt(100) + 1;
               server.send(ourRand);
               System.out.println("Our random number is: " + ourRand);

               theirRand = server.receive();
               System.out.println("Their random number is: " + theirRand);

            }
            if(ourRand > theirRand){
                try{
                    send = gm.playerMove(-99);
                    server.send(send);
                    System.out.println("Move played: " + send);

                                    
                    while(true){
                        server.receive();
                        received = server.received;
                        System.out.println("move recieved: " + received);

                        send = gm.playerMove(received);
                        server.send(send);
                        System.out.println("Move played: " + send);

                    }
                }
                catch(STTT_Exception ex){
                     switch(ex.result){
                        case -1: //Something has gone wrong
                            System.out.println(ex.getMessage());
                            break;
                        case 0:
                            System.out.println(ex.getMessage());
                            break;
                        case 1:
                            System.out.println(ex.getMessage());
                            break;
                        case 2:
                            System.out.println(ex.getMessage());
                            break;
                     
                     }
                }       
            }
           
            
            else if(ourRand < theirRand){
                try{
                while(true){                                   
                    server.receive();              
                    received = server.received;               
                    System.out.println("move recieved: " + received);
              
                    send = gm.playerMove(received);              
                    server.send(send);                                                 
                    System.out.println("Move played: " + send);

                }       
                }
                catch(STTT_Exception ex){
                     switch(ex.result){
                        case -1: //Something has gone wrong
                            System.out.println(ex.getMessage());
                            break;
                        case 0:
                            System.out.println(ex.getMessage());
                            break;
                        case 1:
                            System.out.println(ex.getMessage());
                            break;
                        case 2:
                            System.out.println(ex.getMessage());
                            break;
                     
                     }
        }
        }
        }
        
    }

        //if bool = true, then Client client = new Client()
        //int theirRand = client.receive
        //display = new JTextField("Our Random number is: " + ourRand);
        //display = new JTextField("Their Random number is: " + theirRand);
//        Font DisplayFont = new Font("Courier New", 1, 18);
//	display.setFont(DisplayFont);
//	cp.add(display, "North");

        // if ourRand > theirRand, then  send = aiMove(-99); client.send(send)
        // else client.receive(); receive = client.number; send = aiMove(receive); client.send(send);
        
        //if bool = false, then Server server = new server()
        //int theirRand = client.receive
         //display = new JTextField("Our Random number is: " + ourRand);
        //display = new JTextField("Their Random number is: " + theirRand);
//        Font DisplayFont = new Font("Courier New", 1, 18);
//	display.setFont(DisplayFont);
//	cp.add(display, "North");
        // if ourRand > theirRand, then  send = aiMove(-99); client.send(send)
        // else client.receive(); receive = client.receive; send = aiMove(receive); client.send(send);
        
               
   /*     if (GetAddr.IP == null){
            ifHost();
        }*/
    
    private class ButtonListener implements ActionListener {
        private ButtonListener() {}
        
        //If source is a JButton then set text to current player
        //Also disable JButton
        public void actionPerformed(ActionEvent ae){
            
            //if source is quit button, dispose of current JFrame
            if(ae.getSource() == quit){
                dispose();
                quit.setEnabled(true);
            }
            
            /*
            if(ae.getSource() instanceof JButton){
                ((JButton)ae.getSource()).setText("" + currentPlayer);
                ((JButton)ae.getSource()).setEnabled(false);
            }  
           
            //If game is done, disable all JButtons
            if (NetworkGB.this.isGameOver()) {
                NetworkGB.this.disableAllButtons();
            }
            
            //If game is not done, call setNextPlayer
            else {
                NetworkGB.this.setNextPlayer();
            }
            */
        }
    }
    
    public void ifHost() {
        display.setText("game is connectecd");
    }
    
    public void displayMove() {
        int i = 0;
        b[i].setText(currentPlayer + "");
    }
    
    //Set next player (do AI stuff here?)
    private void setNextPlayer()  {
        int i=0;
	currentPlayer = (currentPlayer == 'X' ? 'O' : 'X');
	display.setText("Button "+ b[i] + " Pressed! "+"" + currentPlayer + "'s Turn!");
    }
}