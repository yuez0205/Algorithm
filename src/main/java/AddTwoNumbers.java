
public class AddTwoNumbers {

    // ListNode value相加超出int范围（32bits）, 甚至long
    // 所以不先算总和，边算边生成新node

    // Time complexity : O(max(m, n))
    // Space complexity : O(max(m,n))

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tmp = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            sum = sum % 10;
            ListNode node = new ListNode(sum);
            tmp.next = node;
            tmp = node;
        }
        if (carry != 0) {
            tmp.next = new ListNode(carry);
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        // test int overflow
        ListNode l1 = ListNode.buildFromArray(new int[] {9});
        ListNode l2 = ListNode.buildFromArray(new int[] {1,9,9,9,9,9,9,9});
        ListNode res = addTwoNumbers.addTwoNumbers(l1, l2);
        ListNode.printListNode(res);

//        ListNode l3 = ListNode.buildFromArray(new int[] {2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9});
//        ListNode l4 = ListNode.buildFromArray(new int[] {5,6,4,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9,9,9,9});
//        ListNode res2 = addTwoNumbers.addTwoNumbers(l3, l4);
//        ListNode.printListNode(res2);
//        ListNode expect = ListNode.buildFromArray(new int[] {7,0,8,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,4,8,6,1,4,3,9,1});
//        ListNode.printListNode(expect);
    }


}
