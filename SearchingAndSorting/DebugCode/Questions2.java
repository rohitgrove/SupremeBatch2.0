public class Questions2 {
    public static int mySqrt(int x) {
        if (x == 0)
            return x;
        int first = 1, last = x;

        while (first <= last) {
            int mid = first + (last - first) / 2;
            if (mid == x / mid)
                return mid;
            else if (mid > x / mid) {
                last = mid - 1; // Adjust last pointer
            } else {
                first = mid + 1; // Adjust first pointer
            }
        }
        return last; // Return mid after the loop
    }

    public static void main(String[] args) {
        int number = 16; // Example input
        int result = mySqrt(number);
        System.out.println("Square root of " + number + " is: " + result);
    }
}
