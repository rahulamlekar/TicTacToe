import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class TicTacToe extends JFrame {
  
  private Container content;
  private int WIDTH_OF_FRAME = 450;
  private int HEIGHT_OF_FRAME= 550;
  private JButton [] cell;
  private Cellhandler[] cellhandlers;
  private int turn=0;
  
  public TicTacToe (){
    
    //initialize game pane
    super("TicTacToe");
    setSize(WIDTH_OF_FRAME, HEIGHT_OF_FRAME);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    content=getContentPane();
    content.setLayout(new GridLayout(3,3));
    
    //create cells
    cell=new JButton[9];
    cellhandlers=new Cellhandler[9];
    for(int i=0; i<9; i++)
    {
      cell[i]=new JButton("");
      cellhandlers[i]=new Cellhandler();
      cell[i].addActionListener(cellhandlers[i]);
    }
    
    //Add cells to the pane
    for(int i=0; i<9; i++)
    {
      content.add(cell[i]);
    }
    init();
  }
  
  public class Cellhandler implements ActionListener {
    public String state;

    public void actionPerformed(ActionEvent e)
    {
      if (turn==5) //turn 5 means game is over
        return;
      
      //Get button pressed
      JButton pressed=(JButton)(e.getSource());
      //Get state of button
      state=pressed.getText();
      
      if (state == "X" || state == "O") //move already made in this position
        return;
      
      if (turn ==0)
      {
        pressed.setText("X");
        turn++;
      }
      else
      {
        pressed.setText("O");
        turn--;
      }
      if (gameOver())
      {
        result(); 
        return;
      }
    }
    public boolean gameOver() //8 conditions to win the game
    {
      if(cell[0].getText().equals(cell[1].getText()) && cell[1].getText().equals(cell[2].getText()) && cell[0].getText() !="")
      {
        return true;
      }
      else if(cell[3].getText().equals(cell[4].getText()) && cell[4].getText().equals(cell[5].getText())&& cell[5].getText() !="")
      {
        return true;
      }
      else if(cell[6].getText().equals(cell[7].getText()) && cell[7].getText().equals(cell[8].getText())&& cell[8].getText() !="")
      {
        return true;
      }
      else if(cell[0].getText().equals(cell[3].getText()) && cell[3].getText().equals(cell[6].getText())&& cell[6].getText() !="")
      {
        return true;
      }
      else if(cell[1].getText().equals(cell[4].getText()) && cell[4].getText().equals(cell[7].getText())&& cell[7].getText() !="")
      {
        return true;
      }
      else if(cell[2].getText().equals(cell[5].getText()) && cell[5].getText().equals(cell[8].getText())&& cell[8].getText() !="")
      {
        return true;
      }
      else if(cell[0].getText().equals(cell[4].getText()) && cell[4].getText().equals(cell[8].getText())&& cell[8].getText() !="")
      {
        return true;
      }
      else if(cell[2].getText().equals(cell[4].getText()) && cell[4].getText().equals(cell[6].getText())&& cell[6].getText() !="")
      {
        return true;
      }
      else if (cell[0].getText() !="" && cell[1].getText() !="" && cell[2].getText() !="" && cell[3].getText() !="" && cell[4].getText() !="" && cell[5].getText() !="" && cell[6].getText() !="" && cell[7].getText() !="" && cell[8].getText() !="")
      {
        turn=2; // condition for draw
        return true;
      }
      else 
        return false;
    }
  }
  
  
  public void result() {
    if (turn==1)
    {
      JOptionPane.showMessageDialog(new JFrame(), "The winner is: X");
      turn=5;
    }
    else if (turn==0)
    {
      JOptionPane.showMessageDialog(new JFrame(), "The winner is: O");
      turn=5;
    }
    else if (turn==2)
      JOptionPane.showMessageDialog(new JFrame(), "The game is a draw");
  }
  
  public void init() // initialize app
  {
    //Initialize text in buttons
    for(int i=0; i<9; i++)
    {
      cell[i].setText("");
    }
    setVisible(true);
  }
  
  public static void main (String [] args){
    TicTacToe play = new TicTacToe();
  }
}
