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
 * A program to print out various ScintillationGrids. Part 2 of assignment 3.
 *
 *  email address: cdtrejo@utexas.edu
 *  UTEID: cdt876
 *  Section 5 digit ID: 53255
 *  Grader name: Rebecca
 *  Number of slip days used on this assignment: 1
 */

public class ScintillationGrid {

    public static void main(String[] args)
    
    {
        
        DrawingPanel panel = new DrawingPanel(900, 650); //Sets DrawingPanel at a size of (900,650).
        Graphics g =  panel.getGraphics();
        panel.setBackground(Color.CYAN); //Sets Background color : CYAN
        
    //Calling method grid four times. 
    //By using parameters, each method will be called with their respective value of variables.
    grid(g, 0, 0, 300, 3, 6);
    grid(g, 50, 400, 200, 1, 20);
    grid(g, 400, 50, 420, 6, 10);
    grid(g, 500, 500, 105, 7, 4);
          
    } 
    
    //Declaring method named grid.
    public static void grid(Graphics g, int x, int y, int size, int numLines, int thickLine) {
        
        g.setColor(Color.BLACK);// Sets color : BLACK. This color is used for the four big rectangles drawn. 
        g.fillRect(x, y, size, size);// Drawing rectangle with its respective variables.
        
        int w = (size / (numLines + 1)); 
        int o = x;
        int l = y;
        int e = Math.max((int)((40 * thickLine / 100) + thickLine), (thickLine + 2)); // Thickness of the lines
     
    g.setColor(Color.GRAY); // Sets color : GRAY. This color is used for the lines that divide the black rectangles.
    for(double p = w; p < size-1; p+=w) {
        for (int i = 0; i < numLines; i++) {
            g.fillRect(((o+w)-(thickLine/2)), y, thickLine, size); // Draws gray vertical lines.
      }
      
    o+=w;
        
    }
    
    for(double p = w; p < size-1; p+=w){       
           for (int i = 0; i < numLines; i++) {
               g.fillRect(x,((l+w)-(thickLine/2)), size, thickLine); // Draws gray horizontal lines.
      }
      
    l+=w;
      
    }

    g.setColor(Color.WHITE); // Sets color : WHITE. This color is used to fill the ovals.
    for(int j = 1; j <= numLines; j++) {
        for (int i = 1; i <= numLines; i++) {
            g.fillOval(((x + j * w)-(e/2)), (y + i * w)-(e/2), e, e); // Draws white ovals on every line intersection. 
        }
    }
  }
}