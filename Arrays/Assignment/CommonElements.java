import java.util.ArrayList;

public class CommonElements {
    public static ArrayList<Integer> findCommonElements(int A[], int B[], int C[], int n1, int n2, int n3) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        while (i < n1 && j < n2 && k < n3) {
            // Skip duplicates in A, B And C
            while (i > 0 && i < n1 && A[i] == A[i - 1]) {
                i++;
            }

            while (j > 0 && j < n2 && B[j] == B[j - 1]) {
                j++;
            }

            while (k > 0 && k < n3 && C[k] == C[k - 1]) {
                k++;
            }
            // Check for common elements
            if (i < n1 && j < n2 && k < n3) {
                if (A[i] == B[j] && B[j] == C[k]) {
                    ans.add(A[i]);
                    i++;
                    j++;
                    k++;
                } else if (A[i] < B[j]) {
                    i++;
                } else if (B[j] < C[k]) {
                    j++;
                } else {
                    k++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int n1 = 6, A[] = { 1, 5, 10, 20, 40, 80 };
        int n2 = 5, B[] = { 6, 7, 20, 80, 100 };
        int n3 = 8, C[] = { 3, 4, 15, 20, 30, 70, 80, 120 };

        System.out.println("Common Elements: ");
        System.out.println(findCommonElements(A, B, C, n1, n2, n3));
    }
}
