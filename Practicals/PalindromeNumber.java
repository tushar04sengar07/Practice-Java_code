public class PalindromeNumber
{
    public static void main(String[] args)
    {
        int no = 52325;  // Number to check for palindrome
        int originalNumber = no;
        int reversedNumber = 0;

        while (no != 0)
        {
            int digit = no % 10;  // Get the last digit
            reversedNumber = reversedNumber * 10 + digit;  // Build the reversed number
            no = no / 10;  // Remove the last digit
        }

        // Check if the original number and reversed number are the same
        if (originalNumber == reversedNumber)
        {
            System.out.println(originalNumber + " is a Palindrome number.");
        }
        else
        {
            System.out.println(originalNumber + " is not a Palindrome number.");
        }
    }
}