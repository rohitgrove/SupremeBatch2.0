public class ReverseArray {
    public static void reverseArray(int arr[], int size) {
        // for(int left =0, right=size-1; left<=right; left++, right--) {
        // int temp = arr[left];
        // arr[left] = arr[right];
        // arr[right] = temp;
        // }

        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        // printing the array;
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void main(String[] args) {
        int arr[] = { 10, 20, 30, 40, 50, 60 };
        reverseArray(arr, arr.length);
    }
}
