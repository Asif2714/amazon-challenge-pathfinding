/*
    Main class file for the pathfinding solution
    Abdullah Al Asif

    Algorithm used: A* Pathfinding Algorithm
 */


/*
G Cost: Distance between starting position and current position
H Cost: Distance between current position and goal
F Cost: Sum of G+H Costs

F cost is the most important one since it is the total cost
 */

//importing libraries

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        // Initial window panel
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        //adding a panel
        window.add(new Panel());
        window.pack(); // makes sure all contents are in preferred size
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }

}

