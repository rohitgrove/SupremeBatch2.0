public class Comparison {
    public static void main(String[] args) {
        String a = "Rohit";
        String b = "Rohit";
        String c = a;
        System.out.println(c);
        // System.out.println(a == b);

        String name1 = new String("Rohit");
        String name2 = new String("Rohit");
        // System.out.println(name1 == name2);
        System.out.println(name1.equals(name2));
        System.out.println(name1.charAt(0));
    }
}
