import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public StandaloneGB() throws STTT_Exception	{
        //create new randomNumber for human
        
        //compare randomNumber with GM
        if(r>GameManager.random){//player goes first
            display = new JTextField("You go first as X!");
        }
        else{//AI goes first
            aiMove = saManager.playerMove(-99);
            display = new JTextField("AI went first as X" + " " + aiMove);
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
        quitPanel.add(quit);
        cp.add(quitPanel,"South");

		
        //Initialize arr of 25 JButtons
        //create buttons 0-24
        JButton[] b = new JButton[25];
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
        
        if(r<GameManager.random){//AI went first so disable button
            b[aiMove].setEnabled(false);
            b[aiMove].setText("" + currentPlayer);
            currentPlayer = 'O';
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
                    System.out.println(ex.getMessage());
                    switch(ex.result){
                        case -1: break;
                        case 0: break;
                        case 1: break;
                        case 2: break;
                    }
                            
                }
                
                    b[aiMove].setEnabled(false);
                    b[aiMove].setText("" + currentPlayer);
                    StandaloneGB.this.setNextPlayer();
                
            }

            
            //if source is quit button, dispose of current JFrame
            if(ae.getSource() == quit){
                dispose();
                quit.setEnabled(true);
            }
            
            //If game is done, disable all JButtons
            if (StandaloneGB.this.isGameOver()) {
                StandaloneGB.this.disableAllButtons();
            } 
            //If game is not done, call setNextPlayer
            else {
                StandaloneGB.this.setNextPlayer();
            }
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
	display.setText("" + currentPlayer + "'s Turn!");
        
    }

    //Is game over?
    private boolean isGameOver()  {
        char winner = ' ';
        unplayedCount -= 1;
        
        /*
        if (winner != ' ') {
            display.setText("Game Over Fam " + winner + "Wins");
        }
        */
        if(unplayedCount ==0)  {
            display.setText("Game Over Fam");
            return true;
        }
        return false;
    }
}