package Array;

public class MedianOfTwoSortedArrays {

    private double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = (len1 + len2 + 1) / 2;
        int left = 0, right = nums1.length;
        while (left <= right) {
            int currX = (left + right) / 2;
            int currY = len - currX;
            int leftMaxX = currX == 0 ? Integer.MIN_VALUE : nums1[currX - 1];
            int leftMaxY = currY == 0 ? Integer.MIN_VALUE : nums2[currY - 1];
            int rightMinX = currX == len1 ? Integer.MAX_VALUE : nums1[currX];
            int rightMinY = currY == len2 ? Integer.MAX_VALUE : nums2[currY];
            if (leftMaxX <= rightMinY && leftMaxY <= rightMinX) {
                if ((len1 + len2) % 2 == 0) {
                    return (Math.max(leftMaxX, leftMaxY) + Math.min(rightMinX, rightMinY)) / 2.0;
                } else {
                    return Math.max(leftMaxX, leftMaxY);
                }
            } else if (leftMaxX > rightMinY) {
                right = currX - 1;
            } else {
                left = currX + 1;
            }
        }
        return -1;
    }
}
