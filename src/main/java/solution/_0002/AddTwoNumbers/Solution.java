package solution._0002.AddTwoNumbers;

// https://leetcode.cn/problems/add-two-numbers/
public class Solution {

    public static void main(String[] args) {

        ListNode l1 = toList(2, 4, 3);
        ListNode l2 = toList(1, 5, 6, 4);


        printList(new Solution().addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;

        ListNode p1 = l1, p2 = l2;

        int rem = 0;
        while (p1 != null || p2 != null) {

            int v1 = p1 == null ? 0 : p1.val;
            int v2 = p2 == null ? 0 : p2.val;

            int sum = v1 + v2 + rem;

            int val = sum % 10;
            rem = sum / 10;

            tail.next = new ListNode(val);;
            tail = tail.next;

            p1 = p1 == null ? null : p1.next;
            p2 = p2 == null ? null : p2.next;
        }

        if (rem > 0) {
            tail.next = new ListNode(rem);;
        }

        return head.next;
    }

    private static ListNode toList(int... numbers) {
        ListNode head = new ListNode();
        ListNode tail = head;

        for (int number : numbers) {
            tail.next = new ListNode(number);
            tail = tail.next;
        }

        return head.next;
    }

    private static void printList(ListNode head) {
        ListNode p = head;
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
        System.out.println();
    }

    //Definition for singly-linked list.
    static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

}
