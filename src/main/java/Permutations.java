import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums==null || nums.length==0) { return res; }
        int n = nums.length;
        Arrays.sort(nums);
        // TODO

        return res;
    }

    public List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int n = nums.length;
        Arrays.sort(nums);
        res.add(Arrays.asList(nums[0]));
        for (int i=1;i<n;i++) { // for all left number
            int size = res.size();
            for (int j=0;j<size;j++) {  // loop valid lists
                Set<List<Integer>> set = new HashSet<>();
                List<Integer> list = res.remove(0);
                for (int k=list.size();k>=0;k--) { //
                    List<Integer> tmp = new ArrayList<>(list);
                    tmp.add(k, nums[i]);
                    if (set.add(tmp)) {
                        res.add(tmp);
                    }
                }
            }
        }
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                for (int i=0;i<o1.size()&&i<o2.size();i++) {
                    if (o1.get(i) != o2.get(i)) {
                        return o1.get(i) - o2.get(i);
                    }
                }
                return 0;
            }
        });
        return res;

    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        int[] nums = new int[]{1,1,2,3};
        List<List<Integer>> res = permutations.permute2(nums);
        Printer.printNestedList(res);
    }

}
