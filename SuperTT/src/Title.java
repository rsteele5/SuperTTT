import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Title extends JFrame {

    private static final JButton sa = new JButton("Stand Alone");
    private static final JButton n = new JButton("Network");
    private static final JButton quit = new JButton("Quit");
    private Container c;
    public static JTextField header;
    
    public Title() {
        
        c = getContentPane();
        header = new JTextField("Select Game Type");
        header.setEditable(false);
        
        JPanel grid = new JPanel();
            grid.setLayout(new GridLayout(2,1));
            grid.add(header);
            c.add(grid, "North");
            
        JPanel buttonPanel = new JPanel();
            buttonPanel.add(sa);
            buttonPanel.add(n);
            buttonPanel.add(quit);
            c.add(buttonPanel, "Center");
    
        Title.ButtonListener listener = new Title.ButtonListener();
        sa.addActionListener(listener);
        n.addActionListener(listener);
        quit.addActionListener(listener);
    }   

    private static class ButtonListener implements ActionListener {

        public ButtonListener() {}
        
        public void actionPerformed(ActionEvent ae){
            if (ae.getSource() == sa){
                JFrame frame2 = new Gameboard();
                frame2.setVisible(true);
                frame2.setTitle("Standalone Game");
                frame2.setLocation(400, 100);
                frame2.setSize(500,500);
                frame2.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame2.setVisible(true);
            }
            if (ae.getSource() == n){
                JFrame frame3 = new Gameboard();
                frame3.setVisible(true);
                frame3.setVisible(true);
                frame3.setTitle("Network Game");
                frame3.setLocation(400, 100);
                frame3.setSize(500,500);
                frame3.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame3.setVisible(true);
            }
            if (ae.getSource() == quit){
                System.exit(0);
            }
        }
    }
}
