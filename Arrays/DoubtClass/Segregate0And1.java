public class Segregate0And1 {
    public static void segregate0and1(int[] arr) {
        int l = 0;
        int h = arr.length - 1;

        while (l < h) {
            // 1. increment kardo jab mujhe low par 0 dikhe
            if (arr[l] == 0) {
                l++;
            }

            // 2. jab jab 1 dikhe high par decrement
            else if (arr[h] == 1) {
                h--;
            } else {
                // swap
                int temp = arr[l];
                arr[l] = arr[h];
                arr[h] = temp;
                l++;
                h--;
            }
        }
    }

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr1[] = { 0, 0, 1, 1, 0 };
        segregate0and1(arr1);
        printArr(arr1);
        int arr2[] = { 1, 1, 1, 1 };
        segregate0and1(arr2);
        printArr(arr2);
    }
}