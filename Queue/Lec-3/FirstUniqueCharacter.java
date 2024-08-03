import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class FirstUniqueCharacter {
    public static int firstUniqCharLeetCode(String str) {
        Queue<Integer> q = new LinkedList<>();
        int freq[] = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch - 'a']++;
            q.add(i);
        }

        while (!q.isEmpty() && freq[str.charAt(q.peek()) - 'a'] > 1) {
            q.poll();
        }

        if (q.isEmpty()) {
            return -1;
        } else {
            return q.peek();
        }
    }

    public static ArrayList<Character> firstUniqCharOwnMethod(String str) {
        Queue<Character> q = new LinkedList<>();
        ArrayList<Character> ans = new ArrayList<>();
        int[] freq = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch - 'a']++;
            q.add(ch);

            // answer find karo

            while (!q.isEmpty()) {
                char frontCharater = q.peek();
                if (freq[frontCharater - 'a'] > 1) {
                    // yaani ye answer nahi hai
                    q.poll();
                } else {
                    // == 1 wala case
                    // ye answer hai
                    ans.add(frontCharater);
                    break;
                }
            }

            if (q.isEmpty()) {
                // koi answer nhi nikla
                ans.add('#');
            }
        }
        
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "leetcode";
        System.out.println(firstUniqCharLeetCode(s1));
        System.out.println(firstUniqCharOwnMethod(s1));
        String s2 = "loveleetcode";
        System.out.println(firstUniqCharLeetCode(s2));
        System.out.println(firstUniqCharOwnMethod(s2));
        String s3 = "aabb";
        System.out.println(firstUniqCharLeetCode(s3));
        System.out.println(firstUniqCharOwnMethod(s3));
        String s4 = "ababc";
        System.out.println(firstUniqCharLeetCode(s4));
        System.out.println(firstUniqCharOwnMethod(s4));
        String s5 = "facfdcad";
        System.out.println(firstUniqCharLeetCode(s5));
        System.out.println(firstUniqCharOwnMethod(s5));
    }
}