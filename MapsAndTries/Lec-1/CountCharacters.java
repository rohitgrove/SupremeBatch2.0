import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class CountCharacters {
    public static void countCharacters(HashMap<Character, Integer> mapping, String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            mapping.put(ch, mapping.getOrDefault(ch, 0) + 1);
        }
    }

    public static void main(String[] args) {
        String str = "lovebbabbar";
        HashMap<Character, Integer> mapping = new HashMap<>(); // unsorted map
        // TreeMap<Character, Integer> sortedMap = new TreeMap<>(); // sorted map
        countCharacters(mapping, str);

        for (char ch : mapping.keySet()) {
            System.out.println(ch + " -> " + mapping.get(ch));
        }
    }
}
