import javax.swing.*;
import java.awt.*;

public class Panel  extends JPanel {

    //Screen settings
    final int maxRow = 10;
    final int maxCol = 10;
    final int nodeSize = 50;
    final int screenHeight  = nodeSize*maxRow;
    final int screenWidth = nodeSize*maxCol;

    // Nodes in 2D array with start, end, and current nodes
    Node[][] node = new Node [maxCol][maxRow];
    Node startNode, goalNode, currentNode;

    // Constructor
    public Panel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setLayout(new GridLayout(maxRow, maxCol));

        // placing nodes in panel
        int row = 0;
        int col = 0;

        while (col <maxCol && row < maxRow){
            node[col][row] = new Node(col,row);
            //adding node to the panel
            this.add(node[col][row]);
            col++;
            if(col == maxCol){
                col = 0;
                row++;
            }
        }

        setStartNode(0,0);
        setGoalNode(9,9);

    }

    private void setStartNode(int col, int row){
        node[col][row].setAsStart();
        startNode = node[col][row];
        currentNode = startNode;
        // at the beginning of runtime startNode is the currentNode
    }

    private void setGoalNode(int col, int row){
        node[col][row].setAsGoal();
        goalNode = node[col][row];

    }

}
