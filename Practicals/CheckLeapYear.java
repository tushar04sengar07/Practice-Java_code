public class CheckLeapYear
{
    public static void main(String[] args)
    {
        int year = 2025;

        // Check if the year is a leap year using conditional logic
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))
        {
            System.out.println(year + " is a leap year.");
        }
        else
        {
            System.out.println(year + " is not a leap year.");
        }
    }
}