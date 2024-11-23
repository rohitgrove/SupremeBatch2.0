public class PeakIndexInAMountainArray {
    public static int peakIndexInMountainArray(int[] arr) {
        int s = 0;
        int e = arr.length -1 ;
        
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] < arr[mid + 1]) {
                // A wali me hu
                // peak right me exist karti h
                s = mid + 1;
            } else {
                // yaa toh B line pr hu
                // ya toh main peak element pr hu
                e = mid; 
            }
        }

        return s;
    }

    public static void main(String[] args) {
        int nums[] = { 10, 20, 50, 40, 30 };
        System.out.println(peakIndexInMountainArray(nums));
    }
}
