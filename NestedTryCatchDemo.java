public class NestedTryCatchDemo {
    public static void main(String[] args) {
        try {
            System.out.println("Entering outer try block");
            
            try {
                System.out.println("Entering inner try block");
                int[] arr = new int[5];
                arr[10] = 10; 
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inner catch: ArrayIndexOutOfBoundsException - " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Inner catch: General Exception - " + e.getMessage());
            }
            
            String s = null;
            s.length(); 
            
        } catch (NullPointerException e) {
            System.out.println("Outer catch: NullPointerException - " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Outer catch: General Exception - " + e.getMessage());
        }
        
        System.out.println("Program execution completed");
    }
}