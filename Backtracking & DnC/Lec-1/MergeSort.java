public class MergeSort {
    public static void main(String[] args) {
        int arr1[] = { 6, 3, 9, 5, 2, 8 };
        printArr(mergesort(arr1, 0, arr1.length - 1));
        int arr2[] = { 2, 1, 9, 7, 4, 6 };
        printArr(mergesort(arr2, 0, arr2.length - 1));
        int arr3[] = { 20, 60, 55, 15, 45, 30, 72 };
        printArr(mergesort(arr3, 0, arr3.length - 1));
        int arr4[] = { 2, 4, 6, 1, 3, 9 };
        printArr(mergesort(arr4, 0, arr4.length - 1));
        int arr5[] = { 10, 15, 20, 10, 45, 65 };
        printArr(mergesort(arr5, 0, arr5.length - 1));
    }

    public static int[] merge(int left[], int right[]) {
        // merge logic here
        // left array is already sorted
        // right array is already sorted
        int temp[] = new int[left.length + right.length];
        int leftIdx = 0;
        int rightIdx = 0;
        int tempIdx = 0;

        while (leftIdx < left.length && rightIdx < right.length) {
            if (left[leftIdx] < right[rightIdx]) {
                temp[tempIdx] = left[leftIdx];
                leftIdx++;
                tempIdx++;
            } else {
                temp[tempIdx] = right[rightIdx];
                rightIdx++;
                tempIdx++;
            }
        }

        // 2 more cases

        // 1 case -> rigght array exhaust but left array me element abhi bhi bache hai
        while (leftIdx < left.length) {
            temp[tempIdx] = left[leftIdx];
            leftIdx++;
            tempIdx++;
        }

        // 2nd case -> left array exhaust but right array me element abhi bhi bache hai
        while (rightIdx < right.length) {
            temp[tempIdx] = right[rightIdx];
            rightIdx++;
            tempIdx++;
        }

        return temp;
    }

    public static int[] mergesort(int[] arr, int s, int e) {
        // base case
        // Single element ya phir invalid array
        if (s >= e) {
            int ans[] = new int[0];
            ans[0] = arr[s];
            return ans;
        }

        // break
        int mid = s + (e - s) / 2;
        // s -> mid -> left
        // mid+1 -> e -> right
        // recursion bhiya ko bulao and
        // left and right array ko sort karwao
        // recursive call for left array
        int left[] = mergesort(arr, s, mid);
        // recursive call for left array
        int right[] = mergesort(arr, mid + 1, e);
        // merge 2 sorted array
        return merge(left, right);
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}