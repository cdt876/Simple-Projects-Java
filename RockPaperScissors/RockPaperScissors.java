import java.util.Scanner; // for Scanner
import java.util.*;
/**
 * @author  Carlos Trejo
 * @version 2/22/13
 * CS312 Assignment 4.
 *
 * On my honor, Carlos Trejo, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 *
 * A program to allow a human player to play rock - paper - scissors
 * against the computer.
 *
 *  email address: cdtrejo@utexas.edu
 *  UTEID: cdt876
 *  Section 5 digit ID: 53255
 *  Grader name: Rebecca
 *  Number of slip days used on this assignment: 0
 */
public class RockPaperScissors {
    public static final int ROCK = 1;
    public static final int PAPER = 2;
    public static final int SCISSORS = 3;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Game(console, Presentation(console), Rounds(console));
    } // end main

    //This method called Presentation prints out the Introduction to the game.
    public static String Presentation(Scanner console) {
        System.out.println("Welcome to Rock Paper Scissors. I, the computer, will be your opponent.");
        System.out.print("Please type in your name and press return: ");
        String name = console.nextLine();
        System.out.println("\nWelcome " + name + ".");
        System.out.print("All right " + name + ". How many games would you like to play?\n");
        return name;                
    }

    //This method called Rounds, allows the user to enter the number of rounds they would like to play.
    public static int Rounds(Scanner console) {
        System.out.print("Enter the number of rounds you want to play and press return: ");
        int NumberOfRounds = console.nextInt();
        return NumberOfRounds;
    }

    //TIME TO PLAY THE GAME!
    public static void Game(Scanner console, String name, int rounds){
        //Victory and Draw Counters
        int draw = 0;
        int user = 0;
        int cpu = 0;
        for(int i = 1; i <= rounds; i++){   
            System.out.println("\n\nRound " +i+ ".\n" + name + ", please enter your choice for this round.");
            System.out.print("1 for rock, 2 for paper, and 3 for scissors: ");
            int choice = console.nextInt();
            //This will convert any number greater than 3 into valid input
            if (choice > 3) {
                choice = choice % 3;
                if (choice == 0)  //If the resultant is 0, the number is a multiple of 3, thus the value should be 3
                    choice = SCISSORS;
            }   
            //This is for the computer to choose between 1 and 3 randomnly.
            Random random = new Random();
            int computerChoice = random.nextInt(3)+1;  //Add one since it will take values from 0 to 2
            //WinTrack is assigned a value of 1, 2, or 3 returned by winner method
            int winTrack = winner (ROCK,  PAPER, SCISSORS, choice , computerChoice, name);  
            //This if block will help me count how many victories and draws
            if(winTrack == 0)
                draw++;
            if(winTrack == 1)
                user++;
            if(winTrack == 2)
                cpu++;
        }
        Results(name, rounds, draw, cpu, user);
    }

    public static int winner(int ROCK, int PAPER, int SCISSORS, int choice, int computerChoice, String name){
        System.out.println("Computer picked " + compChoice(ROCK, PAPER, SCISSORS, computerChoice) + ", "+ name+ " picked " + usrChoice( ROCK, PAPER, SCISSORS, choice) + ".\n");
        //This print statement calls 2 methods: compChoice and usrChoice to display choice of weapons
        int winCounter = 0;     //This variable will help me determine who wins the round
        //0 means DRAW, 1 means USER WON, 2 means COMPUTER WON

        //The following if blocks print the result of the round 
        if (computerChoice == choice){
            System.out.println("This round is a draw.");
            winCounter = 0;
        }

        if (computerChoice == PAPER){
            if (choice == ROCK){
                System.out.println("Paper covers rock. I win.");
                winCounter = 2;
            }
            if (choice == SCISSORS){
                System.out.println("Scissors cut paper. You win.");
                winCounter = 1;
            } 
        }                        

        if (computerChoice == ROCK){
            if (choice == PAPER){
                System.out.println("Paper covers rock. You win.");
                winCounter = 1;
            }     
            if (choice == SCISSORS){
                System.out.println("Rock breaks scissors. I win.");
                winCounter = 2;
            }
        }

        if (computerChoice == SCISSORS){
            if (choice == PAPER){
                System.out.println("Scissors cut paper. I win.");
                winCounter = 2;
            }
            if (choice == ROCK){
                System.out.println("Rock breaks scissors. You win.");
                winCounter = 1;
            }
        }
        return winCounter; //This value is then processed in the method called game
    }

    //This method will transform the cpu's input into its representative string value 
    public static String compChoice(int ROCK, int PAPER, int SCISSORS, int computerChoice){
        String choice = ""; //Variable to store the appropriate string to be returned
        if (computerChoice == 1)
            choice = "Rock";
        else if (computerChoice == 2)
            choice = "Paper";
        else if (computerChoice == 3)
            choice = "Scissors";
        return choice;
    }

    //This method will transform the user input into its representative string value  
    public static String usrChoice(int ROCK, int PAPER, int SCISSORS, int choice){
        String usrChoice = ""; //Variable to store the appropriate string to be returned
        if (choice == 1)
            usrChoice = "Rock";
        else if (choice == 2)
            usrChoice = "Paper";
        else if (choice == 3)
            usrChoice = "Scissors";
        return usrChoice; 
    }

    //Method to print Results
    public static void Results(String name, int rounds, int draw, int cpu, int user){
        System.out.println("\n\nWe played " + rounds + " games of Rock Paper Scissors.\nThe computer won " + cpu + " times.");
        System.out.println( name + " won " + user + " times.\nThere were " + draw + " draws.");
        //This if block will print the appropriate result based on the number of wins.
        if (cpu < user)
            System.out.println("You are a master at Rock, Paper, Scissors.");
        if (cpu > user)
            System.out.println("I am a master at Rock,Paper,Scissors.");
        if (cpu == user)
            System.out.println("We are evenly matched at this game.");    
    }
} //end class