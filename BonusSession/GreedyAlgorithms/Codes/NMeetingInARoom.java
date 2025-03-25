import java.util.Arrays;

public class NMeetingInARoom {
    public static int maxMeetings(int start[], int end[]) {
        int n = end.length;
        int time[][] = new int[start.length][2];
        for (int idx = 0; idx < n; idx++) {
            time[idx][0] = start[idx];
            time[idx][1] = end[idx];
        }

        Arrays.sort(time, (a, b) -> a[1] - b[1]);

        int count = 1;
        int prevStart = time[0][0];
        int prevEnd = time[0][1];

        for (int i = 1; i < n; i++) {
            int currStart = time[i][0];
            int currEnd = time[i][1];
            if (currStart > prevEnd) {
                // include current meeting
                count++;
                prevStart = currStart;
                prevEnd = currEnd;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int start1[] = { 1, 3, 0, 5, 8, 5 }, end1[] = { 2, 4, 6, 7, 9, 9 };
        System.out.println(maxMeetings(start1, end1));
        int start2[] = { 10, 12, 20 }, end2[] = { 20, 25, 30 };
        System.out.println(maxMeetings(start2, end2));
    }
}
