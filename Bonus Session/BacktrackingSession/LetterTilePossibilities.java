public class LetterTilePossibilities {
    public static int solve(int[] freq) {
        int ans = 0;
        // hr ek dabbe me, A-> Z tk insert krne ka try kar rha hu
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                // ek ans nikal gya
                ans++;
                // freq update
                freq[i]--;
                // baaki recursion sumbhale lega
                ans += solve(freq);
                // backtracking
                freq[i]++;
            }
        }
        return ans;
    }

    public static int numTilePossibilities(String tiles) {
        int[] freq = new int[26];
        for (char ch : tiles.toCharArray()) {
            freq[ch - 'A']++;
        }
        return solve(freq);
    }

    public static void main(String[] args) {
        String tiles = "AAB";
        System.out.println(numTilePossibilities(tiles));
    }
}