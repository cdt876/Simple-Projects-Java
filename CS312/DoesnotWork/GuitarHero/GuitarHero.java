/**
 * @author  Carlos Trejo
 * @version 5/3/13
 * CS312 Assignment 11.
 *
 * On my honor, Carlos Trejo, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 *  email address: cdtrejo@utexas.edu
 *  UTEID: cdt876
 *  Section 5 digit ID: 53255
 *  Grader name: Rebecca
 *  Number of slip days used on this assignment: 0
 */
public class GuitarHero {
  
    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;' ";
        GuitarString[] pianoSample = new GuitarString[keyboard.length()];
                
        //Creates 37 guitar strings for the given keyboard
        for(int i = 0; i < keyboard.length(); i++) {
            double frequency = 440 * Math.pow(1.05956, i - 24);
            pianoSample[i] = new GuitarString(frequency);
        }

        final double TEXT_POS_X = .4;
        final double TEXT_POS_Y = .6;

        StdDraw.text(TEXT_POS_X, TEXT_POS_Y, "Type " + "keyboard"+ " to play a note!");

        play(pianoSample, keyboard);
    }

    private static void play(GuitarString[] pianoSample, String keyboard) { // the main input loop
        while (true) {
            // check if the user has typed a key, and, if so, process it
            if (StdDraw.hasNextKeyTyped()) {

                // the user types this character
                char key = StdDraw.nextKeyTyped();

                // pluck the corresponding string
                for(int i = 0; i < keyboard.length(); i++) {
                    if(key == keyboard.charAt(i)) 
                        pianoSample[i].pluck();               
                }
            }

            // compute the superposition of the samples
            double superPositionSample = 0.0;

            for(int i = 0; i < keyboard.length(); i++) {
                superPositionSample += pianoSample[i].sample();
            }

            // send the result to standard audio
            StdAudio.play(superPositionSample);

            // advance the simulation of each guitar string by one step
            for(int i = 0; i < keyboard.length(); i++) {
                pianoSample[i].tic();
            }
        }
    }
}
