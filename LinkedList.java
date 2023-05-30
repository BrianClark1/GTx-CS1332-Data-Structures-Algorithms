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



