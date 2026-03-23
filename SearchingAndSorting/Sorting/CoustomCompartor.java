import java.util.Arrays;
import java.util.Comparator;

class MyComp implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        // return a - b; // Ascending order
        return b - a; // Descending order
    }
}

class MyCompFor1stIndex implements Comparator<int[]>{
    @Override
    public int compare(int[] o1, int[] o2) {
        return o1[1] - o2[1];
    }
}

public class CoustomCompartor {
    public static void printArr(Integer arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void printArr(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Integer arr[] = { 44, 55, 22, 11, 33 };
        // Arrays.sort(arr); // increasing order sorting
        // Arrays.sort(arr, new MyComp());
        // short hand
        // Arrays.sort(arr, (a, b) -> b - a);
        // printArr(arr);

        int matrix[][] = { { 1, 44 },
                { 0, 55 },
                { 0, 22 },
                { 0, 11 },
                { 2, 33 } };
        Arrays.sort(matrix, new MyCompFor1stIndex());
        printArr(matrix);
    }
}