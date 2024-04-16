import java.util.ArrayList;

public class OddEvenNumbersInAnArr {
    public static void evenNumbers(int arr[], int index, ArrayList<Integer> even) {
        if (index == arr.length) {
            return;
        }

        if (arr[index] % 2 == 0) {
            even.add(arr[index]);
        }

        evenNumbers(arr, index + 1, even);
    }

    public static void oddNumbers(int arr[], int index, ArrayList<Integer> odd) {
        if (index == arr.length) {
            return;
        }

        if (arr[index] % 2 != 0) {
            odd.add(arr[index]);
        }

        oddNumbers(arr, index + 1, odd);
    }

    public static void main(String[] args) {
        int arr[] = { 10, 11, 12, 13, 4, 20, 31, 40, 51 };
        ArrayList<Integer> even = new ArrayList<>();
        evenNumbers(arr, 0, even);
        System.out.println(even);
        ArrayList<Integer> odd = new ArrayList<>();
        oddNumbers(arr, 0, odd);
        System.out.println(odd);
    }
}