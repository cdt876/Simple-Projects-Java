/**
 * @author  Carlos Trejo
 * @version 3/8/13
 * CS312 Assignment 6.
 *
 * On my honor, Carlos Trejo, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 *
 * A program to allow a human player to play Hangman
 * against the computer.
 *
 *  email address: cdtrejo@utexas.edu
 *  UTEID: cdt876
 *  Section 5 digit ID: 53255
 *  Grader name: Rebecca
 *  Number of slip days used on this assignment: 2
 */

import java.util.Scanner;

public class Hangman
{
    public static void main(String[] args)
    {
        PhraseBank phrases = new PhraseBank(); //PhraseBank: Contains all phrases
        Scanner keyboard = new Scanner(System.in); 
        boolean playAgain = true;
        game(playAgain, phrases, keyboard);

    }

    public static void game( boolean playAgain, PhraseBank phrases, Scanner keyboard){
        intro(); // Introduction Method
        while(playAgain){ // While playAgain is true. Game continues.
            int wrongGuesses = 0;
            int correctGuesses = 0;
            boolean play = true;
            boolean check = true;

            String phrase = getTopic(keyboard, phrases); //Prints topic and returns phrase to be guessed
            String letters = getLetters();  //Makes a string of all the letters in alphabet

            String toGuess = hidePhrase(phrase); // Hides phrase with asterisks 
            currentPhrase(toGuess, letters); 

            while(wrongGuesses < 5 && play) // While wrongGuesses is less than 5 and play is true. Game continues
            {
                String guess = getGuess(keyboard); // User guess
                char guess2 = guess.charAt(0);
                check = checkBody(letters, guess2);
                letters = alphabet(letters, guess2, 0);
                System.out.println();
                toGuess = updateToGuess(toGuess, guess, phrase);

                if(phrase.indexOf(guess) >= 0){ // if the letter guessed by user is within the phrase (higher or equal to 0) then it is correct.
                    letterInPhrase(check, wrongGuesses, correctGuesses, guess2, toGuess, guess, phrase, letters);
                }
                else { // else. it is a wrong guess
                    wrongGuesses = notInPhrase(check, wrongGuesses,  toGuess,  letters,  guess2);
                }

                play = checkAllGuessed(play, toGuess, phrase);
                checkNumGuesses(wrongGuesses, phrase);
            }

            playAgain = playAgain(keyboard, playAgain);

        }

    }

    // Method that shows the introduction to the program
    public static void intro()
    {
        System.out.println("This program plays the game of hangman.");
        System.out.println("When the window opens, select the file");
        System.out.println("with the phrases you want to use.\n");
        System.out.println("The computer will pick a random phrase.");
        System.out.println("Enter capital letters as your guesses.");
        System.out.println("After 5 wrong guesses you lose.");
    }

    public static String alphabet(String letters, char temp, int ap){ // Alphabet: spaces between letters.

        for (int j = 0; j < letters.length(); j++)
        {
            if(letters.charAt(j) == temp) {
                String sub1 = letters.substring(0, j);
                sub1.trim();
                String sub2 = letters.substring(j + 1);
                sub2.trim();
                letters = sub1 + sub2;
                letters = letters.trim();
                letters = letters.replaceAll("\\s+","");
            }
        }

        String body = "";
        if(ap == 1){  //ap is an access parameter.
            body = letters;
            String temp1 ="";
            body = body.replaceAll("\\s+","");
            for(int i=0; i < body.length(); i++){
                temp1 += body.charAt(i);
                temp1 += " ";
            }
            System.out.println(temp1);
        }

        for(int i=0; i < letters.length(); i++){
            body += letters.charAt(i);
            body += " ";
        }

        if(ap == 2){ //ap is an access parameter.
            body = letters;
            String temp2 = "";
            body = body.replaceAll("\\s+","");
            for(int i=0; i < body.length(); i++){
                temp2 += body.charAt(i);
                temp2 += " ";
            }
            System.out.println(temp2);
        }
        return body; // returns body.
    }

    public static boolean checkBody(String body, char guess2){ // This method tests if the letter guessed by user is within the phrase. Returns test.
        boolean test = false;
        for(int i=0; i < body.length(); i++){
            if(body.charAt(i) == guess2){
                test = true;
            } 
        }
        return test;
    }

    public static String getTopic(Scanner keyboard, PhraseBank phrases){ // Gets topic from phrasebank. Returns phrase.
        String topic = phrases.getTopic();
        System.out.println("I am thinking about " + topic); 
        String phrase = phrases.getNextPhrase();
        return phrase;
    }

    public static String getLetters(){ // Returns the letters of the alphabet from "A to Z".
        String letters = "";
        for(int i = 65; i < 91; i++){
            letters += (char)(i)+ " ";
        }
        return letters;
    }

    public static String hidePhrase(String phrase){ // This method hides the phrase with asterisks. Returns toGuess.
        String toGuess = "";
        for (int i = 0; i < phrase.length(); i++)
        {
            char temp = phrase.charAt(i);
            if (temp != '_'){
                toGuess += "*";   }

            else { toGuess += '_'; }
        }
        return toGuess;
    }

    public static void currentPhrase(String toGuess, String letters){ // Prints letters.
        System.out.println();
        System.out.println("The current phrase is " + toGuess);
        System.out.println("The letters you have not guessed yet are:");
        System.out.println(letters);
    }

    public static boolean playAgain(Scanner keyboard, boolean playAgain){ // This method asks the user to play again. Returns playAgain (either keep playing or not).
        System.out.println("Do you want to play again?");
        System.out.print("Enter 'Y' or 'y' to play again: ");
        String respond = keyboard.next(); // User's respond. If he/she wants to play again.
        respond = respond.toLowerCase();
        char response = respond.charAt(0);
        System.out.println();
        if(response != 'y'){ // if response is not "y". Play again is false, thus game is over.
            playAgain = false;
        }
        return playAgain;
    }

    public static void checkNumGuesses(int wrongGuesses, String phrase){ // This method checks the number of wrong guesses.
        if( wrongGuesses == 5){ // if wrongGuesses is equal to 5, then the user loses the game. 
            System.out.println();
            System.out.println("You lose. The secret phrase was " + phrase);
            System.out.println();
        }
    }

    public static boolean checkAllGuessed(boolean play, String toGuess, String phrase){ // This method lets you know either the user has won the game or the game still continues. 
        if(!toGuess.contains("*")){ // if the phrase does not contain an asterisk. Play is false, therefore the user wins the game. 
            play = false ;
            System.out.println();
            System.out.println("The phrase is " + phrase);
            System.out.println("YOU WIN!!!");
            System.out.println();
        }
        else play = true; // else. game continues because play is true.

        return play; // Returns play.
    }

    public static String updateToGuess(String toGuess, String guess, String phrase){ // This method allows the phrase to keep updating throughout the game. Returns toGuess.
        for (int j = 0; j < toGuess.length(); j++){ 
            char charToReplace = guess.charAt(0);
            if(phrase.charAt(j) == charToReplace) {
                String sub1 = toGuess.substring(0, j);
                String sub2 = toGuess.substring(j + 1);
                toGuess = sub1 + charToReplace + sub2;
            }
        }
        return toGuess;     
    }
    // This method lets you know if the user guess was either correct or invalid,
    public static void letterInPhrase(boolean check, int wrongGuesses, int correctGuesses, char guess2, String toGuess, String guess, String phrase, String letters){ 
        if(check == true){ // if check is true, then the user guess is correct.
            System.out.println("That is present in the secret phrase.");
            System.out.println("You have made " + wrongGuesses + " wrong guesses.");
            System.out.println();
            correctGuesses++;
            toGuess = updateToGuess(toGuess, guess, phrase);
            System.out.println("The current phrase is " + toGuess);
            letterNotGuessed(letters, guess2); }
        else if(check == false){ // else. the user guess is invalid.
            System.out.println(guess2 + " is not a valid guess.");
            System.out.println("The letters you have not guessed yet are:"); 
            alphabet(letters, guess2, 2); 
        }
    }

    public static int notInPhrase(boolean check, int wrongGuesses, String toGuess, String letters, char guess2){ // returns wrongGuesses (either wrong or invalid).
        if(check == true){ // if check is true, then the user guess is wrong
            System.out.println("That is not present in the secret phrase.");
            wrongGuesses += 1;
            System.out.println("You have made " + wrongGuesses + " wrong guesses");
            System.out.println();
            System.out.println("The current phrase is  " + toGuess);
            System.out.println("The letters you have not guessed yet are:"); 
            alphabet(letters, guess2, 1);
        }   else { // else. the user guess is invalid.
            System.out.println(guess2 + " is not a valid guess.");
            System.out.println("The letters you have not guessed yet are:"); 
            alphabet(letters, guess2, 2);
        }
        return wrongGuesses;
    }

    public static String getGuess(Scanner keyboard){ // This method returns the user guess.
        System.out.print("Enter your next guess: ");
        String guess = keyboard.next();
        System.out.println("You guessed " + guess + ".");
        return guess;
    }

    public static void letterNotGuessed(String letters, char guess2){ // Prints letters not guessed yet.
        System.out.println("The letters you have not guessed yet are:");
        alphabet(letters, guess2, 1);}
}