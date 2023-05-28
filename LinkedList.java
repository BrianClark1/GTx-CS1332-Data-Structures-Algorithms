public class LinkedList {

    public void recrusiveDuplicate(node) {
//Recursion Duplicate solution 
//We are going to need to traverse the entire linked list 
        
        //Base Case, end of iteration
        if (node.next == null) {
            return;
        }

        //We have a duplicate
    else if(node.next.value==node.value){
            //Point our current nodes next to skip the duplicate, keeping list integrity
            node.next = node.next.next;
            //Point our duplicated next to null, effectivley removing it from the sequence. (nothing point to it, it points to nothing)
            node.next.next = null;
        }
        return recrusiveDuplicate(node.next);

}


// // Short answer Lab
// Adding our
// first node
// is an edge case A)
// With a
// size variable this
// check becomes

// o(1) time due to primitive operation comparison 
// Then we simply set equal head & tail to the new Node 

// B)
// We will set tail.next equal to 6, then reassign tail to our new Node. This is

// an O(1) efficiency operation in comparison to our

// previous O(N) without our tail.

// C) When adding to the front, we set inputData.next = head. Then we reassign head to inputData. Thus we have the next value of the new node pointing to the previous head, and the new head 
// is re assigned to the input Value. It is important to set the next value of the new node first before reassigning the head to be sure we dont lose the rest of the linked list 

// D) same 

// E)
// Same 

// G) 
// When removing the final peice of data we do head & tail == null


//Recursion Duplicate solution 
//We are going to need to traverse the entire linked list 
