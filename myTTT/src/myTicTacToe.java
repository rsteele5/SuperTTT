import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class myTicTacToe
extends JFrame {
    private final JButton b0;
    private final JButton b1;
    private final JButton b2;
    private final JButton b3;
    private final JButton b4;
    private final JButton b5;
    private final JButton b6;
    private final JButton b7;
    private final JButton b8;
    private final JTextField display;
    private char nextPlayer = 79;
    private int unplayedCount = 9;

    public myTicTacToe() {
        Container cp = this.getContentPane();
        this.display = new JTextField("Play Tic-Tac-Toe: O's turn!");
        this.display.setEditable(false);
        Font font = new Font("Courier New", 1, 18);
        this.display.setFont(font);
        cp.add((Component)this.display, "North");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3));
        cp.add((Component)panel, "Center");
        this.b0 = new JButton(" ");
        this.b1 = new JButton(" ");
        this.b2 = new JButton(" ");
        this.b3 = new JButton(" ");
        this.b4 = new JButton(" ");
        this.b5 = new JButton(" ");
        this.b6 = new JButton(" ");
        this.b7 = new JButton(" ");
        this.b8 = new JButton(" ");
        Font buttonFont = new Font("Courier New", 1, 56);
        this.b0.setFont(buttonFont);
        this.b1.setFont(buttonFont);
        this.b2.setFont(buttonFont);
        this.b3.setFont(buttonFont);
        this.b4.setFont(buttonFont);
        this.b5.setFont(buttonFont);
        this.b6.setFont(buttonFont);
        this.b7.setFont(buttonFont);
        this.b8.setFont(buttonFont);
        panel.add(this.b0);
        panel.add(this.b1);
        panel.add(this.b2);
        panel.add(this.b3);
        panel.add(this.b4);
        panel.add(this.b5);
        panel.add(this.b6);
        panel.add(this.b7);
        panel.add(this.b8);
        ButtonListener listener = new ButtonListener();
        this.b0.addActionListener(listener);
        this.b1.addActionListener(listener);
        this.b2.addActionListener(listener);
        this.b3.addActionListener(listener);
        this.b4.addActionListener(listener);
        this.b5.addActionListener(listener);
        this.b6.addActionListener(listener);
        this.b7.addActionListener(listener);
        this.b8.addActionListener(listener);
    }

    private void setNextPlayer() {
        this.nextPlayer = (char) (this.nextPlayer == 'O' ? 88 : 79);
        this.display.setText("" + this.nextPlayer + "'s Turn!");
    }

    private void disableAllButtons() {
        this.b0.setEnabled(false);
        this.b1.setEnabled(false);
        this.b2.setEnabled(false);
        this.b3.setEnabled(false);
        this.b4.setEnabled(false);
        this.b5.setEnabled(false);
        this.b6.setEnabled(false);
        this.b7.setEnabled(false);
        this.b8.setEnabled(false);
    }

    private boolean isGameOver() {
        char c0 = this.b0.getText().charAt(0);
        char c1 = this.b1.getText().charAt(0);
        char c2 = this.b2.getText().charAt(0);
        char c3 = this.b3.getText().charAt(0);
        char c4 = this.b4.getText().charAt(0);
        char c5 = this.b5.getText().charAt(0);
        char c6 = this.b6.getText().charAt(0);
        char c7 = this.b7.getText().charAt(0);
        char c8 = this.b8.getText().charAt(0);
        char winner = ' ';
        if (c0 != ' ' && c0 == c1 && c1 == c2) {
            winner = c0;
        } else if (c3 != ' ' && c3 == c4 && c4 == c5) {
            winner = c3;
        } else if (c6 != ' ' && c6 == c7 && c7 == c8) {
            winner = c6;
        } else if (c0 != ' ' && c0 == c3 && c3 == c6) {
            winner = c0;
        } else if (c1 != ' ' && c1 == c4 && c4 == c7) {
            winner = c1;
        } else if (c2 != ' ' && c2 == c5 && c5 == c8) {
            winner = c2;
        } else if (c0 != ' ' && c0 == c4 && c4 == c8) {
            winner = c0;
        } else if (c2 != ' ' && c2 == c4 && c4 == c6) {
            winner = c2;
        }
        --this.unplayedCount;
        if (winner != ' ') {
            this.display.setText("Game Over: Winner is " + winner + "!!!");
            return true;
        }
        if (this.unplayedCount == 0) {
            this.display.setText("Game Over: DRAW - No winner!!!");
            return true;
        }
        return false;
    }

    private class ButtonListener
    implements ActionListener {
        private ButtonListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source == myTicTacToe.this.b0) {
                myTicTacToe.this.b0.setText("" + myTicTacToe.this.nextPlayer);
                myTicTacToe.this.b0.setEnabled(false);
            } else if (source == myTicTacToe.this.b1) {
                myTicTacToe.this.b1.setText("" + myTicTacToe.this.nextPlayer);
                myTicTacToe.this.b1.setEnabled(false);
            } else if (source == myTicTacToe.this.b2) {
                myTicTacToe.this.b2.setText("" + myTicTacToe.this.nextPlayer);
                myTicTacToe.this.b2.setEnabled(false);
            } else if (source == myTicTacToe.this.b3) {
                myTicTacToe.this.b3.setText("" + myTicTacToe.this.nextPlayer);
                myTicTacToe.this.b3.setEnabled(false);
            } else if (source == myTicTacToe.this.b4) {
                myTicTacToe.this.b4.setText("" + myTicTacToe.this.nextPlayer);
                myTicTacToe.this.b4.setEnabled(false);
            } else if (source == myTicTacToe.this.b5) {
                myTicTacToe.this.b5.setText("" + myTicTacToe.this.nextPlayer);
                myTicTacToe.this.b5.setEnabled(false);
            } else if (source == myTicTacToe.this.b6) {
                myTicTacToe.this.b6.setText("" + myTicTacToe.this.nextPlayer);
                myTicTacToe.this.b6.setEnabled(false);
            } else if (source == myTicTacToe.this.b7) {
                myTicTacToe.this.b7.setText("" + myTicTacToe.this.nextPlayer);
                myTicTacToe.this.b7.setEnabled(false);
            } else if (source == myTicTacToe.this.b8) {
                myTicTacToe.this.b8.setText("" + myTicTacToe.this.nextPlayer);
                myTicTacToe.this.b8.setEnabled(false);
            }
            if (myTicTacToe.this.isGameOver()) {
                myTicTacToe.this.disableAllButtons();
            } else {
                myTicTacToe.this.setNextPlayer();
            }
        }
    }

}