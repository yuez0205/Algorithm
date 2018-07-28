import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] solution2(int[] nums, int target) {
        int[] res = new int[2];
        if(nums==null || nums.length==0) {
            return res;
        }
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++) {
            if(map.containsKey(target-nums[i])) {
                res[1] = i;
                res[0] = map.get(target-nums[i]);
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }

     public int[] solution1(int[] nums, int target) {
         int[] res = new int[2];
         if(nums==null || nums.length==0) {
             return res;
         }
         int n = nums.length;
         for(int i=0;i<n;i++) {
             for(int j=i+1;j<n;j++) {
                 if(nums[i] + nums[j] == target) {
                     return new int[] { i, j };
                 }
             }
         }
         return res;
     }

     public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] nums = new int[] {2, 7, 11, 15};
        int target = 9;
        int[] res1 = twoSum.solution1(nums, target);
        Printer.printIntArray(res1);
        int[] res2 = twoSum.solution2(nums, target);
        Printer.printIntArray(res2);

     }
}
