import java.util.Stack;

public class NextAndPrevSmaller2 {
    public static int[] nextSmaller(int arr[]) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!st.empty() && arr[i] < arr[st.peek()]) {
                // means, ith elemnt is the nextsmaller of the element index present in stack
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

    public static int[] prevSmaller(int arr[]) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!st.empty() && arr[i] < arr[st.peek()]) {
                // means, ith elemnt is the prevsmaller of the element index present in stack
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
