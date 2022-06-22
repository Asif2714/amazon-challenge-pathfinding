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

        // setting initial nodes

        //setting start and goal node
        setStartNode(0,0);
        setGoalNode(9,9);

        //setting solid node
        setSolidNode(1,0);
        setSolidNode(1,1);
        setSolidNode(1,2);
        setSolidNode(2,0);
        setSolidNode(4,0);
        setSolidNode(4,1);
        setSolidNode(5,1);
        setSolidNode(3,3);
        setSolidNode(3,4);
        setSolidNode(3,5);
        setSolidNode(3,6);
        setSolidNode(3,7);
        setSolidNode(3,8);
        setSolidNode(4,3);
        setSolidNode(5,3);
        setSolidNode(6,3);
        setSolidNode(5,3);
        setSolidNode(5,5);
        setSolidNode(5,6);
        setSolidNode(5,7);
        setSolidNode(5,8);
        setSolidNode(7,7);
        setSolidNode(7,8);
        setSolidNode(8,7);
        setSolidNode(9,7);

        setCostOnNodes();

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
    private void setSolidNode(int col, int row){
        node[col][row].setAsSolid();
    }

    //setting cost on nodes
    private void setCostOnNodes(){
        int col = 0;
        int row = 0;

        while (col <maxCol && row < maxRow){
            getCost(node[col][row]);
            col++;
            if(col == maxCol){
                col = 0;
                row++;
            }
        }
    }

    // the method which will calculate the cost for each of the nodes
    // implementing A* algorithm
    private void getCost(Node node){

        // Getting G COST - Distance from start Node
        int xDistance = Math.abs(node.col - startNode.col);
        int yDistance = Math.abs(node.row - startNode.row);
        node.gCost = xDistance + yDistance;

        // Getting H COST - Distance from goal node
        int xHDistance = Math.abs(node.col - goalNode.col);
        int yHDistance = Math.abs(node.row - goalNode.row);
        node.hCost = xHDistance + yHDistance;

        // Getting F Cost - Final total cost - in case of corner cases like this,
        // F cost is the same, as sum of the two costs G and H will always add up to
        // 18 here! since it is indexed upto 9 and max value is 9,9
        node.fCost = node.gCost + node.hCost;

        // Displaying cost on node
        if(node != startNode && node != goalNode){
//            node.setText("<html>F:"+node.fCost+"<br>G:"+node.gCost + "</html>");
            node.setText("<html>H:"+node.hCost+"<br>G:"+node.gCost + "</html>");
        }


    }
}
