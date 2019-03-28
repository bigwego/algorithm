class ContainerWithMostWater {
    public int maxArea(int[] height) {
       int left = 0, right = height.length - 1, res = 0;
		while (left < right) {
			res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
			if (height[left] > height[right]) {
				right--;
			} else {
				left++;
			}
		}
		return res;
    }
}
