/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Remington Steele
 */
public class STTT_Exception extends Exception {
  /*Result meanings:
    -1 = error
     0 = tie
     1 = Player 1 wins
     2 = Player 2 wins
    */
  public int result;
  public STTT_Exception() { super(); result = -1; }
  public STTT_Exception(int r) { super(); result = r; }
  public STTT_Exception(String message) { super(message); }
  public STTT_Exception(String message, Throwable cause) { super(message, cause); }
  public STTT_Exception(Throwable cause) { super(cause); }
}
