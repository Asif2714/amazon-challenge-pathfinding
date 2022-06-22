import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// A button which responds to clicks
public class Node extends JButton implements ActionListener {

    Node parent;
    int row;
    int col;
    int gCost;
    int hCost;
    int fCost;

    boolean start;
    boolean goal;
    boolean solid;
    boolean open;
    boolean checked;

    // Constructor
    public Node(int col, int row){
        this.col = col;
        this.row = row;


        setBackground(Color.orange);
        setForeground(Color.black);
        addActionListener(this);
        Border whiteLine = BorderFactory.createLineBorder(Color.white);
        setBorder(whiteLine);

    }

    //method to set specific node as start
    public void setAsStart(){
        setBackground(Color.RED);
        setForeground(Color.white);
        setText("S");
        start = true;

    }

    //method to set specific node as goal
    public void setAsGoal(){
        setBackground(Color.BLUE);
        setForeground(Color.white);
        setText("E");
        start = true;

    }

    //method to set a solid node
    public void setAsSolid(){
        setBackground(Color.gray);
        setForeground(Color.white);
        solid = true;
    }

    // methods to set specific instance variables of Node
    public void setAsOpen(){
        open = true;
    }
    public void setAsChecked(){
        if(start == false && goal == false){
            setBackground(Color.pink);
            setForeground(Color.black);
        }
        checked = true;
    }

    // Method which makes nodes the final path - used for backtracking
    // and final path display
    public void setAsPath(){
        setBackground(Color.green);
        setForeground(Color.black);
    }

    // actions when button is clicked
    @Override
    public void actionPerformed(ActionEvent e){
        setBackground(Color.CYAN);
    }

}
