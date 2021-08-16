package solution._203.RemoveLinkedListElements;

import model.ListNode;
import util.ListUtil;

import java.util.List;

public class Solution {

    public static void main(String[] args) {

        ListNode head = ListUtil.generateLinkedList(7,4,7,7);

        head = removeElementsRecursive(head,4);

        ListUtil.printList(head);

    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode headNode = new ListNode(-1,head);
        ListNode p = headNode;
        while (p.next != null){
            if (p.next.val == val){
                //元素置空，可移除
                ListNode node = p.next;

                p.next = p.next.next;

                //元素置空，可移除
                node.next = null;
            }else {
                p = p.next;
            }
        }
        return headNode.next;
    }

    //递归解法
    public static ListNode removeElementsRecursive(ListNode head, int val) {
        if (head == null){
            return head;
        }

        head.next = removeElementsRecursive(head.next,val);

        return head.val == val ? head.next : head;

    }

}
