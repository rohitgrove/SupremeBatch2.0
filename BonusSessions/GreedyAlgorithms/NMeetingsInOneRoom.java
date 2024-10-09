import java.util.Arrays;
import java.util.Comparator;

class MeetingComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
        return a[1] - b[1]; // Compare based on end times
    }
}

public class NMeetingsInOneRoom {
    public static int maxMeetings(int n, int start[], int end[]) {
        int time[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            time[i][0] = start[i];
            time[i][1] = end[i];
        }

        Arrays.sort(time, new MeetingComparator());

        int count = 1;

        int prevEnd = time[0][1];

        for (int i = 0; i < n; i++) {
            int currStart = time[i][0];
            int currEnd = time[i][1];
            if (currStart > prevEnd) {
                // include current meeting
                count++;
                prevEnd = currEnd;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int start1[] = { 1, 3, 0, 5, 8, 5 }, end1[] = { 2, 4, 6, 7, 9, 9 };
        System.out.println(maxMeetings(start1.length, start1, end1));
        int start2[] = { 10, 12, 20 }, end2[] = { 20, 25, 30 };
        System.out.println(maxMeetings(start2.length, start2, end2));
    }
}
