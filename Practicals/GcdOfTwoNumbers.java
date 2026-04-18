public class GcdOfTwoNumbers
{
    public static void main(String[] args)
    {
        int no1 = 12, no2 = 15;
        int gcd = 1;

        for (int i = 1; i <= no1 && i <= no2; i++)
        {
            if (no1 % i == 0 && no2 % i == 0)
            {
                gcd = i;
            }
        }

        System.out.println("GCD: " + gcd);
    }
}