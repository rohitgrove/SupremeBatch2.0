import java.util.Stack;

public class FinalPricesWithSpecialDiscountInShop {
    public static int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();

        for (int i = prices.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            int price = prices[i];
            if (!stack.isEmpty()) {
                prices[i] -= stack.peek();
            }
            stack.push(price);
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