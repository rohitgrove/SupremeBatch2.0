public class ShiftNegativeOnLeftSide {
    public static void shiftNegativeOneSide(int arr[]) {
        int negtiveElement = 0;
        // j -> memory block -> jaha pr main negative
        // number store kr skta hu

        for (int index = 0; index < arr.length; index++) {
            // index -> entire array ko treverse karne k liye
            if (arr[index] < 0) {
                int temp = arr[index];
                arr[index] = arr[negtiveElement];
                arr[negtiveElement] = temp;
                negtiveElement++;
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
        int arr[] = { 23, -7, 12, -10, -11, 40, 60 };
        shiftNegativeOneSide(arr);
        printArr(arr);
    }
}