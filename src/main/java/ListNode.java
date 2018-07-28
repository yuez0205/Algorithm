public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static void printListNode(ListNode node) {
        System.out.println("------ print list node ------");
        ListNode tmp = node;
        while (tmp != null) {
            System.out.print(tmp.val);
            if (tmp.next != null) {
                System.out.print("->");
            }
            tmp = tmp.next;
        }
        System.out.println();
    }

    public static ListNode buildFromArray(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        for (int num : nums) {
            ListNode node = new ListNode(num);
            tmp.next = node;
            tmp = node;
        }
        return dummy.next;
    }
}
