import javax.swing.*;
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


        setBackground(Color.white);
        setForeground(Color.black);
        addActionListener(this);

    }

    // actions when button is clicked
    @Override
    public void actionPerformed(ActionEvent e){
        setBackground(Color.orange);
    }

}
