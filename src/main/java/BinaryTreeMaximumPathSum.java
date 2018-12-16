public class BinaryTreeMaximumPathSum {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root==null) { return 0; }
        getMaxSum(root);
        return max;
    }

    private int getMaxSum(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int left = getMaxSum(root.left);
        int right = getMaxSum(root.right);
        int sum = root.val;
        sum += left > 0 ? left : 0;
        sum += right > 0 ? right : 0;
        max = Math.max(max, sum);
        return Math.max(left, right)>0 ? root.val + Math.max(left, right) : root.val;
    }

}
