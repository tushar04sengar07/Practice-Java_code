public class PrimeNumbers1to100
{
    public static void main(String[] args)
    {
        System.out.println("Prime numbers between 1 and 100 are:");

        for (int num = 2; num <= 100; num++)  // Loop from 2 to 100
        {
            boolean isPrime = true;

            for (int i=2; i < num/2; i++)
            {
                if (num % i == 0)
                {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime)  // If no divisors found, it's prime
            {
                System.out.print(num + " ");
            }
        }
    }
}