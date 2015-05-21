/**
 * CS312 Assignment 8
 * On my honor, Carlos, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * Program to decrypt a message that has been
 * encrypted with a substitution cipher.
 * We assume only charcaters with ASCII codes
 * from 32 to 126 inclusive have been encrypted.
 *
 *  email address: cdtrejo@utexas.edu
 *  UTEID: cdt876
 *  Section 5 digit ID: 53255
 *  Grader name: Rebecca
 *  Number of slip days used on this assignment: 1
 *
 * Number of slip days I am using: 1
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

public class Decrypt {

    public static void main(String[] arg)  throws FileNotFoundException {
        String encryptedText = DecryptUtilities.convertFileToString();
        Scanner console = new Scanner(System.in);
        Scanner fileScanner = new Scanner (new File("encryptedShortText.txt"));
        showEncryptedText(encryptedText); 
        int[] freqs = new int[128];
        freqs = getFrequenciesOfCharacters(encryptedText);
        printFrequencies(freqs);
        char[] key = getDecryptedText(freqs);
        String DecryptedText = decryptText(encryptedText,key);
        boolean keepPlaying = true;
        userManage(console, key, DecryptedText, keepPlaying, freqs);
    }

    public static void showEncryptedText(String encryptedText) {
        System.out.println("The encrypted text is:");
        System.out.println();
        System.out.println(encryptedText);
    }

    public static int[] getFrequenciesOfCharacters(String encryptedText) {
        int[] freq = new int[128];
        for (int i = 0; i < 128; i++){
            freq[i] = 0;
        }
        for (int i = 0 ; i < encryptedText.length(); i++){
            freq[(int)encryptedText.charAt(i)]++;
        }
        return freq;
    } 

    public static void printFrequencies(int[] freqs) {
        System.out.println("Frequencies of characters.");
        System.out.println("Character - Frequency");
        for (int i = 32; i < 127 ; i++){
            System.out.println((char)i + " - " + freqs[i]);
        }
    }

    public static char[] getDecryptedText(int[] freqs) {
        char[] initial_key = DecryptUtilities.getDecryptionKey(freqs);
        System.out.println("\nThe current version of the key for ASCII characters 32 to 126 is:");
        for (int i = 32; i < 127 ; i++){
            System.out.println("Encrypted character: " + (char)i + ", decrypted character: " + initial_key[i]);
        }
        return initial_key;
    }

    public static String decryptText(String text, char[] key){
        System.out.println("\nThe current version of the decrypted text is:");
        System.out.println();
        String decrypted = "";
        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) != '\n') {
                System.out.print(key[(int)text.charAt(i)]);
                decrypted += key[(int)text.charAt(i)];
            }
            else {
                System.out.println();
                decrypted += '\n';
            }
        }
        return decrypted;
    }

    public static void userManage(Scanner console, char[] key, String enc, boolean keepPlaying, int[] freqs) {
        System.out.println("\nDo you want to make a change to the key?");
        System.out.print("Enter 'Y' or 'y' to make change: ");
        String userAnswer = console.next();
        while(userAnswer.charAt(0) == 'y' || userAnswer.charAt(0) == 'Y') {
            System.out.print("Enter the decrypt character you want to change: ");
            String decryptCharacterToChange = console.next();
            System.out.print("Enter what the character " + decryptCharacterToChange + " should decrypt to instead: ");
            String newDecryptCharacter = console.next();
            System.out.println(decryptCharacterToChange + "'s will now decrypt to " + newDecryptCharacter + "'s and vice versa.");
            System.out.println();
            System.out.println("The current version of the decrypted text is:\n");
            String tmp = "";
            for(int i = 0; i < enc.length(); i++){
                if(enc.charAt(i) == decryptCharacterToChange.charAt(0)) {
                    System.out.print(newDecryptCharacter.charAt(0));
                    tmp += newDecryptCharacter.charAt(0);
                }
                else if(enc.charAt(i) == newDecryptCharacter.charAt(0)) {
                    System.out.print(decryptCharacterToChange.charAt(0));
                    tmp += decryptCharacterToChange.charAt(0);
                }
                else {
                    System.out.print(enc.charAt(i));
                    tmp += enc.charAt(i);
                }
            }
            enc = tmp;
            System.out.println("\nDo you want to make a change to the key?");
            System.out.print("Enter 'Y' or 'y' to make change: ");
            userAnswer = console.next();

        }
        getDecryptedText(freqs);
    }
}