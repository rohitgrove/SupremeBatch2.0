public class StringBuilders {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Rohit");
        System.out.println(sb);
        // String res = sb.toString();
        // System.out.println(res);

        sb.append("Grover");
        System.out.println(sb);
        sb.insert(0, 'A');
        System.out.println(sb);

        sb.replace(2, 5, "JAVA");
        System.out.println(sb);

        sb.delete(0, 5);
        System.out.println(sb);

        Math.max(4, 8);
        Math.min(4, 8);
    }
}