/*
    Main class file for the pathfinding solution
    Abdullah Al Asif

    Algorithm used: A* Pathfinding Algorithm
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
