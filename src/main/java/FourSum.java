import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length<4) { return res; }
        int n = nums.length;
        Arrays.sort(nums);
        for (int i=0;i<n-3;i++) {
            if (i>0 && nums[i] == nums[i-1]) { continue; }
            for (int j=i+1;j<n-2;j++) {
                if (j>i+1 && nums[j]==nums[j-1]) { continue; }
                int start = j+1, end = n-1;
                while (start < end) {
                    while (start<end && start > j+1 && nums[start] == nums[start-1]) { ++start; }
                    while (start<end && end < n-1 && nums[end] == nums[end+1]) { --end; }
                    if (start < end) {
                        int sum = nums[i] + nums[j] + nums[start] + nums[end];
                        if (sum == target) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                            ++start;
                            --end;
                        } else if (sum > target){
                            --end;
                        } else {
                            ++start;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] nums = {0,0,1,1,2,2};
        int target = 3;
        List<List<Integer>> res = fourSum.fourSum(nums, target);
        System.out.println(res);

    }
}
