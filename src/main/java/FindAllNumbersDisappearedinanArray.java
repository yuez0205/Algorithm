import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {

    // solution 1 : sort array
    // Time : O(m+n)
    public List<Integer> findDisappearedNumbers(int[] nums){
        List<Integer> res = new ArrayList<>();
        if (nums==null || nums.length==0) { return res; }
        Arrays.sort(nums);
        int len = nums.length;
        int i = 0;
        for (int num=1;num<=len;++num) {
            if (i >= len || nums[i] > num) {
                res.add(num);
                continue;
            }
            while (i<len && nums[i] <= num) {
                ++i;
            }
        }
        return res;
    }

    public List<Integer> findDisappearedNumbers1(int[] nums){
        List<Integer> res = new ArrayList<>();
        if (nums==null || nums.length==0) { return res; }
        int len = nums.length;
        for (int num=1;num<=len;num++) {
            res.add(num);
        }
        for (int i=0;i<len;i++) {
            if (nums[i]-1 < len) {
                res.set(nums[i]-1, 0);
            }
        }
        for (int i=len-1;i>=0;i--) {
            if (res.get(i) == 0) {
                res.remove(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindAllNumbersDisappearedinanArray myClass = new FindAllNumbersDisappearedinanArray();
        int[] input = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> res = myClass.findDisappearedNumbers1(input);
        Printer.printList(res);


    }
}
