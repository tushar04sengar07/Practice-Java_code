public class FibonacciSeries
{
    public static void main(String[] args)
    {
        int n = 10;  // Number of terms to print
        int no1 = 0, no2 = 1;

        System.out.print("Fibonacci Series: " + no1 + ", " + no2);

        for (int i = 2; i < n; i++)
        {
            int sum = no1 + no2;
            System.out.print(", " + sum);
            no1 = no2;
            no2 = sum;
        }
    }
}