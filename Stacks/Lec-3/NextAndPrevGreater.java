import java.util.Stack;

public class NextAndPrevGreater {
    public static int[] prevGreater(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.empty() && arr[i] > arr[st.peek()]) {
                // means, ith elemnt is the prevgreater of the element index present in stack
                int kids = st.pop();
                ans[kids] = arr[i];
            }
            st.push(i);
        }

        while (!st.empty()) {
            ans[st.pop()] = -1;
        }
        
        return ans;
    }

    public static int[] nextGreater(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.empty() && arr[i] > arr[st.peek()]) {
                // means, ith elemnt is the nextgreater of the element index present in stack
                int kids = st.pop();
                ans[kids] = arr[i];
            }
            st.push(i);
        }

        while (!st.empty()) {
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
        int[] arr1 = { 8, 4, 6, 2, 3 };
        int[] arr2 = { 4, 1, 6, 3 };
        int[] arr3 = { 2, 6, 8, 9, 3 };
        System.out.println("Original Arr");
        printArr(arr1);
        printArr(arr2);
        printArr(arr3);
        System.out.println("Next Greater");
        printArr(nextGreater(arr1));
        printArr(nextGreater(arr2));
        printArr(nextGreater(arr3));
        System.out.println("Prev Greater");
        printArr(prevGreater(arr1));
        printArr(prevGreater(arr2));
        printArr(prevGreater(arr3));
    }
}
