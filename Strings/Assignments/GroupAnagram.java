import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
    public static List<List<String>> groupAnagramsM1(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();

        for (String str : strs) {
            char sArr[] = str.toCharArray();
            Arrays.sort(sArr);
            String s = String.valueOf(sArr);
            mp.putIfAbsent(s, new ArrayList<>());

            mp.get(s).add(str);
        }

        List<List<String>> ans = new ArrayList<>(mp.values());

        return  ans;
    }

    public static int[] hash(String s) {
        int hash[] = new int[256];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }

        return hash;
    }

    public static List<List<String>> groupAnagramsM2(String[] strs) {
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

    public static void main(String[] args) {
        String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagramsM2(strs));
    }
}
