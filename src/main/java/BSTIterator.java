import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        storeLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if (stack.isEmpty()) {
            return 0;
        }
        TreeNode node = stack.pop();
        storeLeft(node.right);
        return node.val;
    }

    private void storeLeft(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

}
