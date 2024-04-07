import java.util.Arrays;
import java.util.Comparator;

public class CustomComparator {
    // static class Compare implements Comparator<Integer> {
    //     @Override
    //     public int compare(Integer o1, Integer o2) {
    //         // return o1 - o2; // increasing order sorting
    //         return o2 - o1; // decreasing order sorting
    //     }
    // }

    static class Compare2dArr implements Comparator<Integer[]>{
        @Override
        public int compare(Integer[] o1, Integer[] o2) {
            // return o1[1] - o2[1]; // Increasing order
            return o2[1] - o1[1]; // decresing order
        }
        
    }

    public static void main(String[] args) {
        // Integer arr[] = { 44, 55, 22, 11, 33 };
        // Arrays.sort(arr); // increasing order sorting
        // Arrays.sort(arr, new Compare());
        // printArr(arr);

        Integer arr[][] = { { 1, 44 },
                { 0, 55 },
                { 0, 22 },
                { 0, 11 },
                { 2, 33 } };

        Arrays.sort(arr, new Compare2dArr());
        printAL(arr);
    }

    public static void printAL(Integer arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printArr(Integer arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}