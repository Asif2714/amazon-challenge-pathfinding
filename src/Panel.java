import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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
    ArrayList<Node> openList = new ArrayList<Node>();
    ArrayList<Node> checkedList = new ArrayList<Node>();
    ArrayList<String> resultArray = new ArrayList<>();

    boolean goalReached = false;
    int steps = 0; //counts the number of times search is done

    // Constructor
    public Panel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setLayout(new GridLayout(maxRow, maxCol));
        this.addKeyListener(new KeyHandler(this));
        this.setFocusable(true);

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

        //Scanner scanner = new Scanner("Which option?");

        // setting initial nodes
        // customized method to randomize paths will be implemented soon

        //setting start and goal node
        setStartNode(0,0);
        setGoalNode(9,9);

        //setting solid node
        setSolidNode(1,0);
        //setSolidNode(1,1);
        setSolidNode(1,2);
        setSolidNode(2,0);
        setSolidNode(4,0);
        setSolidNode(4,1);
        setSolidNode(5,1);
        setSolidNode(3,3);
        setSolidNode(3,4);
        setSolidNode(3,5);
        //setSolidNode(3,6);
        setSolidNode(3,7);
        setSolidNode(3,8);
        setSolidNode(3,9);
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


    // Methods for setting specific type of nodes
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
            //node.setText("<html>F:"+node.fCost+"<br>G:"+node.gCost + "</html>");
        }


    }

    // Method which checks and evaluates a new node
    // First we check if it is a goal,
    // if not, mark as checked and remove from open/available ones
    public void search(){
        if(goalReached == false){
            int col = currentNode.col;
            int row = currentNode.row;

            currentNode.setAsChecked();
            checkedList.add(currentNode);
            openList.remove(currentNode);

            //opening nodes on 4 sides (if possible, check edge cases)
            // Open the upper node
            if (row -1 >= 0){
                openNode(node[col][row-1]);
            }
            // Open the lower node
            if (row +1 < maxRow){
                openNode(node[col][row+1]);
            }
            // Open the left node
            if(col-1 >= 0){
                openNode(node[col-1][row]);
            }
            // Open the right node
            if(col+1 < maxCol){
                openNode(node[col+1][row]);
            }

            // Finding BEST NODE
            int bestNodeIndex = 0; // assuming first node is best
            int bestNodefCost = 1000;

            for(int i = 0; i < openList.size(); i++){

                // Checking if F cost is better for current node
                // not useful for initial map since F cost is the same
                if(openList.get(i).fCost < bestNodefCost){
                    bestNodeIndex = i;
                    bestNodefCost = openList.get(i).fCost;
                }
                // If F cost is not equal, check the G cost
                else if(openList.get(i).fCost == bestNodefCost){
                    if(openList.get(i).gCost < openList.get(bestNodeIndex).gCost){
                        bestNodeIndex = i;
                    }
                }

            }

            // the best node is our next step
            currentNode = openList.get(bestNodeIndex);

            //check if goal node
            if(currentNode == goalNode){
                goalReached = true;
                backTrack(); // for showing the final result
            }

        }
    }


    public void autoSearch(){
        // does continuously, until reaches goal or step limit
        while(goalReached == false && steps < 1000){
            int col = currentNode.col;
            int row = currentNode.row;

            currentNode.setAsChecked();
            checkedList.add(currentNode);
            openList.remove(currentNode);

            //opening nodes on 4 sides (if possible, check edge cases)
            // Open the upper node
            if (row -1 >= 0){
                openNode(node[col][row-1]);
            }
            // Open the lower node
            if (row +1 < maxRow){
                openNode(node[col][row+1]);
            }
            // Open the left node
            if(col-1 >= 0){
                openNode(node[col-1][row]);
            }
            // Open the right node
            if(col+1 < maxCol){
                openNode(node[col+1][row]);
            }

            // Finding BEST NODE
            int bestNodeIndex = 0; // assuming first node is best
            int bestNodefCost = 1000;

            for(int i = 0; i < openList.size(); i++){

                // Checking if F cost is better for current node
                // not useful for initial map since F cost is the same
                if(openList.get(i).fCost < bestNodefCost){
                    bestNodeIndex = i;
                    bestNodefCost = openList.get(i).fCost;
                }
                // If F cost is not equal, check the G cost
                else if(openList.get(i).fCost == bestNodefCost){
                    if(openList.get(i).gCost < openList.get(bestNodeIndex).gCost){
                        bestNodeIndex = i;
                    }
                }

            }

            // the best node is our next step
            currentNode = openList.get(bestNodeIndex);

            //check if goal node
            if(currentNode == goalNode){
                goalReached = true;
                backTrack(); // for showing the final result
            }

        }

        steps++;
    }


    // change node to open state for evaluation
    private void openNode(Node node){
        // initial criteria for evaluation
        if(node.open == false && node.checked == false && node.solid == false){

            //mark the node as open, then set parent of current node as parent (for backtracking)
            // then add it to open node
            node.setAsOpen();
            node.parent = currentNode;
            openList.add(node);
        }
    }

    // Method to backtrack and get the best path
    public void backTrack(){
        Node current = goalNode;

        // adding to result arraylist
        resultArray.add("("+current.row + ","+current.col+")");

        while(current != startNode){

            current = current.parent;
            resultArray.add("("+current.row + ","+current.col+")");

            if(current != startNode){
                current.setAsPath();
            }
        }

        //printing result arrayList in reverse and also sending to GUI
        String resultPath = "The path is: [";
        String resultSteps = "";
        System.out.print(resultPath);
        for (int i = resultArray.size()-1; i >= 0; i--){
            System.out.print(resultArray.get(i)+" ");
            resultPath += resultArray.get(i)+" ";
        }
        System.out.print("]");
        resultPath += "]";
        System.out.println();
        //System.out.println("Steps taken: "+(resultArray.size()-1));
        resultSteps += "Steps taken: "+(resultArray.size()-1);
        System.out.println(resultSteps);

        // Showing results in a new window
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        //adding a panel
        window.add(new resultsPanel(resultPath, resultSteps));
        window.pack(); // makes sure all contents are in preferred size
        window.setLocationRelativeTo(null);
        window.setVisible(true);


    }
}
