import java.util.Stack;

public class NextGreater {
    public static void main(String[] args) {
        int[] arr1 = { 8, 4, 6, 2, 3 };
        System.out.println("Array 1");
        printArr(arr1);
        printArr(nextGreater(arr1));
        printArr(prevGreater(arr1));
        int[] arr2 = { 4, 1, 6, 3 };
        System.out.println("Array 2");
        printArr(arr2);
        printArr(nextGreater(arr2));
        printArr(prevGreater(arr2));
    }

    public static int[] prevGreater(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int res[] = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.empty() && arr[st.peek()] < arr[i]) {
                int kids = st.pop();
                res[kids] = arr[i];
            }

            st.push(i);
        }

        while (!st.empty()) {
            res[st.pop()] = -1;
        }

        return res;
    }

    public static int[] nextGreater(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int res[] = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!st.empty() && arr[st.peek()] < arr[i]) {
                int kids = st.pop();
                res[kids] = arr[i];           
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