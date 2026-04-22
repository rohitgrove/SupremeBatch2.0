import java.util.Arrays;
import java.util.PriorityQueue;

public class RelativeRanks {
    public static String[] findRelativeRanks(int[] score) {
        String rank[] = new String[score.length];
        Arrays.fill(rank, "");

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.score - a.score);

        for (int i = 0; i < score.length; i++) {
            pq.offer(new Pair(score[i], i));
        }

        int rankNum = 0;
        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            int index = top.index;
            rankNum++;

            if (rankNum == 1) {
                rank[index] = "Gold Medal";
            }

            if (rankNum == 2) {
                rank[index] = "Silver Medal";
            }

            if (rankNum == 3) {
                rank[index] = "Bronze Medal";
            }

            if (rankNum > 1 && rankNum > 2 && rankNum > 3) {
                rank[index] = "" + rankNum;
            }
        }

        return rank;
    }

    public static void printScore(int score[]) {
        for (int scr : score) {
            System.out.print(scr + " ");
        }
        System.out.println();
    }

    public static void printRank(String rank[]) {
        for (String rnk : rank) {
            System.out.print(rnk + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int score1[] = { 5, 4, 3, 2, 1 };
        printScore(score1);
        printRank(findRelativeRanks(score1));
        int score2[] = { 10, 3, 8, 9, 4 };
        printScore(score2);
        printRank(findRelativeRanks(score2));
    }
}
