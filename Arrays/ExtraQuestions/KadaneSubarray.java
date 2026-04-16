public class KadaneSubarray {
    public static int kadanes(int numbers[]) {
        int ms = Integer.MIN_VALUE;
        int cs = 0;

        for (int i = 0; i < numbers.length; i++) {
            cs = cs + numbers[i];
            if (cs > ms) {
                ms = cs;
            }
            if (cs < 0) {
                cs = 0;
            }
        }

        return ms;
    }

    public static void main(String[] args) {
        int numbers[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println(kadanes(numbers));
        int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(kadanes(arr));
        int nums[] = { 5, 4, -1, 7, 8 };
        System.out.println(kadanes(nums));
    }
}
