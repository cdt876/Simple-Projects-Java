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

public class RingBuffer {
    private double[] ringBuffering;
    private int first;
    private int last;
    private int bufferCapacity;
    private int elementsInBuffer;

    // create an empty ring buffer, with given max capacity
    public RingBuffer(int capacity) {
        ringBuffering = new double[capacity];
        first = 0;
        last = 0;
        bufferCapacity = capacity;
        elementsInBuffer = 0;
    }  

    // return number of items currently in the buffer
    public int size() {
        return elementsInBuffer; 
    }

    // is the buffer empty (size equals zero)?
    public boolean isEmpty() {
        return elementsInBuffer == 0; 
    }      

    // is the buffer full (size equals capacity)?
    public boolean isFull() { 
        return elementsInBuffer == bufferCapacity; 
    }

    // add item x to the end
    public void enqueue(double x) {
//         if(this.isFull()) {
//             throw new RuntimeException("RingBuffer is full");
//         }    
        ringBuffering[last] = x;
        elementsInBuffer++;
        last = (last + 1) % bufferCapacity;
    }

    // delete and return item from the front  
    public double dequeue() {
        double removedItem = ringBuffering[first];
        elementsInBuffer--;
        first = (first + 1) % bufferCapacity;
        return removedItem;
    }     

    // return (but do not delete) item from the front          
    public double peek() {
        return ringBuffering[first];
    }

    // overrride toString. Return a String of the form [front, next, next, last]            
    public String toString() {
        String ret = "[";
        if (isEmpty()) 
            return ret + "]";
        else{
            for(int i = 0; i < elementsInBuffer - 1; i++) {
                int index = (first + i) % bufferCapacity;
                ret += ringBuffering[index] + ", ";
            }
            ret +=  ringBuffering[(first + elementsInBuffer - 1) % bufferCapacity];
            return ret + "]";
        }
    }
}