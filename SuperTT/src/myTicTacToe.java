import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class myTicTacToe extends JFrame{
	
    private final JButton newGame = new JButton("New Game");
    private final JTextField display;
 
    /*
    private final JButton button1 = new JButton(" ");
    private final JButton button2 = new JButton(" ");
    private final JButton button3 = new JButton(" ");
    private final JButton button4 = new JButton(" ");
    private final JButton button5 = new JButton(" ");
    private final JButton button6 = new JButton(" ");
    private final JButton button7 = new JButton(" ");
    private final JButton button8 = new JButton(" ");
    private final JButton button9 = new JButton(" ");
    private final JButton button10 = new JButton(" ");
    private final JButton button11 = new JButton(" ");
    private final JButton button12 = new JButton(" ");
    private final JButton button13 = new JButton(" ");
    private final JButton button14 = new JButton(" ");
    private final JButton button15 = new JButton(" ");
    private final JButton button16 = new JButton(" ");
    private final JButton button17 = new JButton(" ");
    private final JButton button18 = new JButton(" ");
    private final JButton button19 = new JButton(" ");
    private final JButton button20 = new JButton(" ");
    private final JButton button21 = new JButton(" ");
    private final JButton button22 = new JButton(" ");
    private final JButton button23 = new JButton(" ");
    private final JButton button24 = new JButton(" ");
    private final JButton button25 = new JButton(" ");
    */
    
    public myTicTacToe(){
    
        Font displayFont = new Font("Courier New", 1, 18);   
	display = new JTextField("Play TTT");
	display.setEditable(false);
	display.setFont(displayFont);
 
        
        JPanel panel = new JPanel();
	panel.setLayout(new GridLayout(5, 5));
        panel.add(newGame);
        for(int i = 0; i < 25; i++) {
            panel.add(new JButton());
        }

        /*
	panel.add(button1);
	panel.add(button2);
	panel.add(button3);
	panel.add(button4);
	panel.add(button5);
	panel.add(button6);
	panel.add(button7);
	panel.add(button8);
	panel.add(button9);
	panel.add(button10);
        panel.add(button11);
        panel.add(button12);
        panel.add(button13);
        panel.add(button14);
        panel.add(button15);
        panel.add(button16);
        panel.add(button17);
        panel.add(button18);
        panel.add(button19);
        panel.add(button20);
        panel.add(button21);
        panel.add(button22);
        panel.add(button23);
        panel.add(button24);
        panel.add(button25);
        */
        
	Container contentPane = getContentPane();
	contentPane.add(display, "North");
	contentPane.add(panel, "Center");
        contentPane.add(newGame, "South");

        /*
        add button listener and make it say x or o and stuff :)
        */
    }
}