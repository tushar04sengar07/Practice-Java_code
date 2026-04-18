public class SumOfDigits
{
    public static void main(String[] args)
    {
        int no = 624;
        int sum = 0;

        while (no != 0)
        {
            int digit = no % 10;        // Extract the last digit
            sum = sum + digit;          // Add the digit to the sum
            no = no / 10;               // Remove the last digit
        }

        System.out.println("The sum of the digits is: " + sum);
    }
}