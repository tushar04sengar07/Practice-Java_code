public class LcmOfTwoNumbers
{
    public static void main(String[] args)
    {
        int no1 = 12, no2 = 15;
        int lcm = no1;

        if (no2 > no1)
        {
            lcm = no2;
        }

        while (true)
        {
            if (lcm % no1 == 0 && lcm % no2 == 0)
            {
                System.out.println("LCM: " + lcm);
                break;
            }
            lcm++;
        }
    }
}
