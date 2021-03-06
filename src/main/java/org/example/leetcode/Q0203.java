package org.example.leetcode;

/**
 * 203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 *
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
 * @author : jeymingwu
 * @date : 2021-06-05
 **/

public class Q0203 {

    public ListNode removeElements(ListNode head, int val) {

        // 方法一
//        ListNode newHead = new ListNode();
//        ListNode listNode = new ListNode();
//        newHead.next = listNode;
//
//        for (ListNode node = head; node != null; node = node.next) {
//            if (node.val != val) {
//                ListNode tmp = new ListNode(node.val);
//                listNode.next = tmp;
//                listNode = listNode.next;
//            }
//        }
//
//        return newHead.next.next;

//        // 方法二
//        while (head != null && head.val == val) {
//            head = head.next;
//        }
//
//        if (head == null) {
//            return null;
//        }
//
//        ListNode node = head;
//        while (node.next != null) {
//            if (node.next.val == val) {
//                node.next = node.next.next;
//            } else {
//                node = node.next;
//            }
//        }
//        return head;

        ListNode p = head, res = p;
        while (p != null && p.next != null) {

            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }

        return (res != null && res.val == val) ? res.next : res;
    }

}
