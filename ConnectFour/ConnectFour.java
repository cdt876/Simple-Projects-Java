import java.util.Scanner;
/*
 * CS312 Assignment 9
 * A program to play connect four.
 *
 * On my honor this program is my own work:
 * Carlos Trejo
 *
 *  email address: cdtrejo@utexas.edu   
 *  UTEID: cdt876   
 *  Section 5 digit ID: 53255
 *  Grader name: Rebecca
 *  Number of slip days used on this assignment: 1
 *
 * Number of slip days I am using: 1
 */

public class ConnectFour
{
    public static void main(String[] args)
    {
        intro();
        char[][] board = makeBoard();
        String[] players = getPlayers();
        printBoard(board, players);
        play(players, board);
    }

    // This method shows the intro to the program
    public static void intro()
    {
        System.out.println("This program allows two people to play the");
        System.out.println("game of Connect four. Each player takes turns");
        System.out.println("dropping a checker in one of the open columns");
        System.out.println("on the board. The columns are numbered 1 to 7.");
        System.out.println("The first player to get four checkers in a row");
        System.out.println("horizontally, vertically, or diagonally wins");
        System.out.println("the game. If no player gets fours in a row and");
        System.out.println("and all spots are taken the game is a draw.");
        System.out.println("\nPlayer one's checkers will appear as r's and");
        System.out.println("player two's checkers will appear as b's.");
        System.out.println("Open spaces on the board will appear as .'s.\n");
    }

    // This method prompts the user for an int.
    // The String prompt will be printed out first.
    // The method error checks the response and continues to ask for input until an int is entered.
    // I expect key is connected to System.in.
    public static int getInt(Scanner key, String[] players, int user) {
        while(!key.hasNextInt()) {
            String notAnInt = key.nextLine();
            System.out.println(notAnInt + " is not an integer.");
            System.out.print(players[user] + ", enter the column number to drop your checker: ");
        }
        int result = key.nextInt();
        key.nextLine();
        return result;
    }

    //This method checks if the players choices of column is a "valid column."
    //The players must enter a valid number (an int from 1 to 7).
    public static int checkSize(Scanner key, int column, String[] players, int user){
        while(column > 7 || column == 0){
            System.out.println(column + " is not a valid column.");
            System.out.print(players[user] + ", enter the column to drop your checker: ");
            int temp = getInt(key, players, user);
            column = checkSize(key,temp, players, user);
        }
        return column;
    }

    //This method creates the Connect 4 board game.
    //A point will appear on each position of the board.
    public static char[][] makeBoard() {
        char[][] board = new char[6][7];
        for(int r = 0; r < 6; r++) {
            for(int c = 0; c < 7; c++) {
                board[r][c] = '.';
            }           
        }
        return board;
    }

    //This method updates the board game after each player choices their column they'd like to place thier chip.
    //Each point will be replaced by "r" or "b".
    public static char[][] updateBoard(int validColumn, char[][] board, char[] chips, int user, String[] players){
        int count = 1;
        validColumn = validColumn - 1;
        boolean empty = true;
        for(int r = 5; r >= 0; r--) {
            if(count == 1){
                if(board[r][validColumn] == '.'){
                    board[r][validColumn] = chips[user]; 
                    checkWin(board, chips, user, r, validColumn, players);
                    count++;
                } else if(board[r][validColumn] != '.' ){
                    empty = true;
                }
            }
        }
        return board;
    }

    //This method checks when one of the players win the game.
    public static boolean checkWin(char[][] board, char[] chips, int user, int r, int validColumn, String[] players) {
        boolean win = checkGame(board, players);
        if(win){
            return true;
        }
        return false;
    }

    //This method checks four different ways the players can win.
    //Directions: SouthWest, South, SouthEast, East.
    public static boolean checkGame(char[][] board, String[] players){
        //Horizontal
        for (int y = 0; y < board.length; y++){
            int x = 0;
            while(board[y][x] != '.' && x < board[y].length - 3){
                if(board[y][x] == board[y][x+1] && board[y][x] == board[y][x+2] && board[y][x] == board[y][x+3]){ //detects horizontally, same row, column per column.
                    if(board[y][x] == 'r'){
                        System.out.print(players[0] + " wins!!! ");
                        return true;
                    } else if(board[y][x] == 'b'){
                        System.out.print(players[1]+ " wins!!! ");
                        return true;
                    }
                }
                x++;
            }
        }
        //Vertical
        for (int x = 0; x < board[0].length; x++){
            int y = board.length - 1;
            while(board[y][x] != '.' && y > 2){
                if(board[y][x] == board[y-1][x] && board[y-2][x] == board[y][x] && board[y][x] == board[y-3][x]){ //detects vertically, same column, row per row.
                    if(board[y][x] == 'r'){
                        System.out.print(players[0] + " wins!!! ");
                    } else System.out.print(players[1]+ " wins!!! ");
                    return true;
                }
                y--;
            }
        }
        //SouthEast
        for (int x = 0; x < board[0].length-3; x++){
            int y = board.length - 1;
            while(board[y][x] != '.' && y > 2){
                if(board[y][x] == board[y-1][x+1] && board[y-2][x+2] == board[y][x] && board[y][x] == board[y-3][x+3]){ //Down and to the right
                    if(board[y][x] == 'r'){
                        System.out.print(players[0] + " wins!!! ");
                    } else System.out.print(players[1]+ " wins!!! ");
                    return true;
                }
                y--;
            }
        }
        //SouthWest
        for (int x = board[0].length - 1; x > 3; x--){
            int y = board.length - 1;
            while(board[y][x] != '.' && y > 2){
                if(board[y][x] == board[y-1][x-1] && board[y-2][x-2] == board[y][x] && board[y][x] == board[y-3][x-3]){ //Down and to the left
                    if(board[y][x] == 'r'){
                        System.out.print(players[0] + " wins!!! ");
                    } else System.out.print(players[1]+ " wins!!! ");
                    return true;
                }
                y--;
            }
        }
        return false;
    }

    //This method prints out the board with "." on each position (current board and final board).
    //The board consists of 6 rows and 7 columns per row.
    //This method also checks if the game ended up a draw.
    public static boolean printBoard(char[][] board, String[] players) { 
        boolean win = checkGame(board, players);
        if(win){
            System.out.println("\n\nFinal Board");
        }
        else if (!win){
            int r = 0;
            int count = 7;
            for(int c = 0; c < 7; c++) {
                if(board[r][c] != '.'){
                    count--;
                } 
            }
            if(count == 0){
                System.out.println("This game is a draw.\n\nFinal Board");
                win = true;
            }
            else{
                System.out.println("\nCurrent Board");
            }
        }
        System.out.println("1 2 3 4 5 6 7 column numbers");
        for(int r = 0; r < 6; r++) {
            for(int c = 0; c < 7; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
        System.out.println();
        if(win){
            return true;
        }
        return false;
    }

    //This method gets the name of Player 1 and Player 2.
    public static String[] getPlayers(){
        String[] players = new String[2]; 
        Scanner key = new Scanner(System.in);
        System.out.print("Player 1 enter your name: ");
        players[0] = key.nextLine();
        System.out.print("Player 2 enter your name: " );
        players[1] = key.nextLine();  
        return players;
    }

    //This method recognizes when the game is not over yet.
    //This method gives the certain chip (red or black) to the certain player.
    public static void play(String[] players, char[][] board){
        Scanner key = new Scanner(System.in);
        boolean gameOver = false;
        int user = 0;
        char[] chips = new char[2];
        chips[0] = 'r'; 
        chips[1] = 'b';
        while(!gameOver){
            System.out.println(players[user] + " it is your turn.");
            System.out.println("Your pieces are the " + chips[user] + "'s.");
            System.out.print(players[user]+ ", enter the column to drop your checker: ");
            int column = getInt(key, players, user);
            int validColumn = checkSize(key, column, players, user);
            char[][] board2 = updateBoard(validColumn, board, chips, user, players);
            gameOver = printBoard(board2, players);
            user++;
            if(user == 2){
                user = 0;
            }
        }
    }
}