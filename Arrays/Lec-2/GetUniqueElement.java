public class GetUniqueElement {
    public static int getUnique(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = ans ^ arr[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 10, 11, 10, 2, 15, 13, 15 };
        int ans = getUnique(arr);
        System.out.println("Final Answer is: " + ans);
    }
}