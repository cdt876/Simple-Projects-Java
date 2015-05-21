/**
 * CS312 Assignment 1.
 * On my honor, Carlos Trejo, this programming assignment is my own work.
 * Section Number: 53255
 *
 * A program to print out the lyrics to the
 * children's song, "There was an old woman".
 *
 *  Name: Carlos Trejo
 *  email address: cdtrejo@utexas.edu
 *  UTEID: cdt876
 *  Section 5 digit ID: 53255
 *  Grader name: Rebecca
 *  Number of slip days used on this assignment: 0
 */


public class Song {
    public static void main(String[] args) {
        //Declaring a method for each verse in the song. 
        verse1();
        verse2();
        verse3();
        verse4();
        verse5();
        verse6();
        verse7();
        verse8();
               
    }
    
    
    //Declaring and defining a method that prints the last two lines of every verse, but the last one. And a blank space to separate the verses from each other.
    
    public static void versesending() {
        System.out.println("I don\'t know why she swallowed that fly,\nPerhaps she\'ll die.");
        System.out.println(); 
    }
    
    
    //Declaring and defining methods with their corresponding animal.
    
    public static void fly() {
        System.out.println("She swallowed the spider to catch the fly,");
    }
    public static void spider(){
        System.out.println("She swallowed the bird to catch the spider,");
    }
    public static void bird() {
        System.out.println("She swallowed the cat to catch the bird,");
    }
    public static void cat() {
        System.out.println("She swallowed the dog to catch the cat,");
    }
    public static void dog() {
        System.out.println("She swallowed the goat to catch the dog,");
    }
    public static void goat() {
        System.out.println("She swallowed the cow to catch the goat,");
    }
    
    
    //Defining what each method will print out. 
    
    //Verse1
    public static void verse1() {
        System.out.println("There was an old woman who swallowed a fly.");
        versesending();
    }
    //Verse2
    public static void verse2() {
        System.out.println("There was an old woman who swallowed a spider,\nThat wriggled and iggled and jiggled inside her.");
        fly();
        versesending();
    }
    //Verse3
    public static void verse3() {
        System.out.println("There was an old woman who swallowed a bird,\nHow absurd to swallow a bird.");
        spider();
        fly();
        versesending();
    }
    //Verse4
    public static void verse4() {
        System.out.println("There was an old woman who swallowed a cat,\nImagine that to swallow a cat.");
        bird();
        spider();
        fly();
        versesending();
    }
    //Verse5
    public static void verse5() {
        System.out.println("There was an old woman who swallowed a dog,\nWhat a hog to swallow a dog.");
        cat();
        bird();
        spider();
        fly();
        versesending();
    }
    //Verse6
    public static void verse6() {
        System.out.println("There was an old woman who swallowed a goat,\nShe just opened her throat to swallow a goat.");
        dog();
        cat();
        bird();
        spider();
        fly();
        versesending();
    }
    //Verse7
    public static void verse7() {
        System.out.println("There was an old woman who swallowed a cow,\nI don\'t know how she swallowed a cow.");
        goat();
        dog();
        cat();
        bird();
        spider();
        fly();
        versesending();
    }
    //Verse8
    public static void verse8() {
        System.out.println("There was an old woman who swallowed a horse,\nShe died of course.");
    }  
         
}
    
