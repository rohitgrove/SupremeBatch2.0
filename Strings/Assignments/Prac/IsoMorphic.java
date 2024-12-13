public class IsoMorphic {
    public static boolean isIsomorphic(String s, String t) {
        int hash[] = new int[256];
        boolean issbCharsMapped[] = new boolean[256];

        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i)] == 0 && issbCharsMapped[t.charAt(i)] == false) {
                hash[s.charAt(i)] = t.charAt(i);
                issbCharsMapped[t.charAt(i)] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i)] != t.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "add", t1 = "egg";
        System.out.println(isIsomorphic(s1, t1));
        String s2 = "foo", t2 = "bar";
        System.out.println(isIsomorphic(s2, t2));
    }
}
