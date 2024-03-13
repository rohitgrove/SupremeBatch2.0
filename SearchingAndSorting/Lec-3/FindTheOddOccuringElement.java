public class FindTheOddOccuringElement {
    public static int findOddOccuringElement(int arr[], int n) {
        int s = 0;
        int e = n - 1;
        int mid = s + (e - s) / 2;

        while (s <= e) {

            // single element
            if (s == e) {
                return s;
            }

            // mid check -> even or odd
            if ((mid & 1) == 1) { // mid&1 -> true -> odd number
                if (mid - 1 >= 0 && arr[mid - 1] == arr[mid]) {
                    // right me jao
                    s = mid + 1;
                } else {
                    // left me jao
                    e = mid - 1;
                }
            } else {
                // even
                if (mid + 1 < n && arr[mid] == arr[mid + 1]) {
                    // right me jao
                    s = mid + 2;
                } else {
                    // ya toh main right part pr khada hu
                    // ya toh main answer k upar khada hu
                    // that's why e = mid krra hu
                    // kyoki e = mid - 1; se ans lost ho skta h
                    e = mid;
                }
            }
            mid = s + (e - s) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = { 10, 10, 2, 2, 3, 3, 2, 5, 5, 6, 6, 7, 7 };
        int ansIndex = findOddOccuringElement(nums, nums.length);
        System.out.println("Final ans is: " + ansIndex);
    }
}
