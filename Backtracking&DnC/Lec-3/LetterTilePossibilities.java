public class LetterTilePossibilities {
    public static int solve(int[] freq) {
        int ans = 0;
        // hr ek dabbe me, A-> z tk insert krne ka try krra hu
        for (int i = 0; i < 26; i++) {
            // character exist karta hai ya nhi
            if (freq[i] != 0) {
                // ek ans nikal gya
                ans++;
                // freq update
                freq[i]--;
                // baki recursion nikal sambhal lega
                int recursionKaAnswer = solve(freq);
                ans += recursionKaAnswer;
                // backtracking
                freq[i]++;
            }
        }
        return ans;
    }

    public static int numTilePossibilities(String tiles) {
        int freq[] = new int[26];
        // count frequency of characters
        for (int i = 0; i < tiles.length(); i++) {
            char ch = tiles.charAt(i);
            freq[ch - 'A']++;
        }

        int ans = solve(freq);
        return ans;
    }

    public static void main(String[] args) {
        String tiles1 = "AAB";
        System.out.println(numTilePossibilities(tiles1));
        String tiles2 = "AAABBC";
        System.out.println(numTilePossibilities(tiles2));
        String tiles3 = "V";
        System.out.println(numTilePossibilities(tiles3));
    }
}