public class MergeSort1 { // tc: O(nlogn), sc: O(n)
    public static int[] mergeSort(int arr[], int s, int e) {
        // base case
        if (s >= e) {
            return new int[] { arr[s] };
        }

        // break
        int mid = s + (e - s) / 2;

        // recursive call for left array
        int left[] = mergeSort(arr, s, mid);
        // recursive call for right array
        int right[] = mergeSort(arr, mid + 1, e);

        // merge 2 sorted arrays
        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right) {
        // create ans array
        int ans[] = new int[left.length + right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int ansIndex = 0;

        // actual merge logic here
        // left array is already sorted
        // right array is already sorted
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                ans[ansIndex] = left[leftIndex];
                ansIndex++;
                leftIndex++;
            } else {
                ans[ansIndex] = right[rightIndex];
                ansIndex++;
                rightIndex++;
            }
        }

        // 1st case-> right array exhaust but left array me element abhi bache hue hai
        while (leftIndex < left.length) {
            ans[ansIndex] = left[leftIndex];
            ansIndex++;
            leftIndex++;
        }

        // 2nd case-> left array exhaust but right array me element abhi bache hue hai
        while (rightIndex < right.length) {
            ans[ansIndex] = right[rightIndex];
            ansIndex++;
            rightIndex++;
        }

        return ans;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 6, 9, 4, 5 };
        int ans[] = mergeSort(arr, 0, arr.length - 1);
        printArr(ans);
    }
}