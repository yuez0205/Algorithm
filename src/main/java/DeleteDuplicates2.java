public class DeleteDuplicates2 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head==null || head.next==null) { return head; }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(pre.next != null) {
            ListNode node = pre.next;
            boolean remove = false;
            while(node.next!=null && node.next.val==node.val) {
                node.next = node.next.next;
                remove = true;
            }
            if (remove) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        DeleteDuplicates2 duplicates2 = new DeleteDuplicates2();

        ListNode head = ListNode.buildFromArray(new int[]{1,1});
        Printer.printListNode(duplicates2.deleteDuplicates(head));

        ListNode head2 = ListNode.buildFromArray(new int[]{1,2,3,3,4,4,5});
        Printer.printListNode(duplicates2.deleteDuplicates(head2));
    }
}
