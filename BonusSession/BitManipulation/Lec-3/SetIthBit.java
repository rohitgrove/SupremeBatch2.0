public class SetIthBit {
    public static void setIthBit(int n, int i) {
        int mask = (1 << i);
        n = n | mask;
        System.out.println("Updated number: " + n);
    }
    public static void main(String[] args) {
        int n = 10;
        int i = 2;

        setIthBit(n, i);
    }
}
