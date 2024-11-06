import java.util.ArrayList;
import java.util.List;

public class SpiralPrint {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int totalElements = matrix.length * matrix[0].length;

        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endcol = matrix[0].length - 1;

        int count = 0;
        while (count < totalElements) {
            // print starting row
            for (int c = startCol; c <= endcol && count < totalElements; c++) {
                res.add(matrix[startRow][c]);
                count++;
            }
            startRow++;

            // print ending col
            for (int r = startRow; r <= endRow && count < totalElements; r++) {
                res.add(matrix[r][endcol]);
                count++;
            }
            endcol--;

            // print encding row
            for (int c = endcol; c >=  startCol && count < totalElements; c--) {
                res.add(matrix[endRow][c]);
                count++;
            }

            endRow--;
            // print starting row
            for (int r = endRow; r >= startRow && count < totalElements; r--) {
                res.add(matrix[r][startCol]);
                count++;
            }
            startCol++;
        }

        return res;
    }

    public static void main(String[] args) {
        int matrix[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 } };
        System.out.println(spiralOrder(matrix));
    }
}
