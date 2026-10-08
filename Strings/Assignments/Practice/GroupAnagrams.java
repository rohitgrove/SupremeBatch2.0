import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> method1(String strs[]) {
        HashMap<String, List<String>> mp = new HashMap<>();

        for (String str1 : strs) {
            char str[] = str1.toCharArray();
            Arrays.sort(str);
            String s = String.valueOf(str);
            mp.putIfAbsent(s, new ArrayList<>());
            mp.get(s).add(str1);
        }
        List<List<String>> ans = new ArrayList<>(mp.values());
        return ans;
    }

    public static int[] hash(String s) {
        int hash[] = new int[256];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }

        return hash;
    }

    public static List<List<String>> method2(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();
        for (String str : strs) {
            int hash[] = hash(str);
            String hashStr = Arrays.toString(hash);
            mp.putIfAbsent(hashStr, new ArrayList<>());
            mp.get(hashStr).add(str);
        }

        List<List<String>> ans = new ArrayList<>(mp.values());
        return ans;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        return method2(strs);
    }

    public static void main(String[] args) {
        String strs[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(strs));
    }
}
