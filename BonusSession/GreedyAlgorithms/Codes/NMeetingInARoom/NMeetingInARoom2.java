import java.util.Arrays;

public class NMeetingInARoom2 {
    public static int maxMeetings(int start[], int end[]) {
        int n = start.length;
        Pair time[] = new Pair[n];

        for (int i = 0; i < n; i++) {
            time[i] = new Pair(start[i], end[i]);
        }

        Arrays.sort(time, new Compare());

        int count = 1;
        int prevStart = time[0].start;
        int prevEnd = time[0].end;

        for (int i = 1; i < n; i++) {
            int currStart = time[i].start;
            int currEnd = time[i].end;
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
