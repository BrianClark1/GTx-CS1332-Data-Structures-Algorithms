
import java.util.Arrays;
import java.util.NoSuchElementException;


public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        // Test addToFront
        System.out.println("Testing addToFront:");
        list.addToFront(3);
        list.addToFront(2);
        list.addToFront(1);
        System.out.println(Arrays.toString(list.getBackingArray())); // [1, 2, 3, null, null, null, null, null, null]
        System.out.println("Size: " + list.size()); // 3

        // Test addToBack
        System.out.println("\nTesting addToBack:");
        list.addToBack(4);
        list.addToBack(5);
        list.addToBack(6);
        list.addToBack(7);
        System.out.println(Arrays.toString(list.getBackingArray())); // [1, 2, 3, 4, 5, 6, 7, null, null]
        System.out.println("Size: " + list.size()); // 7

        // Test removeFromFront
        System.out.println("\nTesting removeFromFront:");
        System.out.println("Removed: " + list.removeFromFront()); // Removed: 1
        System.out.println(Arrays.toString(list.getBackingArray())); // [2, 3, 4, 5, 6, 7, null, null, null]
        System.out.println("Size: " + list.size()); // 6

        // Test removeFromBack
        System.out.println("\nTesting removeFromBack:");
        System.out.println("Removed: " + list.removeFromBack()); // Removed: 7
        System.out.println(Arrays.toString(list.getBackingArray())); // [2, 3, 4, 5, 6, null, null, null, null]
        System.out.println("Size: " + list.size()); // 5

        // Additional tests
        System.out.println("\nAdditional tests:");
        list.addToFront(0);
        list.addToBack(8);
        list.addToFront(-1);
        System.out.println(Arrays.toString(list.getBackingArray())); // [-1, 0, 2, 3, 4, 5, 6, 8, null]
        System.out.println("Size: " + list.size()); // 8

        list.removeFromFront();
        list.removeFromBack();
        System.out.println(Arrays.toString(list.getBackingArray())); // [0, 2, 3, 4, 5, 6, null, null, null]
        System.out.println("Size: " + list.size()); // 6


        System.out.println("\nTesting resizing:");
        list.addToFront(9);
        list.addToBack(10);
        list.addToFront(8);
        list.addToBack(11);
        list.addToFront(7);
        list.addToBack(12);
        list.addToFront(6);
        list.addToBack(13);
        list.addToFront(5);
        list.addToBack(14);
        list.addToFront(4);
        list.addToBack(15);
        list.addToFront(3);
        list.addToBack(16);
        list.addToFront(2);
        list.addToBack(17);
        list.addToFront(1);
        list.addToBack(18);
        System.out.println(Arrays.toString(list.getBackingArray())); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
                                                                     // 15, 16, 17, 18, null, null, null, null, null,
                                                                     // null, null, null]
        System.out.println("Size: " + list.size()); // 18

    }
}