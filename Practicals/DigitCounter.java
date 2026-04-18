public class DigitCounter
{
    public static void main(String[] args)
    {
        int no = 1382;
        int count = 0;

        while (no != 0)
        {
            no = no / 10;
            count++;
        }

        System.out.println("The number of digits is: " + count);
    }
}