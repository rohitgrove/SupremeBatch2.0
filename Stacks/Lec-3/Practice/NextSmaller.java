import java.util.Stack;

public class NextSmaller {
    public static int[] nextSmallerRight(int arr[]) {
        Stack<Integer> st = new Stack<>(); 
        st.push(-1);

        int ans[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int curr = arr[i];

            while (st.peek() > curr) {
                st.pop();
            }

            ans[i] = st.peek();

            st.add(curr);
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
        printArr(arr1);
        printArr(nextSmallerRight(arr1));
        int[] arr2 = { 4, 1, 6, 3 };
        printArr(arr2);
        printArr(nextSmallerRight(arr2));
    }
}