import Utils.Printer;

import java.util.ArrayList;
import java.util.List;

public class CountofSmallerNumbersAfterSelf {

    // Solution 1 : maintain a sorted list
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i=n-1;i>=0;--i) {
            int idx = findIdx(list, nums[i]);
            res.add(0, idx);
            list.add(idx, nums[i]);
            // System.out.println(idx + " " + list);
        }
        return res;
    }

    public int findIdx(List<Integer> list, int target) {
        if (list.size() == 0)  { return 0; }
        int start = 0, end = list.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (list.get(start) >= target) { return start; }
        if (list.get(end) >= target) { return end; }
        return list.size();
    }

    // solution 2 : binary tree
    public List<Integer> countSmaller2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Node root = null;
        for (int i=nums.length-1;i>=0;i--) {
            root = buildTree(nums[i], root, 0, res);
        }
        return res;
    }

    public Node buildTree(int num, Node root, int preSum, List<Integer> res) {
        if (root == null) {
            root = new Node(num);
            res.add(0, preSum);
        } else if (root.val == num) {
            ++root.dup;
            res.add(0, preSum + root.sum);
        } else if (num > root.val) {
            root.right = buildTree(num, root.right, preSum + root.sum + root.dup, res);
        } else {
            ++root.sum;
            root.left = buildTree(num, root.left, preSum, res);
        }
        return root;
    }

    public class Node {
        int val;
        int dup;
        int sum;
        Node left, right;
        public Node(int val) {
            this.val = val;
            this.dup = 1;
            this.sum = 0;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,2,2,6,0,1};
        CountofSmallerNumbersAfterSelf counter = new CountofSmallerNumbersAfterSelf();
        Printer.printList(counter.countSmaller2(nums));
        int[] nums1 = {2,0,1};
//        Printer.printList(counter.countSmaller2(nums1));
    }
}
