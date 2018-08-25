import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        if (nums==null || nums.length<3) { return Integer.MIN_VALUE; }
        int n = nums.length;
        int res = nums[0] + nums[1] + nums[n-1];
        Arrays.sort(nums);
        for (int i=0;i<n-2;i++)  {
//            if (i>0 && nums[i] == nums[i-1]) { continue; }
            int start = i+1, end = n-1;
            while(start < end) {
//                while(start<end && start > i+1 && nums[start] == nums[start-1]) {
//                    ++start;
//                }
//                while (start<end && end+1 < n && nums[end] == nums[end+1]) {
//                    --end;
//                }
//                if (start < end) {
                    int sum = nums[i] + nums[start] + nums[end];
                    if (Math.abs(target - sum) < Math.abs(target - res)) {
                        res = sum;
                    }
                    if (sum == target) {
                        return target;
                    } else if (sum < target) {
                        ++start;
                    } else {
                        --end;
                    }
//                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSumClosest closest = new ThreeSumClosest();
        int[] nums = {0,0,0}; int target = 1;
        System.out.println(closest.threeSumClosest(nums, target));
        nums = new int[]{0,1,2}; target = 0;
        System.out.println(closest.threeSumClosest(nums, target));
    }
}
