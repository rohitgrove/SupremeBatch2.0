import java.util.ArrayList;
import java.util.List;

public class CountInversion {
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
    }

    public static long countInversions2(List<Integer> arr) {
        int temp[] = new int[arr.size()];
        return mergeSort(arr, temp, 0, arr.size() - 1);
    }

    public static long mergeSort(List<Integer> arr, int temp[], int start, int end) {
        if (start >= end) {
            return 0;
        }

        long count = 0;
        int mid = start + (end - start) / 2;
        count += mergeSort(arr, temp, start, mid);
        count += mergeSort(arr, temp, mid + 1, end);
        count += merge(arr, temp, start, mid, end);

        return count;
    }

    public static long merge(List<Integer> arr, int temp[], int start, int mid, int end) {
        int i = start, j = mid + 1, k = start;
        long count = 0;

        while (i <= mid && j <= end) {
            if (arr.get(i) <= arr.get(j)) {
                temp[k++] = arr.get(i++);               
            } else {
                temp[k++] = arr.get(j++);
                count += (mid - i + 1);
            }
        }


        while (i <= mid) {
            temp[k++] = arr.get(i++);               
        }

        while (j <= end) {
            temp[k++] = arr.get(j++);               
        }

        for (int l = start; l <= end; l++) {
            arr.set(l, temp[l]);
        }

        return count;
    }
}