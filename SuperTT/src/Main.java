import javax.swing.*;
import static javax.swing.JFrame.*;

public class Main
{
  public static void main(String[] args)
  {
    //JFrame frame = new Title();
    JFrame frame = new Gameboard();
    frame.setTitle("GUI Test");
    frame.setLocation(400, 100);
    frame.setSize(500,500);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}