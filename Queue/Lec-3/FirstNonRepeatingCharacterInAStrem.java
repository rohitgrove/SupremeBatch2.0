import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacterInAStrem {
    public static void firstUniqChar1(String str) {
        Queue<Character> q = new LinkedList<>();
        int freq[] = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch - 'a']++;
            q.offer(ch);
            // answer find out
            while (!q.isEmpty()) {
                char frontCharacter = q.peek();
                if (freq[frontCharacter - 'a'] > 1) {
                    // yaani ye answer nahi h
                    q.poll();
                } else {
                    // == 1 wala case
                    // yahi answer hai
                    System.out.print(frontCharacter + " ");
                    break;
                }
            }

            if (q.isEmpty()) {
                // koi answer nahi mila
                System.out.print("# ");
            }
        }

        System.out.println();
    }

    public static int firstUniqChar2(String str) {
        Queue<Integer> q = new LinkedList<>();
        int freq[] = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch - 'a']++;
            q.offer(i);
        }

        while (!q.isEmpty() && freq[str.charAt(q.peek()) - 'a']  > 1) {
            q.poll();
        }

        if (q.isEmpty()) {
            return -1;
        } else {
            return q.peek();
        }
    }

    public static char firstUniqChar3(String str) {
        Queue<Character> q = new LinkedList<>();
        int freq[] = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch - 'a']++;
            q.offer(ch);
        }

        while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
            q.poll();
        }

        if (q.isEmpty()) {
            return '#';
        } else {
            return q.peek();
        }
    }

    public static void main(String[] args) {
        String str1 = "a";
        firstUniqChar1(str1);
        System.out.println(firstUniqChar2(str1));
        System.out.println(firstUniqChar3(str1));
        String str2 = "ab";
        firstUniqChar1(str2);
        System.out.println(firstUniqChar2(str2));
        System.out.println(firstUniqChar3(str2));
        String str3 = "aba";
        firstUniqChar1(str3);
        System.out.println(firstUniqChar2(str3));
        System.out.println(firstUniqChar3(str3));
        String str4 = "abab";
        firstUniqChar1(str4);
        System.out.println(firstUniqChar2(str4));
        System.out.println(firstUniqChar3(str4));
        String str5 = "ababc";
        firstUniqChar1(str5);
        System.out.println(firstUniqChar2(str5));
        System.out.println(firstUniqChar3(str5));
        String str6 = "leetcode";
        firstUniqChar1(str6);
        System.out.println(firstUniqChar2(str6));
        System.out.println(firstUniqChar3(str6));
        String str7 = "loveleetcode";
        firstUniqChar1(str7);
        System.out.println(firstUniqChar2(str7));
        System.out.println(firstUniqChar3(str7));
        String str8 = "aabb";
        firstUniqChar1(str8);
        System.out.println(firstUniqChar2(str8));
        System.out.println(firstUniqChar3(str8));
    }
}