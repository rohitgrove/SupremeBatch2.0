public class StringsCreation {
    public static void main(String[] args) {
        String str = "This is A car";
        str = str.replace(str.subSequence(4, 7), "");
        System.out.println(str);

        String name = "Rohit Grover";
        System.out.println(name);
        String part1 = name.substring(0, 6);
        String part2 = name.substring(6);
        name = part1 + "Kumar " + part2;

        System.out.println(name);

        String s1 = "Tony";
        String s2 = "Tony";
        String s3 = new String("Tony");

        if (s1 == s2) {
            System.out.println("Strings are equal");
        } else{
            System.out.println("Strings are not equal");
        }

        if (s1 == s3) {
            System.out.println("Strings are equal");
        } else {
            System.out.println("Strings are not eqaul");
        }

        if (s1.equals(s3)) {
            System.out.println("Strings are equal");
        } else{
            System.out.println("Strings are not eqaul");
        }
    }
}
