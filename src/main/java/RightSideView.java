import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RightSideView {

    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int depth) {
        if (root == null) { return; }
        if (res.size() == depth) {
            res.add(root.val);
        }
        helper(root.right, depth + 1);
        helper(root.left, depth + 1);
    }
}
