import java.util.Random;

public class ArrayExample {
    public static void main(String[] args) {
        int[] arr = new int[10];
        
        // Initialize the array with default values (0s)
        // At index 2, put a random number from 1 to 9
        Random rand = new Random();
        int randomNum = rand.nextInt(9) + 1; // Generates a number from 1 to 9
        arr[2] = randomNum;
        
        // Print the array elements
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }
}