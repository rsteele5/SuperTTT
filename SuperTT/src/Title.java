import java.awt.Container;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Title extends JFrame {

    private final JButton single = new JButton("Offline");
    private final JButton multi = new JButton("Online");
    public static JTextField header;
    
    public Title() {
        
        Container c = getContentPane();
        header = new JTextField("Select Game Type");
        header.setEditable(false);
        
        JPanel grid = new JPanel();
            grid.setLayout(new GridLayout(2,1));
            grid.add(header);
            c.add(grid, "North");
            
        JPanel buttonPanel = new JPanel();
            buttonPanel.add(single);
            buttonPanel.add(multi);
            c.add(buttonPanel, "Center");
            
            /*
            Add button listener stuff and make it work and stuff. :)
            */
    }      
}
