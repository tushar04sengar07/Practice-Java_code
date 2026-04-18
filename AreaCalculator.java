class AreaCalculator 
{
    public double area(double radius) 
    {
        return Math.PI * radius * radius;
    }

    public double area(double length, double width) 
    {
        return length * width;
    }

    public double area(double base, double height, boolean isTriangle) 
    {
        return 0.5 * base * height;
    }

    public static void main(String[] args) 
    {
        AreaCalculator calc = new AreaCalculator();

        double circleArea = calc.area(5);
        System.out.println("Area of Circle (radius 5): " + circleArea);

        double rectangleArea = calc.area(10, 4);
        System.out.println("Area of Rectangle (10 x 4): " + rectangleArea);

        double triangleArea = calc.area(6, 3, true);
        System.out.println("Area of Triangle (base 6, height 3): " + triangleArea);
    }
}