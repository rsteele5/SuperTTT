import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


//TITLE LOGIC IS DONE
//LOOK INTO ADDING A GRAPHIC TO THE CENTER OF CONTENT PANE
public class Title extends JFrame {

    private static final JButton sa = new JButton("Stand Alone");
    private static final JButton n = new JButton("Network");
    private static final JButton quit = new JButton("Quit");
    private Container c;
    public static JTextField header;
    
    public Title() {
      
        //Layout of content pane
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
  
        //Attach listeners
        Title.ButtonListener listener = new Title.ButtonListener();
        sa.addActionListener(listener);
        n.addActionListener(listener);
        quit.addActionListener(listener);
    }

    private static class ButtonListener implements ActionListener {

        public ButtonListener() {}
        
        public void actionPerformed(ActionEvent ae){
            if (ae.getSource() == sa){
                
                //If source is Standalone button then do this
                //Make an SA board
                JFrame StandaloneGB = new StandaloneGB();
                StandaloneGB.setVisible(true);
                StandaloneGB.setTitle("Standalone Game");
                StandaloneGB.setLocation(400, 100);
                StandaloneGB.setSize(500,500);
                StandaloneGB.setDefaultCloseOperation(EXIT_ON_CLOSE);
                StandaloneGB.setVisible(true);
            }
            else if (ae.getSource() == n){
                
                //if source is network do this
                //Open GetAddr to get IP
                JFrame IP = new GetAddr();
                IP.setVisible(true);
                IP.setVisible(true);
                IP.setTitle("IP");
                IP.setLocation(400, 100);
                IP.setSize(500,150);
                IP.setVisible(true);
            }
            else if (ae.getSource() == quit){
                System.exit(0);
            }
        }
    }
}