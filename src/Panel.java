import javax.swing.*;
import java.awt.*;

public class Panel  extends JPanel {

    //Screen settings
    final int maxRow = 10;
    final int maxCol = 10;
    final int nodeSize = 50;
    final int screenHeight  = nodeSize*maxRow;
    final int screenWidth = nodeSize*maxCol;

    // Nodes in 2D array
    Node[][] node = new Node [maxCol][maxRow];


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

    }

}
