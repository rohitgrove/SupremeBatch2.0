import java.util.ArrayList;

public class PrintIndexOfTargetInString {
    public static void printTarget1(String str, char target, int index) {
        if (index == str.length()) {
            return;
        }

        if (str.charAt(index) == target) {
            System.out.println(index);
        }

        printTarget1(str, target, index + 1);
    }

    public static void printTarget2(String str, char target, int index, ArrayList<Integer> ans) {
        if (index == str.length()) {
            return;
        }

        if (str.charAt(index) == target) {
            ans.add(index);
        }

        printTarget2(str, target, index + 1, ans);
    }

    public static void main(String[] args) {
        String str = "babbar"; char target = 'a';
        printTarget1(str, target, 0);
        ArrayList<Integer> ans = new ArrayList<>();
        printTarget2(str, target, 0, ans);
        System.out.println(ans);
    }    
}
