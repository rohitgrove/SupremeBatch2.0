import java.util.LinkedList;
import java.util.Queue;

public class FirstUniqueCharacter {
    public static int firstUniqCharLeetCode(String str) {
        Queue<Integer> q = new LinkedList<>();
        int[] freq = new int[26];

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

    public static void firstUniqCharOwnMethod(String str) {
        Queue<Character> q = new LinkedList<>();
        int freq[] = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch - 'a']++;
            q.add(ch);

            while (!q.isEmpty()) {
                char frontCharacter = q.peek();
                if (freq[frontCharacter - 'a'] > 1) {
                    q.poll();
                } else {
                    System.out.println(q.peek() + " -> ");
                    break;
                }
            }

            if (q.isEmpty()) {
                System.out.println("# -> ");
            }
        }
    }
    public static void main(String[] args) {
        String str1 = "leetcode";
        System.out.println(firstUniqCharLeetCode(str1));
        String str2 = "loveleetcode";
        System.out.println(firstUniqCharLeetCode(str2));
        String str3 = "aabb";
        System.out.println(firstUniqCharLeetCode(str3));
        String str4 = "ababc";
        System.out.println(firstUniqCharLeetCode(str4));
        firstUniqCharOwnMethod(str4);
    }
}