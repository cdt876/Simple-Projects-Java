import java.awt.Color;
import java.awt.Graphics;

/**
 * @author  Carlos Trejo
 * @version 2/15/2013
 * CS312 Assignment 3.
 * On my honor, Carlos Trejo, this programming assignment is my own work and I have
 * not shared my solution wiht any other student in the class.
 *
 *
 * A program to create a drawing. Part 1 of the assignment, worth 5 points.
 *
 *  email address: cdtrejo@utexas.edu
 *  UTEID: cdt876
 *  Section 5 digit ID: 53255
 *  Grader name: Rebecca
 *  Number of slip days used on this assignment: 1
 */

public class Drawing1 {

    public static void main(String[] args) 
    
    {
        
        DrawingPanel panel = new DrawingPanel(800, 400); // Size of DrawingPanel (800 , 400)
        Graphics g = panel.getGraphics();
        panel.setBackground(Color.GREEN); // Sets background GREEN
        
            g.drawLine(400, 0, 400, 400); // Draws a vertical line starting at (400,0) and ending at (400,400).
            g.drawLine(0, 200, 800, 200); // Draws a horizontal line starting at (0,200) and ending at (800,200).
                   
            drawOval( g, 0, 0); // Calling method drawOval. Coordinates: x=0, y=0. 
            drawOval( g, 400, 200); // Calling method drawOval. Coordinates: x=400, y=200.
                   
    }      
                                                        
    //Declaring method called drawOval. 
    //This method will draw a red oval.
    //This method will also draw two black lines, one horizontal and one vertical, dividing each oval on four equal parts.
    public static void drawOval(Graphics g, int x, int y)  {
        
     g.setColor(Color.RED); // Oval color : RED
        g.drawOval(x, y, 400, 200); 
        g.fillOval(x, y, 400, 200);
                           
     g.setColor(Color.BLACK); // Lines color : BLACK
        g.drawLine((x + 200), y, (x + 200), ( y + 200)); 
        g.drawLine(x, (y + 100), (x + 400), (y + 100)); 
                                               
    }                                                                                   
} 
        
    
