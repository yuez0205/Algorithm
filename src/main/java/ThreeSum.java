import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int start = i + 1, end = n - 1;
            while (start < end) {
                while (start < end && start > i + 1 && nums[start] == nums[start-1]) {
                    ++start;
                }
                while (start < end && end < n - 1 && nums[end] == nums[end+1]) {
                    --end;
                }
                if (start < end) {
                    int sum = nums[i] + nums[start] + nums[end];
                    if (sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[start++], nums[end--]));
                    } else if (sum > 0) {
                        --end;
                    } else {
                        ++start;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum.threeSum(nums));

    }
}
