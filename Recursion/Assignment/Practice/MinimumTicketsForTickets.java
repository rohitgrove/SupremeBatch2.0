public class MinimumTicketsForTickets {
    public static int mincostTickets_helper(int days[], int costs[], int idx) {
        if (idx >= days.length) {
            return 0;
        }

        int cost1 = costs[0] + mincostTickets_helper(days, costs, idx + 1);

        int passEndDay = days[idx] + 7 - 1;
        int j = idx;
        while (j < days.length && days[j] <= passEndDay) {
            j++;
        }
        int cost7 = costs[1] + mincostTickets_helper(days, costs, j);

        passEndDay = days[idx] + 30 - 1;
        j = idx;
        while (j < days.length && days[j] <= passEndDay) {
            j++;
        }
        int cost30 = costs[2] + mincostTickets_helper(days, costs, j);

        return Math.min(Math.min(cost1, cost7), cost30);
    }

    public static int mincostTickets(int[] days, int[] costs) {
        return mincostTickets_helper(days, costs, 0);
    }


    public static void main(String[] args) {
        int days1[] = { 1, 4, 6, 7, 8, 20 }, costs1[] = { 2, 7, 15 };
        System.out.println(mincostTickets(days1, costs1));
        int days2[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 }, costs2[] = { 2, 7, 15 };
        System.out.println(mincostTickets(days2, costs2));
    }
}
