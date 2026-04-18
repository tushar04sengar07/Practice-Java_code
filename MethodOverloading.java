public class MethodOverloading {
    int add (int a, int b) {
        return a + b;
    }
    int add (int a, int b, int c) {
        return a + b + c;
    }
    public static void main(String[] args) {
        MethodOverloading mo = new MethodOverloading();
        System.out.println(mo.add(5, 10));        
        System.out.println(mo.add(5, 10, 15));    
    }
}