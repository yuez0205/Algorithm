public class SearchinRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums==null || nums.length==0) {
            return -1;
        }
        int start = 0, end = nums.length-1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) { return mid; }
            if (nums[mid] < target) {
                if (nums[start] <= target && nums[start] > nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[start] > target && nums[start] <= nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    /*
    If nums[mid] and target are "on the same side" of nums[0], we just take nums[mid]. Otherwise we use -infinity or +infinity as needed.
    */
    public int search1(int[] nums, int target) {
        if (nums==null || nums.length==0) {
            return -1;
        }
        int start = 0, end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int num = (nums[mid] < nums[0]) == (target < nums[0])
                    ? nums[mid]
                    : target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            if (num < target) {
                start = mid + 1;
            } else if (num > target) {
                end = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public int search2(int[] nums, int target) {
        if (nums==null || nums.length==0) {
            return -1;
        }
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            //check if nums[mid] and the target split into different sides
            boolean split = (nums[mid] >= nums[0]) != (target >= nums[0]);
            if (split) {
                // if split, need to check with the value nums[0]
                if (target >= nums[0]) high = mid;
                else low = mid + 1;
            } else {
                // if not split, just a normal binary search algorithm
                if (target > nums[mid]) low = mid + 1;
                else high = mid;
            }
        }
        return nums[low] == target ? low : -1;
    }
}
