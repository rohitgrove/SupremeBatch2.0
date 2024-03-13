public class FindAllOddOccuringnumber {
    public static int findOddOccuringElement(int[] nums, int length) {
        int s = 0;
        int e = length - 1;
        int mid = s + (e - s) / 2;
        while (s <= e) {
            if (s == e) {
                return s;
            }

            if ((mid & 1) == 1) {
                if (mid >= 0 && nums[mid] == nums[mid - 1]) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            } else {
                if (mid < length && nums[mid] == nums[mid + 1]) {
                    s = mid + 2;
                } else {
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