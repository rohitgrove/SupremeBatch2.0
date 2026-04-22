public class ReplaceWithM {
    public static String solve(String str) {
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            int pos = -1;

            // Step 1: Find digit
            for (char ch : word.toCharArray()) {
                if (Character.isDigit(ch)) {
                    pos = ch - '0';  // convert char to int
                    break;
                }
            }

            // Step 2: Remove digit
            String cleanWord = word.replaceAll("[0-9]", "");

            // Step 3: Replace character at (pos-1) with 'M'
            if (pos != -1 && pos - 1 < cleanWord.length()) {
                char[] arr = cleanWord.toCharArray();
                arr[pos - 1] = 'M';
                cleanWord = new String(arr);
            }

            result.append(cleanWord).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(solve("welcom3e t1o compu2ter wor1ld")); // weMcome Mo cMmputer Morld
        System.out.println(solve("Thi1s is2 reall4y goo2d")); // Mhis iM reaMly gMod
        System.out.println(solve("Compute3r Scienc3e")); // CoMputer ScMence
        System.out.println(solve("Hardwar2e")); // HMrdware
    }
}