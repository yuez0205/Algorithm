public class MinSubArrayLen {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        int n = nums.length;
        int minCount = Integer.MAX_VALUE;
        int start = 0, idx = 0, sum = 0;
        while (idx < n) {
            sum += nums[idx++];
            while (sum >= s) {
                minCount = Math.min(minCount, idx - start);
                sum -= nums[start++];
            }
        }
        return minCount==Integer.MAX_VALUE ? 0 : minCount;
    }
}
