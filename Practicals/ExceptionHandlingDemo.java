// Step 1: Create a customized exception class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        // Calling the constructor of the parent Exception class
        super(message);
    }
}

public class ExceptionHandlingDemo {

    // Step 2: Use 'throws' to declare that this method might throw our custom exception
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            // Step 3: Use 'throw' to explicitly trigger the exception
            throw new InvalidAgeException("Access Denied: You must be at least 18 years old to vote.");
        } else {
            System.out.println("Access Granted: You are eligible to vote.");
        }
    }

    public static void main(String[] args) {
        // Step 4: Use 'try' to wrap code that might throw an exception
        try {
            validateAge(15); // This will trigger the exception
        } 
        // Step 5: Use 'catch' to handle the specific custom exception
        catch (InvalidAgeException e) {
            System.out.println("Caught Custom Exception: " + e.getMessage());
        } 
        // Step 6: Use 'finally' for code that must execute regardless of an exception
        finally {
            System.out.println("The 'finally' block: This always executes for cleanup or final logs.");
        }
    }
}