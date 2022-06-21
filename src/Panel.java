import javax.swing.*;
import java.awt.*;

public class Panel  extends JPanel {

    //Screen settings
    final int maxRow = 10;
    final int maxCol = 10;
    final int nodeSize = 70;
    final int screenHeight  = nodeSize*maxRow;
    final int screenWidth = nodeSize*maxCol;

    // Constructor
    public Panel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setLayout(new GridLayout(maxRow, maxCol));
    }

}
