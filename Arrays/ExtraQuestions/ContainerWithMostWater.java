public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE;

        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int currHieght = Math.min(height[left], height[right]);
            int currWidth = right - left;
            int currArea = currHieght * currWidth;
            maxArea = Math.max(maxArea, currArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int height[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(maxArea(height));
    }
}
