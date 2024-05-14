import java.util.ArrayList;
import java.util.List;

public class CountInversions {
    public static long countInversions1(List<Integer> arr) {
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                count = arr.get(i) > arr.get(j) ? count + 1 : count;
            }
        }
        return count;
    }

    public static long countInversions2(List<Integer> arr) {
        int[] temp = new int[arr.size()];
        return mergeSortAndCountInversions(arr, temp, 0, arr.size() - 1);
    }

    public static long mergeSortAndCountInversions(List<Integer> arr, int[] temp, int start, int end) {
        if (start >= end) {
            return 0;
        }
        long count = 0;
        int mid = start + (end - start) / 2;
        count += mergeSortAndCountInversions(arr, temp, start, mid);
        count += mergeSortAndCountInversions(arr, temp, mid + 1, end);
        count += mergeAndCountInversions(arr, temp, start, mid, end);
        return count;
    }

    public static long mergeAndCountInversions(List<Integer> arr, int[] temp, int start, int mid, int end) {
        long count = 0;
        int i = start, j = mid + 1, k = start;
        while (i <= mid && j <= end) {
            if (arr.get(i) <= arr.get(j)) {
                temp[k++] = arr.get(i++);
            } else {
                temp[k++] = arr.get(j++);
                count += mid - i + 1; // Count inversions
            }
        }

        while (i <= mid) {
            temp[k++] = arr.get(i++);
        }

        while (j <= end) {
            temp[k++] = arr.get(j++);
        }

        for (i = start; i <= end; i++) {
            arr.set(i, temp[i]);
        }

        return count;
    }

    public static void main(String[] args) {
        List<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(1);
        arr1.add(1);
        arr1.add(2);
        arr1.add(2);
        System.out.println(countInversions2(arr1));
        List<Integer> arr2 = new ArrayList<>();
        arr2.add(2);
        arr2.add(1);
        arr2.add(3);
        arr2.add(1);
        arr2.add(2);
        System.out.println(countInversions2(arr2));
        List<Integer> arr3 = new ArrayList<>();
        arr3.add(8);
        arr3.add(4);
        arr3.add(2);
        arr3.add(1);
        System.out.println(countInversions2(arr3));
    }
}