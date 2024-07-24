import java.util.Stack;

public class NextAndPrevSmaller {
    public static int[] nextSmaller(int arr[]) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int ans[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            int curr = arr[i];
            // anser find karo curr k liye
            while (!st.isEmpty() && st.peek() >= curr) {
                st.pop();
            }

            ans[i] = st.peek();

            st.push(curr);
        }

        return ans;
    }

    public static int[] prevSmaller(int arr[]) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int ans[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int curr = arr[i];
            // anser find karo curr k liye
            while (!st.isEmpty() && st.peek() >= curr) {
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
        int[] arr1 = { 8, 4, 6, 2, 3 };
        int[] arr2 = { 4, 1, 6, 3 };
        int[] arr3 = { 2, 6, 8, 9, 3 };
        System.out.println("Original Arr");
        printArr(arr1);
        printArr(arr2);
        printArr(arr3);
        System.out.println("Next Smaller");
        printArr(nextSmaller(arr1));
        printArr(nextSmaller(arr2));
        printArr(nextSmaller(arr3));
        System.out.println("Prev Smaller");
        printArr(prevSmaller(arr1));
        printArr(prevSmaller(arr2));
        printArr(prevSmaller(arr3));
    }
}
