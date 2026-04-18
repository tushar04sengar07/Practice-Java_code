class YoungerAgeException extends RuntimeException
{
    YoungerAgeException(String s)
    {
        super(s);
    }
}

public class voting
{
    public static void main(String[] args)
    {
        int age = 16;
        try {
            if (age < 18) {
                throw new YoungerAgeException("You are not eligible to vote.");
            } else {
                System.out.println("You are eligible to vote.");
            }
        } catch (YoungerAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}