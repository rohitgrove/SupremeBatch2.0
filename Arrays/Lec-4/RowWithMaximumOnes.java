public class RowWithMaximumOnes {
    public static int[] rowAndMaximumOnes(int[][] mat) {
        int ans[] = new int[2];
        int n = mat.length;
        // oneCOunt -> will store max number of 1's in a row
        int oneCount = Integer.MIN_VALUE;
        // rowNo -> will store index of max no. of 1's wali row
        int rowNo = 0;

        for (int i = 0; i < n; i++) {
            // hr row start hone se phle initialise count with 0
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                // if 1 found, then increment count
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            // after row completion, compare count with oneCount
            if (count > oneCount) {
                oneCount = count;
                rowNo = i;
            }

        }

        ans[0] = rowNo;
        ans[1] = oneCount;
        return ans;
    }

    public static void main(String[] args) {
        int mat1[][] = { { 0, 1 },
                { 1, 0 } };
        int ans1[] = rowAndMaximumOnes(mat1);
        System.out.println(ans1[0] + " " + ans1[1]);

        int mat2[][] = { { 0, 0, 0 },
                { 0, 1, 1 } };
        int ans2[] = rowAndMaximumOnes(mat2);
        System.out.println(ans2[0] + " " + ans2[1]);

        int mat3[][] = { { 0, 0 },
                { 1, 1 },
                { 0, 0 } };
        int ans3[] = rowAndMaximumOnes(mat3);
        System.out.println(ans3[0] + " " + ans3[1]);

        int mat4[][] = { { 1, 0, 0, 0 },
                { 0, 1, 1, 0 },
                { 0, 1, 1, 0 },
                { 1, 1, 1, 0 },
                { 0, 0, 0, 1 }, };
        int ans4[] = rowAndMaximumOnes(mat4);
        System.out.println(ans4[0] + " " + ans4[1]);
    }
}
