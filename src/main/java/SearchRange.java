import Utils.Printer;

public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        if (nums==null || nums.length==0) { return res; }
        int start = 0, end = nums.length-1;
        while(start < end) {
            int mid = (start + end) / 2;    // 向下取整
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            res[0] = start;
        }
        start = 0; end = nums.length-1;
        while(start < end) {
            int mid = (start + end + 1) / 2;    // 向上取整
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        if (nums[start] == target) {
            res[1] = start;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        int[] res = null;
        SearchRange searchRange = new SearchRange();
        res = searchRange.searchRange(nums, target);
//        Assert.that(res == new int[]{3,4}, "Error1: ");
        Printer.printIntArray(res);

        nums = new int[]{5,7,7,8,8,10};
        target = 6;
        res = searchRange.searchRange(nums, target);
//        Assert.that(res == new int[]{-1,-1}, "Error2: ");
        Printer.printIntArray(res);
    }
}
