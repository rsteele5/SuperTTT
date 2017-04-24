import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Title extends JFrame {

    private static final JButton sa = new JButton("Stand Alone");
    private static final JButton n = new JButton("Network");
    private static final JButton quit = new JButton("Quit");
    private static final JButton submit = new JButton("Submit");
    private Container c;
    public static JTextField header;
    public static JTextField IPvEnter;
    public static JLabel label;
    public static String IP;
    
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
        
        JPanel ipgrid = new JPanel();
            ipgrid.setLayout(new GridLayout(3,1));
            JLabel label = new JLabel("Enter IP:");
            IPvEnter = new JTextField();
            ipgrid.add(label);
            ipgrid.add(IPvEnter);
            ipgrid.add(submit);
            c.add(ipgrid,"South");

   
        Title.ButtonListener listener = new Title.ButtonListener();
        sa.addActionListener(listener);
        n.addActionListener(listener);
        quit.addActionListener(listener);
        submit.addActionListener(listener);
    }

    private static class ButtonListener implements ActionListener {

        public ButtonListener() {}
        
        public void actionPerformed(ActionEvent ae){
            if (ae.getSource() == sa){
                JFrame StandaloneGB = new StandaloneGB();
                StandaloneGB.setVisible(true);
                StandaloneGB.setTitle("Standalone Game");
                StandaloneGB.setLocation(400, 100);
                StandaloneGB.setSize(500,500);
                StandaloneGB.setDefaultCloseOperation(EXIT_ON_CLOSE);
                StandaloneGB.setVisible(true);
            }
            else if (ae.getSource() == n){
                JFrame NetworkGB = new NetworkGB();
                NetworkGB.setVisible(true);
                NetworkGB.setVisible(true);
                NetworkGB.setTitle("Network Game");
                NetworkGB.setLocation(400, 100);
                NetworkGB.setSize(500,500);
                NetworkGB.setDefaultCloseOperation(EXIT_ON_CLOSE);
                NetworkGB.setVisible(true);
            }
            else if (ae.getSource() == submit){
                IP = IPvEnter.getText();
                System.out.println(IP);
                header.setText("Chosen address is... " + IP);
            }            
            else if (ae.getSource() == quit){
                System.exit(0);
            }
        }
    }
}
