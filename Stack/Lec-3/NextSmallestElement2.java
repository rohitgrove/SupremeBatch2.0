import java.util.Stack;

public class NextSmallestElement2 {
    public static int[] nextSmallerElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                int adult = st.pop();
                ans[adult] = arr[i];
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            ans[st.pop()] = -1;
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
        int arr1[] = { 8, 4, 6, 2, 3 };
        printArr(nextSmallerElement(arr1));
        int arr2[] = { 2, 1, 4, 6, 3 };
        printArr(nextSmallerElement(arr2));
        int arr3[] = { 2, 1, 4, 3 };
        printArr(nextSmallerElement(arr3));
        int arr4[] = { 1, 3, 2 };
        printArr(nextSmallerElement(arr4));
        int arr5[] = { 1, 2, 3, 4 };
        printArr(nextSmallerElement(arr5));
        int arr6[] = { 2, 6, 8, 9, 3 };
        printArr(nextSmallerElement(arr6));
    }
}
