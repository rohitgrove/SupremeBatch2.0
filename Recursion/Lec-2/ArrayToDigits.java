public class ArrayToDigits {
    public static int arrToDigit(int arr[], int index, int num) {
        if (index == arr.length) {
            return num;
        }

        int digit = arr[index];
        num = num * 10 + digit;
        return arrToDigit(arr, index + 1, num);
    }

    public static int arrToDigit(int arr[]) {
        int ans = 0;

        for (int i = 0; i < arr.length; i++) {
            int digit = arr[i];
            ans = ans * 10 + digit;
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 1, 5 };
        System.out.println(arrToDigit(arr, 0, 0));
    }
}
