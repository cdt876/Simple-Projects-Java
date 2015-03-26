
/**
 * Program to draw a mirror using ASCII art.
 * Demo nested loops.
 */
public class MirrorChange
{
    public static final int SIZE = 15;

    public static void main(String[] args) {
        line();
        topHalf();
        bottomHalf();
        line();
    }

    // Prints the expanding pattern of <> for 
    // the top half of the figure.
    public static void topHalf() {
        for (int line = 1; line <= SIZE; line++) {
            System.out.print("|");

            int numSpaces = line * -2 + SIZE * 2;
            int numDots = line * 4 - 4;
            for (int space = 1; space <= numSpaces; space++) {
                System.out.print(" ");
            }
            System.out.print("<>");
            for (int dot = 1; dot <= numDots; dot++) {
                System.out.print(".");
            }
            System.out.print("<>");
            for (int space = 1; space <= numSpaces; space++) {
                System.out.print(" ");
            }
            System.out.println("|");
        }
    }

    // Prints the shrinking pattern of <> for 
    // the bottom half of the figure.
    public static void bottomHalf() {
        for (int line = 1; line <= SIZE; line++) {
            System.out.print("|");
            int numDots = line * -4 + 4 * SIZE;// line * -4 + 16;
            int numSpaces = 2 * (line - 1);  // line * 2 - 2;
            for (int space = 1; space <= numSpaces; space++) {
                System.out.print(" ");
            }
            System.out.print("<>");
            for (int dot = 1; dot <= numDots; dot++) {
                System.out.print(".");
            }
            System.out.print("<>");
            for (int space = 1; space <= numSpaces; space++) {
                System.out.print(" ");
            }
            System.out.println("|");

        }
    }

    public static void line() {
        System.out.print("#");
        int numEquals = SIZE * 4;
        for(int i = 1; i <= numEquals; i++) {
            System.out.print("=");
        }
        System.out.println("#");
    }
}