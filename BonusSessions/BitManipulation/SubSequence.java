import java.util.ArrayList;
import java.util.List;

public class SubSequence {
    public static void getSubsequences(String str) {
        int n = str.length();
        List<String> ans = new ArrayList<>();
        for (int num = 0; num < (1 << n); num++) {
            // number is ready
            // use num, to create subsequence

		    //num -> set bit -> index -> char -> incl
            String temp = "";
            for(int i=0; i<n; i++) {
                //i -> represent index
                char ch = str.charAt(i);
                //agar i index pr num k andar set bit present hai
                //toh character ko include krdlo
                int mask = (1 << i);
                if((num & mask) != 0) {
                    temp += ch;
                }
            }
            ans.add(temp);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        String str = "abc";
        getSubsequences(str);
    }
}
