package solution._0237.DeleteNodeInaLinkedList;

import model.ListNode;

public class Solution {

    // 版本一，自实现方法，需要一直循环到最后
    public void deleteNodeCustom(ListNode node) {
        while (node.next.next != null){

            node.val = node.next.val;
            node = node.next;

        }

        node.val = node.next.val;
        node.next = null;

    }

    // 版本二，官方题解，只需复制下一个节点的值，同时修改该指针，指向  Next.next 即可
    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;

    }


}
