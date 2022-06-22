/*
    Main class file for the pathfinding solution for Amazon Coding Challenge
    for Bright Network Internship Experience UK 2022

    by Abdullah Al Asif

    Developed using: Amazon Corretto JDK 11
                     IntelliJ IDEA

    Algorithm used: A* Pathfinding Algorithm
 */

/*
 Future extension plans:
    1. More responsive and flexible UI
    2. Allow diagonal traversing
    3. Enable user input for selecting cells to be blocked and setting the start and goal cells
    4. Cleanup of unused code
    5. Allow options for randomized code

 */


/*
G Cost: Distance between starting position and current position
H Cost: Distance between current position and goal
F Cost: Sum of G+H Costs

F cost is the most important one since it is the total cost. At first we compare F cost and if F cost
is same, we compare G cost and go with the lower ones.

Solid blocks are implemented which prevents passing through

 */

//importing libraries
import javax.swing.*;

public class Main {


    public static void main(String[] args) {

        // Initial window panel
        JFrame window = new JFrame("CLICK HERE *FIRST* AND PRESS ENTER TO GET RESULTS!");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        //adding a panel
        window.add(new Panel());
        window.pack(); // makes sure all contents are in preferred size
        window.setLocationRelativeTo(null);
        window.setVisible(true);

    }

}

