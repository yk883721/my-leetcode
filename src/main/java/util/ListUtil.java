package util;

import model.ListNode;

public class ListUtil {


    public static void printList(ListNode list){
        while (list != null){
            System.out.print(list.val + " ");
            list = list.next;
        }
    }

    public static ListNode generateLinkedList(Integer... nums){

        ListNode head = new ListNode(-1);
        ListNode tail = head;

        for (Integer num : nums) {

            tail.next = new ListNode(num,null);
            tail = tail.next;

        }

        return head.next;

    }

}
