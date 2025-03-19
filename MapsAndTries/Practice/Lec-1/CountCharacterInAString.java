import java.util.HashMap;

public class CountCharacterInAString {
    public static HashMap<Character, Integer> countCharacter(String str) {
        HashMap<Character, Integer> ans = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            ans.putIfAbsent(ch, 0);
            ans.put(ch, ans.get(ch) + 1);
        }

        return ans;
    }

    public static void printMap(HashMap<Character, Integer> map) {
        for (char key : map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String str1 = "geeksforgeeks";
        printMap(countCharacter(str1));
        String str2 = "rohitgrover";
        printMap(countCharacter(str2));
        String str3 = "lovebbabbar";
        printMap(countCharacter(str3));
    }
}
