import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class RevealCardInIncreasingCard {
    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> q = new LinkedList<>();
        int ans[] = new int[deck.length]; 

        // put indices of ans into q
        for (int i = 0; i < ans.length; i++) {
            q.add(i);
        }

        // reverse simulation + filling using sorted deck.
        for (int i = 0; i < deck.length; i++) {
            // 1. Reveal
            ans[q.poll()] = deck[i];
            
            // 2. push front to bottom
            if (!q.isEmpty()) {
                q.add(q.poll());
            }
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
        int deck1[] = { 17, 13, 11, 2, 3, 5, 7 };
        printArr(deckRevealedIncreasing(deck1));
        int deck2[] = { 1, 1000 };
        printArr(deckRevealedIncreasing(deck2));
    }
}
