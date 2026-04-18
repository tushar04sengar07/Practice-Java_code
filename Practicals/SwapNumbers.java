public class SwapNumbers
{
    public static void main(String[] args)
    {
        int no1=22, no2=33;

        // Display numbers before swapping
        System.out.println("Before swapping: no1 = " + no1 + ", no2 = " + no2);

        // Swap using a third variable
        int temp = no1;
        no1 = no2;
        no2 = temp;

        // Display numbers after swapping
        System.out.println("After swapping: no1 = " + no1 + ", no2 = " + no2);
    }
}