public class MergeTwoBinaryMaxHeap {
    public static void heapify(int[] c, int i, int length) {
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int largestIndex = i;
            if (left < length && c[left] > c[largestIndex]) {
                largestIndex = left;
            }

            if (right < length && c[right] > c[largestIndex]) {
                largestIndex = right;
            }

            if (i == largestIndex) {
                break;
            }

            int temp = c[i];
            c[i] = c[largestIndex];
            c[largestIndex] = temp;
            i = largestIndex;
        }
    }

    public static int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        // step 1: merge two heap array
        int c[] = new int[n + m];
        System.arraycopy(a, 0, c, 0, n);
        System.arraycopy(b, 0, c, n, m);

        // step 2: let's heapify array c
        for (int i = c.length / 2; i >= 0; i--) {
            heapify(c, i, c.length);
        }
        return c;
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a[] = { 10, 5, 6, 2 },
                b[] = { 12, 7, 9 };
        int res[] = mergeHeaps(a, b, a.length, b.length);
        printArr(res);
    }
}
