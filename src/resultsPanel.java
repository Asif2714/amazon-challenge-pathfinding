import javax.swing.*;
import java.awt.*;

public class resultsPanel extends JPanel {

    public resultsPanel(String pathString, String stepNumberString){
        this.setPreferredSize(new Dimension(700, 70 ));
        this.setBackground(Color.white);
        this.setForeground(Color.black);
        //this.setLayout(new GridLayout(maxRow, maxCol));
        this.setFocusable(true);

        Label label1 = new Label(pathString);
        this.add(label1);
        Label label2 = new Label(stepNumberString);
        this.add(label2);
    }

}
