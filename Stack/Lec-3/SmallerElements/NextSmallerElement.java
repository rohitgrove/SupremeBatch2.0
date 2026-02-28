import java.util.Stack;

public class NextSmallerElement {
    public static int[] nextSmallerElement(int arr[]) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int ans[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int curr = arr[i];
            // answer find karo curr k liye
            while (st.peek() >= curr) {
                st.pop();
            }

            ans[i] = st.peek();
            st.push(curr);
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