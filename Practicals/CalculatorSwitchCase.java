public class CalculatorSwitchCase
{
    public static void main(String[] args)
    {
        double no1=10, no2=30;

        char operator = '*';

        double result;

        // Use switch case to perform the selected operation
        switch (operator)
        {
            case '+':
                result = no1 + no2;
                System.out.println("Result: " + result);
                break;
            case '-':
                result = no1 - no2;
                System.out.println("Result: " + result);
                break;
            case '*':
                result = no1 * no2;
                System.out.println("Result: " + result);
                break;
            case '/':
                if (no2 != 0) {
                    result = no1 / no2;
                    System.out.println("Result: " + result);
                }
                else
                {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
            case '%':
                if (no2 != 0)
                {
                    result = no1 % no2;
                    System.out.println("Result: " + result);
                }
                else
                {
                    System.out.println("Error: Modulus by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid operator. Please choose a valid operation.");
        }
    }
}