//import javax.swing.JFileChooser;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

/**
 * @authors: Student 1: Erick Cardenas
 *			 Student 2: Carlos Trejo
 * CS312 Assignment 7.
 *
 *  On our honor, Erick and Carlos, this programming assignment is our own work
 *  and we have not provided this code to any other student.
 *
 *
 * A program convert personality survey results to
 * personality types.
 *
 * Student 1: Erick Cardenas
 *  email address: ecardenas@utexas.edu
 *  UTEID: erc848
 *  Section 5 digit ID: 53245
 *  Grader name: Luis
 *  Number of slip days used on this assignment: 0
 *
 * Student 2: Carlos Trejo
 *  email address: cdtrejo@utexas.edu
 * Section 5 digit ID: cdt876
 *  UTEID: 53255
 */

public class Personality {
	
	// Execute a program that converts personality survey results to
	// personality types, basing on an input file of a personality test
	public static void main (String[] args) throws FileNotFoundException {
		// Create a scanner that reads an input file of a personality test 
		Scanner fileScanner = new Scanner (new File("smallPersonality.txt"));
		int numOfRecords = fileScanner.nextInt();
		processRecords(numOfRecords, fileScanner);
	}
	
	// Process the input file that contains a series of line pairs, one pair per person:
	// The first line is composed by the name of the person
	// The second line is composed by the answers of the person
	public static void processRecords (int numOfRecords, Scanner fileScanner) {
		fileScanner.nextLine(); // To move cursor to next line
		for (int i = 1; i <= numOfRecords; i++) {
			String name = fileScanner.nextLine();
			// Convert the line of answers into an array of characters
			char[] letters = fileScanner.nextLine().toCharArray();
			printRecord(name, letters);
		}
	}
	
	// Print the personality record for each person,
	// First the name, secondly the percentages of B answers in each dimension, 
	// and finally the personality type
	public static void printRecord (String name, char[] letters) {
		// Array of percentages of B answers for each dimension
		int[] percentages = {percentOfEvsI(letters), percentOfSvsN(letters),
									percentOfTvsF(letters), percentOfJvsP(letters)};
		String personalityType = getPersonalityType(percentages);
		System.out.println(name + ": " + Arrays.toString(percentages) + " = " + personalityType);
	}
	
	// Return the percentage of B answers for the Extrovert / Introvert dimension
	public static int percentOfEvsI (char[] letters) {
		char[] answersOfEvsI = new char[10]; // Array of answers corresponding to EvsI dimension
		for(int i = 0; i < answersOfEvsI.length; i++) {
			answersOfEvsI[i] = letters[7*i];
		}
		return getPercentageOfB(answersOfEvsI);
	}
	
	// Return the percentage of B answers for the Sensing / Intuition dimension
	public static int percentOfSvsN(char[] letters) {
		char[] answersOfSvsN = new char[20]; // Array of answers corresponding to SvsN dimension
		int initial = 1;
		answersOfSvsN[0] = letters[initial];
		getAnswersOfTheGroup(initial, answersOfSvsN, letters);
		return getPercentageOfB(answersOfSvsN);
	}
	
	// Return the percentage of B answers for the Sensation / iNtuition dimension
	public static int percentOfTvsF(char[] letters) {
		char[] answersOfTvsF = new char[20]; // Array of answers corresponding to TvsF dimension
		int initial = 3;
		answersOfTvsF[0] = letters[initial];
		getAnswersOfTheGroup(initial, answersOfTvsF, letters);
		return getPercentageOfB(answersOfTvsF);
	}
	
	// Return the percentage of B answers for the Judging / Perceiving dimension
	public static int percentOfJvsP(char[] letters) {
		char[] answersOfJvsP = new char[20]; // Array of answers corresponding to JvsP dimension
		int initial = 5;
		answersOfJvsP[0] = letters[initial];
		getAnswersOfTheGroup(initial, answersOfJvsP, letters);
		return getPercentageOfB(answersOfJvsP);
	}
	
	// Each dimension has its corresponding pattern in the personality test
	// This method chooses the specific questions that corresponds to a particular dimension
	public static void getAnswersOfTheGroup(int index, char[] answers, char[] letters) {
		for(int i = 1; i < answers.length; i++) {
			index += Math.pow(6, (i - 1) % 2);
			answers[i] = letters[index];
		}
	}
	
	// Return the percent of B answers the user gave for that dimension 
	public static int getPercentageOfB (char[] answers) {
		int a = 0;
		int b = 0;
		for(int i = 0; i < answers.length; i++) {
			if(answers[i] == 'A') {
				a++;
			} else if(answers[i] == 'B') {
				b++;
			}
		}
		double percentage = b * 100.0 / (a + b);
		int percent = (int) ( percentage + 0.5);
		return percent;
	}
	
	// Return a string of letters that forms the personality type
	public static String getPersonalityType(int[] percentages) {
		String result = "";
		String[] types = {"EI", "SN", "TF", "JP"}; // Array of four independent dimensions of personality
		// Put together the corresponding sides to form a personality type
		for(int i = 0; i < 4; i++) { 
			result += getDimension(percentages[i], types[i]);
		}
		return result;
	}
	
	// Depending on the percentage, this method returns 
	// the character of the corresponding side of the dimension
	public static char getDimension(int percent, String dimensions) {
		if(percent > 50) { // Person is in the second side of the dimension
			return dimensions.charAt(1);
		} else if(percent == 50) { // Person is in the middle for this particular dimension
			return 'X';
		} else // It must be less than 50, so person is in the first side of the dimension
			return dimensions.charAt(0);
	}
}