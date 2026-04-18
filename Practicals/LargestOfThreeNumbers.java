public class LargestOfThreeNumbers
{
    public static void main(String[] args)
    {
        int no1=10, no2=20, no3=30;

        // Finding and displaying the largest number
        if (no1>no2 && no1>no3)
        {
            System.out.println("\nThe largest number is : " + no1);
        }
        else if (no2>no1 && no2>no3)
        {
            System.out.println("\nThe largest number is : " + no2);
        }
        else
        {
            System.out.println("\nThe largest number is : " + no3);
        }
    }
}