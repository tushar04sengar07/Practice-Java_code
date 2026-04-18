public class ArmstrongNumberList
{
    public static void main(String[] args)
    {
        System.out.println("Armstrong numbers between 1 and 10,000 are:");

        for (int no = 1; no <= 10000; no++)
        {
            int originalNumber = no;
            int sum = 0;

            // Calculate the number of digits
            int temp = no;
            int digits = 0;
            while (temp != 0)
            {
                digits++;
                temp = temp / 10;
            }

            int currentNumber = no;
            while (currentNumber != 0)
            {
                int rem = currentNumber % 10;
                int power = 1;

                // Calculate rem^digits using a basic loop
                for (int i = 0; i < digits; i++)
                {
                    power = power * rem;
                }

                sum = sum + power;
                currentNumber = currentNumber / 10;
            }

            if (sum == originalNumber)
            {
                System.out.println(originalNumber);
            }
        }
    }
}
