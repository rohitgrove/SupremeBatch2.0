import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class MinimumTimeDiffrence {
    public static int findMinDifference(List<String> timePoints) {
        List<Integer> mins = new ArrayList<>();
        for (int i = 0; i < timePoints.size(); i++) {
            mins.add(convertToMin(timePoints.get(i)));
        }
        Collections.sort(mins);
        int ans = Integer.MAX_VALUE; // min diff
        for (int i = 0; i < mins.size() - 1; i++) {
            ans = Math.min(ans, mins.get(i + 1) - mins.get(i));
        }

        int lastDiff = mins.get(0) + 1440 - mins.get(mins.size() - 1);
        ans = Math.min(ans, lastDiff);
        return ans;
    }

    public static Integer convertToMin(String time) {
        int hr = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3));
        return 60 * hr + min;
    }

    public static void main(String[] args) {
        List<String> timePoints1 = new ArrayList<>();
        timePoints1.add("23:59");
        timePoints1.add("00:00");
        System.out.println(findMinDifference(timePoints1));
        List<String> timePoints2 = new ArrayList<>();
        timePoints2.add("00:00");
        timePoints2.add("23:59");
        timePoints2.add("00:00");
        System.out.println(findMinDifference(timePoints2));
    }
}
