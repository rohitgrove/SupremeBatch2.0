import java.util.HashMap;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        // invalid case
        int len1 = s.length();
        int len2 = t.length();
        int start = 0;
        if (len1 < len2) {
            return "";
        }

        // valid case
        int ansIndex = -1;
        int ansLen = Integer.MAX_VALUE;

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        // store frequency of pattern string
        for (char ch : t.toCharArray()) {
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        }

        //initialise count variable, that basically shows count of actual
        //pattern wale string k character presrnt in the current window
        int count = 0;
        int e = 0;

        while (e < s.length()) {
            char ch = s.charAt(e);

            // update freq in sMap
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);

            if (sMap.get(ch) <= tMap.getOrDefault(ch, 0)) {
                // valid count
                count++;
            }

            if (count == len2) {
                //window found, jisme poora pattern existb krta h 
                //-> minimise
                //minimise sirf usi case me karunga, jis case me 
                //s index pr jo character present h, vop 
                //ya toh extra hai ya fer faltu hai 
                //aisa character jo pattern k andar hi nahi h, use bhi remove karo
                while (sMap.get(s.charAt(start)) > tMap.getOrDefault(s.charAt(start), 0)) {
                    sMap.put(s.charAt(start), sMap.get(s.charAt(start)) - 1);
                    start++;
                }

                //answer nikalo
                int windowLength = e - start + 1;
                if (windowLength < ansLen) {
                    ansLen = windowLength;
                    ansIndex = start;
                }
            }

            e++;
        }

        if (ansIndex == -1) {
            return "";
        } else {
            return s.substring(ansIndex, ansLen + ansIndex);
        }
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("a", "aa"));
    }
}
