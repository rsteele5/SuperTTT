import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


//GET ADDR LOGIC IS DONE
//NEED TO ADD COMMENTS
public class HoN extends JFrame {

    private static final JButton host = new JButton("i am host");
    private static final JButton nah = new JButton("nah fam");
    private static final JLabel label = new JLabel("Are you host?");
    public static boolean isClient;
    
    String temp = "I HATE YOU!!!!!!!";
    private Container c;

    public HoN()  {

        //Layout content Pane
        c = getContentPane();
        JPanel bgrid = new JPanel();
        bgrid.setLayout(new GridLayout(3,1));
        
        label.setHorizontalAlignment(JLabel.CENTER);
        
        Font labelFont = new Font("Courier New", 1, 18);
        label.setFont(labelFont);
        
         
        bgrid.add(label);
        bgrid.add(host);
        bgrid.add(nah);
        c.add(bgrid, "Center");
            
        //Add submit button listen
        HoN.ButtonListener listener = new HoN.ButtonListener();
        host.addActionListener(listener);
        nah.addActionListener(listener);
    }
 
    private class ButtonListener implements ActionListener {

        private ButtonListener() {}
        public void actionPerformed(ActionEvent ae){
            if (ae.getSource() == host){
                isClient = true;
                JFrame NetworkGB = null;
                try {
                    NetworkGB = new NetworkGB();
                } catch (Exception ex) {
                    Logger.getLogger(HoN.class.getName()).log(Level.SEVERE, null, ex);
                }
                NetworkGB.setVisible(true);
                NetworkGB.setTitle("Network Game");
                NetworkGB.setLocation(400, 100);
                NetworkGB.setSize(500,500);
                NetworkGB.setDefaultCloseOperation(EXIT_ON_CLOSE);
                NetworkGB.setVisible(true);
            }
            
            if (ae.getSource() == nah){
                JFrame GetAddr = new GetAddr();
                GetAddr.setVisible(true);
                GetAddr.setVisible(true);
                GetAddr.setTitle("Host or Nah???");
                GetAddr.setLocation(400, 100);
                GetAddr.setSize(500,150);
                GetAddr.setVisible(true);                
            }
            dispose();
        }
    }
}
