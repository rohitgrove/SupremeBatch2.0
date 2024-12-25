public class SearchInArray {
    public static boolean search1(int arr[], int size, int idx, int target) {
        // base case
        if (idx >= size) {
            return false;
        }

        if (arr[idx] == target) {
            return true;
        }

        // recursive call
        return search1(arr, size, idx + 1, target);
    }

    public static int search2(int arr[], int size, int idx, int target) {
        if (idx >= size) {
            return -1;
        }

        if (arr[idx] == target) {
            return idx;
        }

        return search2(arr, size, idx + 1, target);
    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50 };
        int index = 0;
        int target = 50;

        // boolean ans = search1(arr, arr.length, index, target);
        // if (ans) {
        //     System.out.println("element is present");
        // } else {
        //     System.out.println("element is not present");
        // }

        int ans = search2(arr, target, index, target);
        if (ans != -1) {
            System.out.println("Element Found At: " + ans);
        } else {
            System.out.println("Element Not Found");
        }
    }
}
