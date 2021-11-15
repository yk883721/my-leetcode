package solution._0206.ReverseLinkedList;

import model.ListNode;
import util.ListUtil;

public class Solution {

    public static void main(String[] args) {

        ListNode list = ListUtil.generateLinkedList(5,4,3,2,1);

        // 正常三指针方式
//        list = reverseList(list);

        // 递归形式
        list = reverseListR(list);

        ListUtil.printList(list);
    }

    // 一、初始三指针， pre, curr, next
    public static ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }

        ListNode preNode = null;
        ListNode p = head;
        ListNode nextNode = head.next;

        while (nextNode != null){
            p.next = preNode;
            preNode = p;
            p = nextNode;
            nextNode = nextNode.next;
        }

        p.next = preNode;
        return p;
    }

    // 二、递归形式
    public static ListNode reverseListR(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode lastNode = reverseListR(head.next);

        head.next.next = head;
        head.next = null;

        return lastNode;
    }

}
