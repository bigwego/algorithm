class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, rec = m + n - 1;
        while (i > -1 && j > -1) {
            if (nums1[i] > nums2[j]) {
                nums1[rec--] = nums1[i--];
            } else {
                nums1[rec--] = nums2[j--];
            }
        }
        while (i > -1) {
            nums1[rec--] = nums1[i--];
        }
        while (j > -1) {
            nums1[rec--] = nums2[j--];
        }
    }
}
