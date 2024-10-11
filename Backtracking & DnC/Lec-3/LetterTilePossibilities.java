public class LetterTilePossibilities {
    public static int solve(int[] freq) {
        int ans = 0;
        // hr ek dabbe me, A -> z insert krne ka try krra hu
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                // ek ans nikal gya
                ans++;
                // freq updatae
                freq[i]--;
                // baaki recursion sambhal lega
                ans += solve(freq);
                // backtracking
                freq[i]++;
            }
        }

        return ans;
    }

    public static int numTilePossibilities(String tiles) {
        int freq[] = new int[26];
        // count freqeuncy of characters
        for (char ch : tiles.toCharArray()) {
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
    }
}