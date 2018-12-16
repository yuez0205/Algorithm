import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    public List<String> findMissingRanges(int[] nums, long lower, long upper) {
        List<String> res = new ArrayList<>();
        int n = nums.length;
        for (int i=0;i<n;i++) {
            if (nums[i] < lower || i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            if (nums[i] == lower) {
                ++lower;
                continue;
            }
            res.add(getRange(lower, Math.min((long)nums[i]-1, upper)));  // inclusive
            lower = (long)nums[i]+1;

        }
        if(lower <= upper) {
            res.add(getRange(lower, upper));
        }
        return res;
    }

    public String getRange(long low, long high) {
        if (low > high) { return ""; }
        if (low == high) {
            return low+"";
        } else {
            return low+"->"+high;
        }
    }

    public static void main(String[] args) {
        MissingRanges missingRanges = new MissingRanges();
        int[] nums = new int[]{0, 1, 3, 50, 75, 100, 150};
        Printer.printList(missingRanges.findMissingRanges(nums, 0, 99));
        nums = new int[]{-2147483648,-2147483648,0,2147483647,2147483647};
        Printer.printList(missingRanges.findMissingRanges(nums, -2147483648, 2147483647));
        nums = new int[]{2147483647, 2147483647};
        Printer.printList(missingRanges.findMissingRanges(nums, 2147483647, 2147483647));
    }
}
