public class ClearLastIBits {
    public static void clearLastIBits(int n, int i) {
        int mask = (-1 << i);
        n = n & mask;
        System.out.println("Updated number: " + n);
    }
    
    public static void main(String[] args) {
        int n = 15;
        int i = 2;
        clearLastIBits(n, i);   
    }
}
