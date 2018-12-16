import java.util.Arrays;

public class LongestIncreasingSubsequence {

    // solution 1: DP    O(n^2)
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] count = new int[n];
        Arrays.fill(count, 1);
        int max = 1;
        for (int i=1;i<n;i++) {
            for (int j=i-1;j>=0;j--) {
                if (nums[j] < nums[i]) {
                    count[i] = Math.max(count[j]+1, count[i]);
                }
            }
            max = Math.max(count[i], max);
        }
        return max;
    }


    // solution 2: binary search    O(nlogn)
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        int len = 0;
        for (int i=0;i<n;i++) {
            int idx = Arrays.binarySearch(dp, 0, len, nums[i]);
            if (idx < 0) {
                idx = -(idx + 1);
            }
            dp[idx] = nums[i];
            if (idx == len) {
                ++len;
            }
        }
        return len;
    }

}
