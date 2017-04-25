import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GetAddr extends JFrame {

    private static final JButton submit = new JButton("Submit");
    private Container c;
    public static JTextField IPvEnter;
    public static JLabel label;
    public static String IP;

    public GetAddr()  {

        //Layout content Pane
        c = getContentPane();
        JPanel ipgrid = new JPanel();
        JPanel sub = new JPanel();
        ipgrid.setLayout(new GridLayout(2,1));
        label = new JLabel("Enter IP:");
        IPvEnter = new JTextField();
        ipgrid.add(label);
        ipgrid.add(IPvEnter);
        sub.add(submit);
        c.add(ipgrid,"North");
        c.add(sub, "Center");
            
        //Add submit button listen
        GetAddr.ButtonListener listener = new GetAddr.ButtonListener();
        submit.addActionListener(listener);
    }
 
    private class ButtonListener implements ActionListener {

        private ButtonListener() {}
        public void actionPerformed(ActionEvent ae){
            if (ae.getSource() == submit){
                
                IP = IPvEnter.getText();
                System.out.println(IP);
                
                if (IPvEnter.getText().trim().equals("")){}
                else {
                    JFrame NetworkGB = new NetworkGB();
                    NetworkGB.setVisible(true);
                    NetworkGB.setVisible(true);
                    NetworkGB.setTitle("Network Game");
                    NetworkGB.setLocation(400, 100);
                    NetworkGB.setSize(500,500);
                    NetworkGB.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    NetworkGB.setVisible(true);
                }
                dispose();
            }
        }
    }
}