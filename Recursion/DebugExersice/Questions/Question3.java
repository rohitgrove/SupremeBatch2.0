package Questions;
import java.util.Arrays;

public class Question3 {
    public static int subset(int[] input, int n, int[][] output, int k) {
        if (n == 0) {
            output[0][0] = 0;
            return 1;
        }

        int small = subset(Arrays.copyOfRange(input, 1, n), n - 1, output, k);
        int count = 0;

        for (int i = 0; i < small; i++) {
            output[small + count][1] = input[0];
            int sum = input[0];
            int l = 0;
            for (int j = 2; output[small - count - 1][j - 1] != 0; j++) {
                l++;
                output[small + count][j] = output[small - count - 1][j - 1];
                sum = sum + output[small - count - 1][j - 1];
            }
            output[small + count][0] = -1;
            if (sum == k) {
                output[small + count][0] = l + 1;
            }
            count++;
        }
        return small + count;
    }

    public static int subsetSumToK(int[] input, int n, int[][] output, int k) {
        int[][] temp = new int[1110000][50];
        int size = subset(input, n, temp, k);
        int m = 0;
        for (int i = 0; i < size; i++) {
            if (temp[i][0] > 0) {
                for (int j = 0; j < temp[i][0]; j++) {
                    output[m][j] = temp[i][j];
                }
                m++;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int[] input = { 1, 2, 3 };
        int n = input.length;
        int[][] output = new int[1110000][50];
        int k = 3;

        int resultSize = subsetSumToK(input, n, output, k);

        System.out.println("Subsets with sum " + k + ":");
        for (int i = 0; i < resultSize; i++) {
            for (int j = 1; j <= output[i][0]; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }   
}
