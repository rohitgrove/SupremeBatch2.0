public class MinimumCostsForTickets {
    public static int solve(int days[], int costs[], int index) {
        if (index >= days.length) {
            return 0;
        }

        int cost1 = costs[0] + solve(days, costs, index + 1);

        int passEndDay = days[index] + 7 - 1;
        int j = index;
        while (j < days.length && days[j] <= passEndDay) {
            j++;
        }
        int cost2 = costs[1] + solve(days, costs, j);

        passEndDay = days[index] + 30 - 1;
        j = index;
        while (j < days.length && days[j] <= passEndDay) {
            j++;
        }
        int cost3 = costs[2] + solve(days, costs, j);
        return Math.min(cost1, Math.min(cost2, cost3));
    }
    public static int mincostTickets(int[] days, int[] costs) {
        return solve(days, costs, 0);
    }
    public static void main(String[] args) {
        int days1[] = { 1, 4, 6, 7, 8, 20 }, costs1[] = { 2, 7, 15 };
        System.out.println(mincostTickets(days1, costs1));
        int days2[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 }, costs2[] = { 2, 7, 15 };
        System.out.println(mincostTickets(days2, costs2));
    }
}
