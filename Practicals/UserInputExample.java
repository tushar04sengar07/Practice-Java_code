import java.util.Scanner; // Import Scanner class

public class UserInputExample
{
    public static void main(String[] args)
    {
        // Step 1: Create Scanner object
        Scanner scanner = new Scanner(System.in);
        
        // Step 2: Prompt the user for input
        System.out.print("Enter your name: ");
        String name = scanner.nextLine(); // Read a string input
        
        System.out.print("Enter your age: ");
        int age = scanner.nextInt(); // Read an integer input
        
        System.out.print("Enter your favorite decimal number: ");
        double favoriteNumber = scanner.nextDouble(); // Read a double input
        
        // Step 3: Display the input back to the user
        System.out.println("\nThank you for providing the details!");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Favorite Number: " + favoriteNumber);
        
        // Step 4: Close the Scanner
        scanner.close();
    }
}
