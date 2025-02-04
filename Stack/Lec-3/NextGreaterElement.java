import java.util.Stack;

public class NextGreaterElement {
    public static int[] nextGreaterElements(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int ans[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                int kids = st.pop();
                ans[kids] = arr[i];
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
        int arr2[] = { 2, 1, 4, 6, 3 };
        int arr3[] = { 2, 1, 4, 3 };
        int arr4[] = { 1, 3, 2 };
        int arr5[] = { 1, 2, 3, 4 };
        int arr6[] = { 2, 6, 8, 9, 3 };
        System.out.println("Arrays: ");
        printArr(arr1);
        printArr(arr2);
        printArr(arr3);
        printArr(arr4);
        printArr(arr5);
        printArr(arr6);
        System.out.println("Results: ");
        printArr(nextGreaterElements(arr1));
        printArr(nextGreaterElements(arr2));
        printArr(nextGreaterElements(arr3));
        printArr(nextGreaterElements(arr4));
        printArr(nextGreaterElements(arr5));
        printArr(nextGreaterElements(arr6));
    }
}
