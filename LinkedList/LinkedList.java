import java.util.NoSuchElementException;

/**
 * Your implementation of a Singly-Linked List.
 */
public class SinglyLinkedList<T> {

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    /*
     * Do not add a constructor.
     */

    /**
     * Adds the element to the front of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     *  Singly-Linked List with a head and tail reference
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        
        // Data Validity Check
        if (data == null) {
            throw new IllegalArgumentException("Error: input data is null");
        }
        
        //Check for Empty List
        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);
        if (size == 0) {
            head = newNode;
            tail = newNode;
            size++;
        }

        //Create our new head
        else {
            newNode.setNext(head);
            head = newNode;
            size++;
        }
    }

    /**
     * Adds the element to the back of the list.
     *
     * Method should run in O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     * Singly-Linked List with a head and tail reference
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        
        // Data Validity Check
        if (data == null) {
            throw new IllegalArgumentException("Error: input data is null");
        }

        // Check for Empty List
        SinglyLinkedListNode<T> newNode = new SinglyLinkedListNode<>(data);
        if (size == 0) {
            head = newNode;
            tail = newNode;
            size++;
        }

        // Create our new tail
        else {
            newNode.setNext(null);
            tail.setNext(newNode);
            tail = newNode;
            size++;
        }
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     * Singly-Linked List with a head and tail reference
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!

        // Check for Empty List
        if (size == 1) {
            head = null;
            tail = null;
            size--;
        }

        else {
            SinglyLinkedListNode<T> prevHead = head;
            head = head.getNext();
            prevHead.setNext(null);
            size--;
            return (T) prevHead;
        }
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        // Check for Empty List
        if (size == 1) {
            head = null;
            tail = null;
            size--;
        }
        else {
            SinglyLinkedListNode<T> prevTail = tail;
            head = head.getNext();
            prevHead.setNext(null);
            size--;
            return (T) prevHead;
        }
    }

    /**
     * Returns the head node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        // DO NOT MODIFY THIS METHOD!
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        // DO NOT MODIFY THIS METHOD!
        return tail;
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