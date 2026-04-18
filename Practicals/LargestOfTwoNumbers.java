public class LargestOfTwoNumbers
{
    public static void main(String[] args)
    {
        int no1=10, no2=20;

        // Finding and displaying the largest number
        if (no1 > no2)
        {
            System.out.println("The largest number is : " + no1);
        }
        else if (no2 > no1)
        {
            System.out.println("The largest number is : " + no2);
        }
        else
        {
            System.out.println("Both numbers are equal.");
        }
    }
}