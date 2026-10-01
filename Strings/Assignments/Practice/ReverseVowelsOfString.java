public class ReverseVowelsOfString {
    public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    public static String reverseVowels(String str) {
        char characterArray[] = str.toCharArray();
        
        int s = 0;
        int e = str.length() - 1;
        while (s < e) {
            if (isVowel(characterArray[s]) && isVowel(characterArray[e])) {
                char temp = characterArray[s];
                characterArray[s] = characterArray[e];
                characterArray[e] = temp;
                s++; e--;
            } else if (!isVowel(characterArray[s])) {
                s++;
            } else {
                e--;
            }
        }

        return String.valueOf(characterArray);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("IceCreAm"));
        System.out.println(reverseVowels("leetcode"));
    }
}
