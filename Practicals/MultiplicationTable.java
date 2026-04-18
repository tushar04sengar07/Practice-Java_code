public class MultiplicationTable
{
    public static void main(String[] args)
    {
        int no = 7;

        System.out.println("Multiplication Table of " + no + ":");

        // Loop from 1 to 10 to generate the table
        for (int i = 1; i <= 10; i++)
        {
            int result = no * i;
            System.out.println(no + " x " + i + " = " + result);
        }
    }
}