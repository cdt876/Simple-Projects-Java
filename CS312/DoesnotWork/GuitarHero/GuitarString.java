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

public class GuitarString {
    private RingBuffer rB;
    private int numberOfTics;
    private final double SAMPLING_RATE = 44100.0;
    private final double ENERGY_DECAY_FACTOR = 0.994;

    // create a guitar string of the given frequency, using a sampling rate of 44,100
    public GuitarString(double frequency) {
        rB = new RingBuffer((int) Math.round(SAMPLING_RATE / frequency));
        while (!rB.isFull()) {
            rB.enqueue(0.0);
        }
        numberOfTics = 0;
    }

    // create a guitar string whose size and initial values are given by the array
    public GuitarString(double[] init) {
        rB = new RingBuffer(init.length);
        for(int i = 0; i < init.length; i++) {
            rB.enqueue(init[i]);
        }
        numberOfTics = 0;
    }

    // set the buffer to white noise
    public void pluck() {
        while(!rB.isEmpty()) {
            rB.dequeue();
        }
        while(!rB.isFull()) {
            double randomValues = Math.random() - 0.5;
            rB.enqueue(randomValues);
        }
    }     

    // advance the simulation one time step                  
    public void tic() {
        //delete the sample at the front of the ring buffer
        double deletedSampleFront = rB.dequeue();
        rB.enqueue(((deletedSampleFront + rB.peek())/2) * (ENERGY_DECAY_FACTOR));
        numberOfTics++;
    }

    // return the current sample                          
    public double sample() {
        return rB.peek();
    }

    // return number of tics                      
    public int time() {
        return numberOfTics;
    }  
}