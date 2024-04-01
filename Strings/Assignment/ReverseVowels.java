public class ReverseVowels {
    public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public static String reverseVowels(String s) {
        char characters[] = s.toCharArray();
        int l = 0, h = s.length() - 1;
        while (l < h) {
            if (isVowel(characters[l]) && isVowel(characters[h])) {
                char temp = characters[l];
                characters[l] = characters[h];
                characters[h] = temp;
                l++; h--;
            } else if (!isVowel(characters[l])) {
                l++;
            } else {
                h--;
            }
        }

        return String.valueOf(characters);
    }
    public static void main(String[] args) {
        String s1 = "hello";
        System.out.println(reverseVowels(s1));
        String s2 = "leetcode";
        System.out.println(reverseVowels(s2));
    }    
}
