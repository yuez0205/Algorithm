import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {

    final String SPRT = ",";
    final String NULL = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        System.out.println(sb.toString());
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL).append(SPRT);
        } else {
            sb.append(node.val).append(SPRT);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(SPRT);
        Queue<String> queue = new LinkedList<>(Arrays.asList(strs));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {
        if (queue.isEmpty()) { return null; }
        String str = queue.poll();
        if (str.equals(NULL)) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.parseInt(str));
            node.left = buildTree(queue);
            node.right = buildTree(queue);
            return node;
        }
    }
}
