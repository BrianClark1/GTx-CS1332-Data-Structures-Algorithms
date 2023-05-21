import java.util.NoSuchElementException;

/**
 * Your implementation of an ArrayList.
 */
public class ArrayList<T> {

    /*
     * The initial capacity of the ArrayList.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;
    // private int sizeIterator = 1;

    /**
     * This is the constructor that constructs a new ArrayList.
     * 
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayList() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the front of the list.
     *
     * This add may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        
        //Data Validity Check 
        if (data == null) throw new NoSuchElementException("Error: input data is null");
        
        //Check if empty
        if (size == 0) {
            backingArray[0] = data;
            size++;
            return;
        }

        // Increment size so we can se if resizing is necessary 
        size++;
        //If unessesary then we shift all elements to the right  
        //By looping through 
        if (size != INITIAL_CAPACITY){
            for (int i = size; i >= 1; i--) {
                backingArray[i] = backingArray[i-1];
            }
            backingArray[0] = data;
        }

        //Resizing is necessary 
        //How can we keep track of how many times we have resized? If i cant add any instance variables 
      
        else {
        // sizeIterator++

        //Double the inital length of old array
        T[] newBackingArray = (T[]) new Object[2*INITIAL_CAPACITY];  
        
        //Copy all values from old array into new 
        for (int i = 0; i < size; i ++) { 
            newBackingArray[i] = backingArray[i];
          }
        
        //Reassign backingArray to the doubled capacity array
        backingArray = newBackingArray;
        
        }
    }
    

    /**
     * Adds the data to the back of the list.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!

        //Data Validity Check 
        if (data == null) throw new NoSuchElementException("Error: input data is null");
        
        //Check if empty
        if (size == 0) {
            backingArray[0] = data;
            size++;
            return;
        }

        // Increment size so we can se if resizing is necessary 
        size++;
        //If unessesary then we place new element at the end of the array, after incrementation is size - 1;   
        if (size != INITIAL_CAPACITY){
            backingArray[size-1] = data; 
        }

        //Resizing is necessary 
        //How can we keep track of how many times we have resized? If i cant add any instance variables 
        else {
        // sizeIterator++

        //Double the inital length of old array
         T[] newBackingArray = (T[]) new Object[2*INITIAL_CAPACITY];  
        
        //Copy all values from old array into new 
        for (int i = 0; i < size; i ++) { 
            newBackingArray[i] = backingArray[i];

          }
        //Reassign backingArray to the doubled capacity array
        backingArray = newBackingArray;
        }



    }

    /**
     * Removes and returns the first data of the list.
     *
     * Do not shrink the backing array.
     *
     * This remove may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        
        //Check if empty
        if (size == 0) {
        throw new NoSuchElementException("Error: list is empty");
        }

        //Check if size is 1 
        else if (size == 1) {
        int temp = backingArray[0];
        backingArray[0] = null;
        size--;
        return temp;
        }

        else  { 
            int temp = backingArray[0];
        for (int i = 0; i < size-1; i++) {
            backingArray[i] = backingArray[i+1];
         
         }
         backingArray[size-1] = null;
         return temp; 
        }


    }

    /**
     * Removes and returns the last data of the list.
     *
     * Do not shrink the backing array.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!

        //Check if empty
        if (size == 0) {
        throw new NoSuchElementException("Error: list is empty");
        }

        else{ 
        int temp = backingArray[size-1];
        backingArray[size-1] = null;
        size--;
        return temp;
        }
    }

    /**
     * Returns the backing array of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }
}