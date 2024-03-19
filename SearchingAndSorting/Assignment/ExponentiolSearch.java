public class ExponentiolSearch {
    public static int expSearch(int arr[], int x, int n) { //tc: Olog(2/2logm) aur yeah wala expression bhi bol scte hai O(−log(logm))
        if (arr[0] == x) {
            return 0;
        }

        int i = 1;
        while (i < n && arr[i] <= x) {
            i = i * 2;
        }

        return bs(arr, i / 2, Math.min(n - 1, i), x);
    }

    public static int bs(int nums[], int s, int e, int x) { 
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] == x) {
                return mid;                
            } else if (nums[mid] < x) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 4, 5, 6, 11, 13, 14, 15, 56, 70 };
        int n = arr.length;
        int x = 56;
        int ans = expSearch(arr, x, n);
        System.out.println(ans);
    }
}
