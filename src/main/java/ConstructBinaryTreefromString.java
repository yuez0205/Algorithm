import java.util.Stack;

public class ConstructBinaryTreefromString {

    int i, j, n;
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        n = s.length();
        Stack<TreeNode> stack = new Stack<>();
        Stack<Boolean> hasLeft = new Stack<>();
        i = 0;
        TreeNode root = new TreeNode(getNum(s));
        stack.push(root);
        hasLeft.push(false);
        i = j;
        while (i < n) {
            if (s.charAt(i) == '(') {
                ++i;
                TreeNode node = null;
                int num = getNum(s);
                if (j > i) {
                    node = new TreeNode(num);
                }
                i = j;
                TreeNode parent = stack.peek();
                if (!hasLeft.pop()) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
                hasLeft.push(true);
                stack.push(node);
                hasLeft.push(false);
            } else if (s.charAt(i) == ')') {
                stack.pop();
                hasLeft.pop();
                ++i;
            }
        }
        return root;
    }

    public int getNum(String s) {
        boolean negative = false;
        j = i;
        if (j < n && s.charAt(j) == '-') {
            negative = true;
            ++i;
            ++j;
        }
        while (j < n && Character.isDigit(s.charAt(j))) {
            ++j;
        }
        int num = Integer.valueOf(s.substring(i, j));
        return negative ? 0 - num : num;
    }

    // solution 2 : recursive
    public TreeNode str2tree2(String s) {
        if (s == null || s.length() == 0) return null;
        int firstParen = s.indexOf("(");
        int val = firstParen == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, firstParen));
        TreeNode cur = new TreeNode(val);
        if (firstParen == -1) return cur;
        int start = firstParen, leftParenCount = 0;
        for (int i=start;i<s.length();i++) {
            if (s.charAt(i) == '(') leftParenCount++;
            else if (s.charAt(i) == ')') leftParenCount--;
            if (leftParenCount == 0 && start == firstParen) {cur.left = str2tree(s.substring(start+1,i)); start = i+1;}
            else if (leftParenCount == 0) cur.right = str2tree(s.substring(start+1,i));
        }
        return cur;
    }

    public static void main(String[] args) {
        ConstructBinaryTreefromString constructor = new ConstructBinaryTreefromString();
        String input = "4(2(3)(1))(6(5))";
//        Printer.printTreeNodeByLevel(constructor.str2tree(input));
        input = "-4(2(3)(1))(6(5)(7))";
        Printer.printTreeNodeByLevel(constructor.str2tree(input));
    }
}
