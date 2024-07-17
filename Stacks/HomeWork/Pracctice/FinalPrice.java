import java.util.Stack;

public class FinalPrice {
    public static int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack<>();

        for (int i = prices.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() > prices[i]) {
                st.pop();
            }
            int price = prices[i];

            if (!st.isEmpty()) {
                prices[i] -= st.peek();
            }

            st.push(price);
        }

        return prices;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int prices1[] = { 8, 4, 6, 2, 3 };
        printArr(finalPrices(prices1));
        int prices2[] = { 10, 1, 1, 6 };
        printArr(finalPrices(prices2));
        int prices3[] = { 1, 2, 3, 4, 5 };
        printArr(finalPrices(prices3));
    }
}
