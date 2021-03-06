import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StandaloneGB extends JFrame {

    final JButton[] b = new JButton[25];
    final char[] cArray = new char[25];
    private final JTextField display;
    private static final JButton quit = new JButton("Quit");
    private char currentPlayer = 'X';
    private int unplayedCount = 25;
    private Random myRando = new Random();
    int r = myRando.nextInt(100) + 1;
    //Create GameManager Object
    Standalone saManager = new Standalone(); 
    private int aiMove;
    boolean aiFirst;
    
    public StandaloneGB() throws STTT_Exception	{
        //create new randomNumber for human
        
        //compare randomNumber with GM
        if(r>GameManager.r){//player goes first
            display = new JTextField("You go first as X!");
            aiFirst = false;
        }
        else{//AI goes first
            aiMove = saManager.playerMove(-99);
            display = new JTextField("AI went first as X" + " " + aiMove);
            aiFirst = true;
            //show where AI moved and disable button            
        }
        
        //Create content pane and display
        //Display is unable to be edited
        Container cp = getContentPane();
//        display = new JTextField("Play Tic-Tac-Toe: O's turn! " + r);
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
                
                
        JPanel quitPanel = new JPanel();
//        quitPanel.add(quit);
        cp.add(quitPanel,"South");

		
        //Initialize arr of 25 JButtons
        //create buttons 0-24
            for(int i=0;i<25;i++){
                b[i] = new JButton();
                b[i].setActionCommand(Integer.toString(i));
        }

        //Add JButtons to panel
        for(int i=0;i<b.length; i++){
            panel.add(b[i]);
        }

        //Set JButton font and size
        Font buttonFont = new Font("Courier New", 1, 56);
        for(int i=0;i<25;i++){
            b[i].setFont(buttonFont);
        }
                
        //Add listeners to JButtons
        StandaloneGB.ButtonListener listener = new StandaloneGB.ButtonListener();
        quit.addActionListener(listener);
        for(int i=0;i<25;i++){
            b[i].addActionListener(listener);
        }
        
        if(r<GameManager.r){//AI went first so disable button
            b[aiMove].setEnabled(false);
            b[aiMove].setText("" + currentPlayer);
            setNextPlayer();
        }

    }
        
    private class ButtonListener implements ActionListener {

        private ButtonListener() {}
        
        //If source is a JButton then set text to current player
        //Also disable JButton
        @Override
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() instanceof JButton){

                    ((JButton)ae.getSource()).setText("" + currentPlayer);
                    ((JButton)ae.getSource()).setEnabled(false);
                    StandaloneGB.this.setNextPlayer();
                    aiMove = Integer.parseInt(ae.getActionCommand());
          
                try {
                    aiMove = saManager.playerMove(aiMove);
                } catch (STTT_Exception ex) {
                    switch(ex.result){
                        case -1: System.out.println("Invalid Move"); return;
                        case 0:  display.setText("Tie Game"); disableAllButtons();  if(aiFirst){b[ex.finalMove].setText("" + currentPlayer);} return;
                        case 1: display.setText("The AI Wins!"); disableAllButtons(); if(aiFirst){b[ex.finalMove].setText("" + currentPlayer);}return;
                        case 2:  display.setText("Player 2 Wins!"); disableAllButtons(); if(aiFirst){b[ex.finalMove].setText("" + currentPlayer);} return;
                        default: disableAllButtons(); return;
                    }
                }

//                System.out.println(aiMove);
                b[aiMove].setEnabled(false);
                b[aiMove].setText("" + currentPlayer);              
            }

                StandaloneGB.this.setNextPlayer();
//            }
        }
    }
    
    //Disable all buttons
    private void disableAllButtons(){
        for(int i=0;i<b.length;i++){
            b[i].setEnabled(false);
        }
    }
    
    //Set next player (do AI stuff here?)
    private void setNextPlayer()  {
	currentPlayer = (currentPlayer == 'X' ? 'O' : 'X');
	display.setText("You are " + currentPlayer);        
    }

//    //Is game over?
//    private boolean isGameOver()  {
//        char winner = ' ';
//        unplayedCount -= 1;
//        
//        /*
//        if (winner != ' ') {
//            display.setText("Game Over Fam " + winner + "Wins");
//        }
//        */
//        if(unplayedCount ==0)  {
//            display.setText("Game Over Fam");
//            return true;
//        }
//        return false;
//    }
}