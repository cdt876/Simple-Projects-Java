

import java.util.Scanner;

public class Ciphers {
	
	// The maximum number of rows 
	public static final int MAX_ROWS = 6; 

    // Main method to demonstrate various encryptions and
    // decryptions using a columnar transposition cipher
     public static void main(String[] args) {
    	 Scanner keyboard = new Scanner(System.in);
         showIntro();
         doEncryptions(keyboard);
         doDecryptions(keyboard);
         showTests();
     }

     // Show the introduction to the program
     public static void showIntro() {
         System.out.println("This program demonstrates a transposition cipher.");
         System.out.println("A cipher is an algorithm to encrypt or decrypt a message.");
         System.out.println();
         System.out.println("This program will demonstrate encrypting a message with");
         System.out.println("a columnar transposition cipher both with and without");
         System.out.println("padding characters. The program will then decrypt a message");
         System.out.println("assuming it was encrypted with a columnar transposition cipher");
         System.out.println("with padding.");
         System.out.println();
         System.out.println("After accepting user input, the program displays some tests.");
         System.out.println();
         System.out.println();
     }

     // Do various encryptions both padded with Xs and not padded
     public static void doEncryptions(Scanner keyboard) {
    	 System.out.println("A demonstration of encrypting with a columnar transposition cipher:");
    	 System.out.println();
    	 System.out.print("Enter the message to encrypt: "); // Prompt the user to enter the message
    	 String userMessage = keyboard.nextLine();
    	 System.out.println();
    	 printUnpaddedEncryptions(userMessage);
    	 printPaddedEncryptions(userMessage);
     }
     
     // Print all the unpadded encryptions 
     public static void printUnpaddedEncryptions(String userMessage) {
    	 System.out.println("Message encrypted with columnar transposition cipher and no padding.");
    	 for(int numRows = 2; numRows <= MAX_ROWS; numRows++) {
    		 System.out.print("Encrypted with " + numRows + " rows: ");
			 String unpaddedEncryption = encryptMessage(userMessage, numRows);
    		 System.out.println(unpaddedEncryption);
    	 }
    	 System.out.println();
     }
       
     // Print all the padded encryptions
     public static void printPaddedEncryptions(String userMessage) {
    	 System.out.println("Message encrypted with columnar transposition cipher and padding.");
    	 System.out.println();
    	 for(int numRows = 2; numRows <= MAX_ROWS; numRows++) {
    		 System.out.print("Clear text padded for " + numRows + " rows: ");
    		 System.out.println(paddedMessage(userMessage, numRows));
    		 String paddedEncryption = encryptMessage(paddedMessage(userMessage, numRows), numRows);
    		 System.out.print("Encrypted with " + numRows + " rows: ");
    		 System.out.println(paddedEncryption);
			 System.out.println();
    	 }
    	 System.out.println();
     }
     
     // Return an encrypted message depending on its respective number of rows
     public static String encryptMessage(String userMessage, int numRows) {
    	 String result = "";
		 for(int row = 0; row < numRows; row++) {
			 for(int col = 0; col < numCols(userMessage, numRows); col++) {
				 result += printCharEncrypted(userMessage, row, numRows, col);
			 }
		 }
		 return result;
     }
     
     // Do the decryptions with the of messages for
     // various values of the number of rows
     public static void doDecryptions(Scanner keyboard) {
    	 System.out.println("A demonstration of decrypting with a columnar transposition cipher:");
    	 System.out.println("If the length of the message is not a multiple of the number of rows");
    	 System.out.println("it will be padded which may throw off the decryption.");
    	 System.out.println();
    	 System.out.print("Enter the message to decrypt: ");
    	 String encryptedMessage = keyboard.nextLine();
    	 System.out.println();
    	 printPaddedDecryptions(encryptedMessage);
     }

     // Print all the padded decryptions
     public static void printPaddedDecryptions(String encryptedMessage) {
    	 System.out.println("Messages Decrypted with a Columnar Transposition Cipher");
    	 System.out.println();
    	 for(int numRows = 2; numRows <= MAX_ROWS; numRows++) {
    		 String paddedEncryption = paddedMessage(encryptedMessage, numRows);
    		 System.out.print("Decrypted text padded for " + numRows + " rows: ");
    		 System.out.println(paddedEncryption);
    		 String paddedDecryption = decryptMessage(paddedEncryption, numRows);
    		 System.out.print("Decrypted with " + numRows + " rows: ");
    		 System.out.println(paddedDecryption);
			 System.out.println();
    	 }
     }
     
     // Return a decrypted message depending on its respective number of rows
     public static String decryptMessage(String encryptedMessage, int numRows) {
    	 String result = "";
		 for(int col = 0; col < numCols(encryptedMessage, numRows); col++) {
			 for(int row = 0; row < numRows; row++) {
				 result += printCharDecrypted(encryptedMessage, col, 
						 numCols(encryptedMessage, numRows), row);
			 }
		 }
		 return result;
     }
     
     // Return the user's message with X's padded characters
     public static String paddedMessage(String userMessage, int numRows) {
    	 int charsNeeded = numCols(userMessage, numRows) * numRows;
    	 int numCharsForPadding = charsNeeded - userMessage.length();
    	 String paddedMessage = userMessage;
    	 for(int paddingChar = 1; paddingChar <= numCharsForPadding; paddingChar++) {
    		 paddedMessage += "X";
    	 }
    	 return paddedMessage;
     }
     
     // Return a character of the encryption
     public static String printCharEncrypted(String message, int row, int numRows, int col) {
		 String result = "";
		 int numChar = row + numRows*col;
		 if(numChar >= message.length()){
			 return result;
		 } else { // numChar < message.length()
			 return result += message.charAt(numChar);
		 }
     }

     // Return a character of the decryption
     public static String printCharDecrypted(String message, int col, int numCols, int row) {
    	 String result = "";
    	 int numChar = col + numCols*row;
		 return result += message.charAt(numChar);
     }
     
     // Calculates the number of columns
     public static int numCols(String userMessage, int numRows) {
    	 int numCols = userMessage.length() / numRows + Math.min(1, userMessage.length() % numRows);
    	 return numCols;
     }
     
     // Show tests of the methods
     public static void showTests() {
         System.out.println("This displays automatic tests of the program: ");
         // Encrypted tests
         String encryptedMessage = "AEIBFJCGXDHX";
         String expected = "ABCDEFGHIJXX";
         decryptTest(encryptedMessage, expected, 4, 1);  //last 2 int parameters are rows, then test number

         encryptedMessage = "CPEOURMT!";
         expected = "COMPUTER!";
         decryptTest(encryptedMessage, expected, 3, 2);

         encryptedMessage = "VAPCI_EIVINAAND!_DE!LEN!";
         expected = "VIVA_LA_INDEPENDENCIA!!!";
         decryptTest(encryptedMessage, expected, 6, 3);
         
         encryptedMessage = "Lnseog_rseLs_laXAekX";
         expected = "Los_Angeles_LakersXX";
         decryptTest(encryptedMessage, expected, 5, 4);

         // Decrypted tests
         String clearMessage = "Dell_CS_HallXXX";
         expected = "DCleSll_XlHX_aX";
         encryptTest(clearMessage, expected, 5, 1);

         clearMessage = "Texas_LonghornsX";
         expected = "Tsnre_gnxLhsaooX";
         encryptTest(clearMessage, expected, 4, 2);

         clearMessage = "To_Be_or_Not_to_Be";
         expected = "To_ort__oBN_eoB_te";
         encryptTest(clearMessage, expected, 6, 3);
         
         clearMessage = "LUIS_BEST_TA_AT_UT!!!";
         expected = "LSE___!U_STAU!IBTATT!";
         encryptTest(clearMessage, expected, 3, 4);
     }

     // This methods tests if a encrypted message is decrypted
     public static void decryptTest(String encryptedMessage,
             String expected, int rows, int testNumber) {
         System.out.println();
         String actual = decryptMessage(encryptedMessage, rows);
         System.out.println("expected: " + expected + ", actual: " + actual);
         if(expected.equals(actual))
             System.out.println("passed decrypt test" + testNumber);
         else
             System.out.println("FAILED DECRYPT TEST " + testNumber);
     }

     // This method tests if a clear message is encrypted 
     public static void encryptTest(String clearMessage,
             String expected, int rows, int testNumber) {
         System.out.println();
         String actual = encryptMessage(clearMessage, rows);
         System.out.println("expected: " + expected + ", actual: " + actual);
         if(expected.equals(actual))
             System.out.println("passed encrypt test" + testNumber);
         else
             System.out.println("FAILED ENCRYPT TEST " + testNumber);
     }
} //End of class