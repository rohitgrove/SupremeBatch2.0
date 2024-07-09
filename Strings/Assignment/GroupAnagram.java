import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class GroupAnagram {
    public static List<List<String>> groupAnagrams1(String[] strs) { // tc: O(NKLogK) sc: (NK)
        Map<String, List<String>> mp = new HashMap<>();

        for (String str : strs) {
            char chArray[] = str.toCharArray();
            Arrays.sort(chArray);
            String s = String.valueOf(chArray);
            if (!mp.containsKey(s)) {
                mp.put(s, new ArrayList<>());
            }
            mp.get(s).add(str);
        }


        List<List<String>> ans = new ArrayList<>(mp.values());
        return ans;
    }
  
    public static int[] hash(String s) {
        int[] hash = new int[256];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
        }
        return hash;
    }

    public static List<List<String>> groupAnagrams2(String[] strs) { // tc: O(nk)
        Map<String, List<String>> mp = new HashMap<>();
        for (String str : strs) {
            int[] hashed = hash(str);
            String key = Arrays.toString(hashed);
            if (!mp.containsKey(key)) {
                mp.put(key, new ArrayList<>());
            }
            mp.get(key).add(str);
        }

        List<List<String>> ans = new ArrayList<>(mp.values());
        return ans;
    }


    public static void main(String[] args) {
        String strs[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams2(strs));
    }
}
