import java.util.Stack;

public class PreviousGreaterElement {
    public static int[] previousGreaterElements(int[] arr) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int ans[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];

            while (st.peek() != -1 && st.peek() <= curr) {
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
        printArr(previousGreaterElements(arr1));
        printArr(previousGreaterElements(arr2));
        printArr(previousGreaterElements(arr3));
        printArr(previousGreaterElements(arr4));
        printArr(previousGreaterElements(arr5));
        printArr(previousGreaterElements(arr6));
    }
}
