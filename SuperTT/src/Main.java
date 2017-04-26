import javax.swing.*;
import static javax.swing.JFrame.*;

public class Main
{
  public static void main(String[] args)
  {
      
    // MAIN PROGRAM IS FINISHED
    JFrame frame = new Title();
    frame.setTitle("Super Tic Tac Toe");
    frame.setLocation(400, 100);
    frame.setSize(500,500);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}