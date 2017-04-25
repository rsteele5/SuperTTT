import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NetworkGB extends JFrame {

final JButton[] b = new JButton[25];
final char[] cArray = new char[25];
private final JTextField display;
private static final JButton quit = new JButton("Quit");
private char currentPlayer = 'X';
private int unplayedCount = 25;

	public NetworkGB()
	{
		//Create content pane and display
                //Display is unable to be edited
                Container cp = getContentPane();
		display = new JTextField("Play Tic-Tac-Toe: O's turn!");
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
			b[i] = new JButton("");
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
                NetworkGB.ButtonListener listener = new NetworkGB.ButtonListener();
                quit.addActionListener(listener);
		for(int i=0;i<25;i++){
                    b[i].addActionListener(listener);
		}
        }
        
    private class ButtonListener implements ActionListener {

        private ButtonListener() {}
        
        //If source is a JButton then set text to current player
        //Also disable JButton
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() instanceof JButton){
                ((JButton)ae.getSource()).setText("" + currentPlayer);
                ((JButton)ae.getSource()).setEnabled(false);
            }
            
            //if source is quit button, dispose of current JFrame
            if(ae.getSource() == quit){
                dispose();
                quit.setEnabled(true);
            }
            
            /*
            if (GameManger.AiTurn or whatever its called){
                NetworkGB.this.disableAllButtons();     
            } else {
                NetworkGB.this.setNextPlayer();
            }
            */
            
            //If game is done, disable all JButtons
            if (NetworkGB.this.isGameOver()) {
                NetworkGB.this.disableAllButtons();
            } 
            //If game is not done, call setNextPlayer
            else {
                NetworkGB.this.setNextPlayer();
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
        int i=0;
	currentPlayer = (currentPlayer == 'X' ? 'O' : 'X');
	display.setText("Button "+ b[i] + " Pressed! "+"" + currentPlayer + "'s Turn!");
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