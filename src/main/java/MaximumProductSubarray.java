public class MaximumProductSubarray {
    public int maxProduct1(int[] nums) {
        if (nums==null || nums.length==0) { return 0; }
        int n = nums.length;
        int prd = 1;
        int max = Integer.MIN_VALUE;
        for (int i=0;i<n;i++) {
            prd = nums[i] * prd;
            max = Math.max(prd, max);
            if (nums[i] == 0) {
                prd = 1;
            }
        }
        prd = 1;
        for (int i=n-1;i>=0;i--) {
            prd = nums[i] * prd;
            max = Math.max(prd, max);
            if (nums[i] == 0) {
                prd = 1;
            }
        }
        return max;
    }

    public int maxProduct2(int[] nums) {
        if (nums==null || nums.length==0) { return 0; }
        int n = nums.length;
        int max = nums[0], min = nums[0];
        int res = nums[0];
        for (int i=1;i<n;i++) {
            int num = nums[i];
            if (num >= 0) {
                max = Math.max(max*num, num);
                min = Math.min(min*num, num);
            } else {
                int tmp = max;
                max = Math.max(min*num, num);
                min = Math.min(tmp*num, num);
            }
            res = Math.max(max, res);
        }
        return res;
    }
}
