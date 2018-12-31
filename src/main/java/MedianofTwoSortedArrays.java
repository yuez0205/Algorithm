public class MedianofTwoSortedArrays {

    // find kth
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0;
        }
        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {
            return (helper(nums1, nums2, 0, 0, len/2) + helper(nums1, nums2, 0, 0, len/2+1)) / 2.0;
        } else {
            return helper(nums1, nums2, 0, 0, len/2+1);
        }
    }

    private double helper(int[] nums1, int[] nums2, int s1, int s2, int k) {
        if (s1 >= nums1.length) {
            return nums2[s2+k-1];
        }
        if (s2 >= nums2.length) {
            return nums1[s1+k-1];
        }
        if (k == 1) { // first number
            return Math.min(nums1[s1], nums2[s2]);
        }
        int num1 = (s1+k/2-1 >= nums1.length) ? Integer.MAX_VALUE : nums1[s1+k/2-1];
        int num2 = (s2+k/2-1 >= nums2.length) ? Integer.MAX_VALUE : nums2[s2+k/2-1];
        if (num1 < num2) {
            return helper(nums1, nums2, s1+k/2, s2, k-k/2);
        } else {
            return helper(nums1, nums2, s1, s2+k/2, k-k/2);
        }
    }
}
