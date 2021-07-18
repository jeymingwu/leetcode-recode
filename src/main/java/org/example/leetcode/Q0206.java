package org.example.leetcode;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author : jeymingwu
 * @date : 2021-07-18
 **/

public class Q0206 {

    public ListNode reverseList(ListNode head) {

        // 方法一：迭代
//        ListNode node = null;
//
//        while (head != null){
//
//            if (node == null) {
//                node = new ListNode(head.val);
//            } else {
//                ListNode preNode = node;
//                node = new ListNode(head.val);
//                node.next = preNode;
//            }
//            head = head.next;
//        }
//
//        return node;

        // 方法一：迭代（精简代码）
//        ListNode node = null;
//
//        while (head != null){
//
//            ListNode preNode = node;
//            node = new ListNode(head.val);
//            node.next = preNode;
//            head = head.next;
//        }
//
//        return node;

        // 方法一：迭代

//        ListNode prev = null;
//        ListNode curr = head;
//        while (curr != null) {
//            ListNode next = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = next;
//        }
//        return prev;

        // 方法二：递归
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

}
