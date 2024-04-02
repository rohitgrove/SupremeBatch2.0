import java.util.*;

public class GroupAnagram {
    public static List<List<String>> groupAnagram(String strs[]) {
        Map<String, List<String>> hm = new HashMap<>();
        for (String str : strs) {
            char currStrArr[] = str.toCharArray();
            Arrays.sort(currStrArr);
            String s = String.valueOf(currStrArr);
            if (!hm.containsKey(s)) {
                hm.put(s, new ArrayList<>());
            }

            hm.get(s).add(str);
        }

        List<List<String>> ans = new ArrayList<>(hm.values());
        return ans;
    }
    public static void main(String[] args) {
        String strs[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagram(strs));
    }    
}
