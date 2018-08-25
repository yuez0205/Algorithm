import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum3 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k<=0 || n<=0) { return res; }
         helper(0, 0, 0, n, k, new ArrayList<Integer>());
        return res;
    }

    private void helper(int i, int sum, int count, int target, int totalCount, List<Integer> list) {
        if (sum == target && count == totalCount) {
            res.add(list);
            return;
        }
        if (sum >= target || count >= totalCount) { return; }
        for (int j=i+1;j<=9;j++) { // 1-9
            List<Integer> tmp = new ArrayList<>(list);
            tmp.add(j);
            helper(j, sum+j, count+1, target, totalCount, tmp);
        }
    }

    public static void main(String[] args) {
        CombinationSum3 sum3 = new CombinationSum3();
        System.out.println(sum3.combinationSum3(3, 7));
    }
}
