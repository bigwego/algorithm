package Array;

public class TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0, right = height.length - 1, leftMax = 0, rightMax = 0, res = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            res += leftMax + rightMax - height[left] - height[right];
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public int trap2(int[] height) {
        if (height == null || height.length < 3) return 0;

        int l = 0, r = height.length - 1;
        int leftMax = height[0], rightMax = height[r];
        int res = 0;

        while (l < r) {
            leftMax = Math.max(leftMax, height[l]);
            rightMax = Math.max(rightMax, height[r]);
            res += leftMax - height[l] + rightMax - height[r];
            if (height[l] < height[r]) l++;
            else r--;
        }

        return res;
    }
}
