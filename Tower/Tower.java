/**
 * @author  Carlos Trejo    
 * @version 02/08/2013
 * CS312 Assignment 2.
 * On my honor, Carlos Trejo, this programming assignment is my own work and I have
 * not shared my solution wiht any other student in the class.
 *
 *
 * A program to print out the UT Tower via ASCII art.
 *
 *  email address: cdtrejo@utexas.edu
 *  UTEID: cdt876
 *  Section 5 digit ID: 53255
 *  Grader name: Rebecca
 *  Number of slip days used on this assignment: 0
 */

public class Tower  // This program prints out a Tower on any size requested.
{
    public static final int SIZE = 5; // Declaring a constant named SIZE. Changes the size of the Tower.

    public static void main(String[] args)
    {
        TopTower(); // Top part of the Tower
        BodyTower(); // Body part of the Tower
        BottomTower(); // Bottom part of the Tower
    }
    
    // Declaring a method named Numbersigns.
    // This method prints out a certian number of Number signs in the first and last line of the Top of the Tower.
    public static void Numbersigns() {  
        for (int i = 1; i <= (2 * SIZE)-1; i++)
            System.out.print("#");  
    }
    
    // Declaring a method named TopTower.
    // Declares three variables.    
    public static void TopTower() {
        
    int numSpaces = ( SIZE + 2 ); //Variable. Number of spaces
    int numLineOfVerticalLines = (2*SIZE)-2; //Variable. Number of rows of Vertical lines.
    int numVerticalLines = (2*SIZE)-1; //Variable. Number of Vertical lines.
            
        for (int space = 1; space <= numSpaces; space++) {
            System.out.print(" ");
        }
        
        Numbersigns(); //Calling method named Numbersigns. Prints out the first line of the Top of the Tower.
        System.out.println(); //new line
        
        for(int lines = 1; lines <= numLineOfVerticalLines; lines++){
            for (int space = 1; space <= numSpaces; space++) {
               System.out.print(" ");
        }
            for (int verticalLine = 1; verticalLine <= numVerticalLines; verticalLine++) {
                System.out.print("|");
        }
            
        System.out.println(); //new line
            
        }
            for (int space = 1; space <= numSpaces; space++) {
               System.out.print(" ");
        }
        
        Numbersigns(); //Prints out the last line of the Top of the Tower.
        System.out.println(); //new line
}
    
    // Declaring a method named BodyTower.
    // This method will print out the Body of the Tower. Which is between the Top and the Base of the Tower.
    // Declares two variables.
    public static void BodyTower() {
        
    int height = SIZE*SIZE; //Variable. Number of rows in the Body of the Tower.
    int numTilde = (SIZE * 2) + 3; //Variable. Number of Tilde signs.
         
         for (int spaces=1; spaces <= SIZE; spaces++){
             System.out.print(" ");
    }  
         for (int tilde = 1; tilde <= numTilde; tilde++) {
             System.out.print("~");
    }
    
    System.out.println(); //new line
         
         for (int rows=1; rows <= height; rows++) {
             for (int spaces=1; spaces <= SIZE; spaces++){
                System.out.print(" ");
    } 
        
    System.out.print("|");
         
         for (int windows = 1; windows <= SIZE; windows++) {
             System.out.print("-O");
    }
    
    System.out.print("-|\n"); //Prints "-|" and then goes to a new line.
    
         for (int spaces=1; spaces <= SIZE; spaces++){
             System.out.print(" ");
    }  
         for (int tilde = 1; tilde <= numTilde; tilde++) {
             System.out.print("~");
    }
    
    System.out.println(); //new line
    
    }
}
    
    // Declaring a method named BottomTower.
    // This method prints out the Bottom of the tower.
    // Declares one variable.
    public static void BottomTower() {
        
    int v2 = SIZE;
        
        for (int v = SIZE; v <= SIZE * 2; v=v+2) {
            for (int spaces = 1; spaces <= v2; spaces++){
                System.out.print(" ");
    }
     
    v2 = v2-2; 
    System.out.print("/"); 
    
        for (int quotationmarks = 1; quotationmarks <= v; quotationmarks++) {
            System.out.print("\"'"); 
    }  
    
    System.out.print("\"\\\n"); //Prints ""\" and then goes to a new line.
    
    }
        for (int rows2 = 1; rows2 <= SIZE; rows2++) {
            System.out.print("/");
                for (int columns = 1; columns <= SIZE * 2; columns++) {
                    System.out.print("\"O");
    }
    
    System.out.print("\"\\\n"); //Prints ""\" and then goes to a new line. 
        
    }
  }
}
    
    
        
        
       
        
            
       
        
        
        
      