import java.util.Stack;

public class NextSmaller2 {
    public static void main(String[] args) {
        int[] arr1 = { 8, 4, 6, 2, 3 };
        System.out.println("Array 1");
        printArr(arr1);
        printArr(nextSmaller(arr1));
        printArr(prevSmaller(arr1));
        int[] arr2 = { 4, 1, 6, 3 };
        System.out.println("Array 2");
        printArr(arr2);
        printArr(nextSmaller(arr2));
        printArr(prevSmaller(arr2));
    }

    public static int[] nextSmaller(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int res[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!st.empty() && arr[st.peek()] > arr[i]) {
                int adults = st.pop();
                res[adults] = arr[i];
            }

            st.push(i);
        }

        while (!st.empty()) {
            res[st.pop()] = -1;
        }

        return res;
    }

    public static int[] prevSmaller(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int res[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.empty() && arr[st.peek()] > arr[i]) {
                int adults = st.pop();
                res[adults] = arr[i];
            }

            st.push(i);
        }

        while (!st.empty()) {
            res[st.pop()] = -1;
        }

        return res;
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
