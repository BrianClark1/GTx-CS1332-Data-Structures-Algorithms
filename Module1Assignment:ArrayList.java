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
        if (data == null)  { 
            throw new IllegalArgumentException("Error: input data is null");
            return;
    }


        
        //Check if empty
        if (size == 0) {
            backingArray[0] = data;
            size++;
            return;
        }

        // Increment size so we can se if resizing is necessary 
        //If unessesary then we shift all elements to the right  
        //By looping through 
        if (size != INITIAL_CAPACITY){
            for (int i = size; i >= 1; i--) {
                backingArray[i] = backingArray[i-1];
            }
            backingArray[0] = data;
            size++;
            
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
        size++;
        
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
        if (data == null) throw new IllegalArgumentException("Error: input data is null");
        
        //Check if empty
        if (size == 0) {
            backingArray[0] = data;
            size++;
            return;
        }

        // Increment size so we can se if resizing is necessary 
        
        //If unessesary then we place new element at the end of the array, after incrementation is size - 1;   
        if (size != INITIAL_CAPACITY){
            
            backingArray[size-1] = data;
            size++; 
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
        size++;
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
        T temp = backingArray[0];
        backingArray[0] = null;
        size--;
        return temp;
        }

        else  { 
            T temp = backingArray[0];
        for (int i = 0; i < size-1; i++) {
            backingArray[i] = backingArray[i+1];
         
         }
         backingArray[size-1] = null;
         size--;
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
        T temp = backingArray[size-1];
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

// [Executed at: Sun May 21 13:17:39 PDT 2023]

// ============================================================
// ArrayList.java successfully compiled.
// ============================================================
// Tests Passed: 14 / 23

// [Test Failure: addToFront] [-0.43] : IllegalArgumentException not thrown when attempting to add null data to the front. 

// [Test Failure: addToFront] [-0.43] : Unexpected content after adding once to the front, to capacity.
// 	Expected : [0a, 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a]
// 	Actual : [1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a, null, null, null, null, null, null, null, null, null, null] 

// [Test Failure: addToFront] [-0.43] : This addToFront test was inconclusive due to: java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 9
// Here is the stack trace to help identify the error in your code:
// 	at ArrayList.addToFront, line number: 62 

// [Test Failure: addToFront] [-0.43] : This addToFront test was inconclusive due to: java.lang.ArrayIndexOutOfBoundsException: Index 18 out of bounds for length 18
// Here is the stack trace to help identify the error in your code:
// 	at ArrayList.addToFront, line number: 62 

// [Test Failure: addToBack] [-0.43] : IllegalArgumentException not thrown when attempting to add null data to the back. 

// [Test Failure: addToBack] [-0.43] : Unexpected content after adding once to the back, to capacity.
// 	Expected : [0a, 1a, 2a, 3a, 4a, 5a, 6a, 7a, 8a]
// 	Actual : [0a, 1a, 2a, 3a, 4a, 5a, 6a, 7a, null, null, null, null, null, null, null, null, null, null] 

// [Test Failure: addToBack] [-0.43] : This addToBack test was inconclusive due to: java.lang.ArrayIndexOutOfBoundsException: Index 9 out of bounds for length 9
// Here is the stack trace to help identify the error in your code:
// 	at ArrayList.addToBack, line number: 113 

// [Test Failure: addToBack] [-0.43] : This addToBack test was inconclusive due to: java.lang.ArrayIndexOutOfBoundsException: Index 18 out of bounds for length 18
// Here is the stack trace to help identify the error in your code:
// 	at ArrayList.addToBack, line number: 113 

// [Test Failure: validSize] [-0.43] : Size variable did not update correctly when testing the following method(s): removeFromFront. Size variable could not be validated for the following method(s) due to early test failure(s): addToBack, addToFront. 


// Score: 6.09 / 10.0
// ============================================================