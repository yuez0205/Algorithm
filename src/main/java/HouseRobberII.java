public class HouseRobberII {

    // solution 1: two pass
    public int rob(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) { return nums[0]; }
        return Math.max(rob(nums, 0, n-2), rob(nums, 1, n-1));
    }

    public int rob(int[] nums, int start, int end) {
        int rob = nums[start];
        int not = 0;
        for (int i=start+1;i<=end;i++) {
            int lastRob = rob, lastNot = not;
            rob = nums[i] + lastNot;
            not = Math.max(lastNot, lastRob);
        }
        return Math.max(rob, not);
    }

    // solution 2 : one pass
    public int rob2(int[] nums) {
        if (nums==null || nums.length==0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) { return nums[0]; }
        int rob1 = nums[0], not1 = 0; // start from 1st house
        int rob2 = 0, not2 = 0;  // start from 2nd house
        for (int i=1;i<n;i++) {
            int lastRob = rob1, lastNot = not1;
            if (i < n-1) {
                rob1 = nums[i] + lastNot;
                not1 = Math.max(lastNot, lastRob);
            }
            lastRob = rob2; lastNot = not2;
            rob2 = nums[i] + lastNot;
            not2 = Math.max(lastNot, lastRob);
        }
        return Math.max(Math.max(rob1, not1), Math.max(rob2, not2));
    }
}
