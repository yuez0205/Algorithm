package Utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Printer {

    public static void printIntArray(int[] nums) {
        if (nums == null) { return; }
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void print2DIntArray(int[][] nums) {
        if (nums == null || nums.length == 0) { return; }
        for (int[] num : nums) {
            printIntArray(num);
        }
        System.out.println();
    }

    public static void printList(List list) {
        if (list == null) { return; }
        for (int i=0;i<list.size();i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    public static void printListNode(ListNode node) {
        System.out.print("ListNode: [ ");
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.print("]");
    }

    public static void printNestedList(List<List<Integer>> lists) {
        if (lists == null) { return; }
        for (int i=0;i<lists.size();i++) {
            printList(lists.get(i));
        }
        System.out.println();
    }

    public static void convertInput(String input) {
        input = input.replace("[", "{");
        input = input.replace("]", "}");
        System.out.println(input);
    }

    public static void printTreeNodeByLevel(TreeNode root) {
        if (root == null)  {
            System.out.println("null");
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static void printWithExpectResult(int actual, int expected) {
        System.out.println("Actual value is " + actual + ", expected value is " + expected);
    }

    public static void printWithExpectResult(boolean actual, boolean expected) {
        System.out.println("Actual value is " + actual + ", expected value is " + expected);
    }

    public static void main(String[] args) {
    }
}
