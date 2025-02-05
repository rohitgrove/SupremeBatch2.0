public class Main {
    public static void main(String[] args) {
        NStack s = new NStack(3, 6);
        System.out.println(s.push(1, 1));
        System.out.println(s.push(10, 1));
        System.out.println(s.push(10, 1));
        System.out.println(s.push(14, 2));
        System.out.println(s.push(15, 3));
        System.out.println(s.pop(1));
        System.out.println(s.pop(2));
    }
}