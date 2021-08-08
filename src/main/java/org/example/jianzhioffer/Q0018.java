package org.example.jianzhioffer;

import org.example.leetcode.ListNode;

/**
 * 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 *
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 *
 * @author : jeymingwu
 * @date : 2021-08-09
 **/

public class Q0018 {

    public ListNode deleteNode(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        if (head.val == val) {
            return head.next;
        }

        ListNode preNode = head;
        ListNode node = head.next;

        while (node != null) {

            if (node.val == val) {
                preNode.next = node.next;
                break;
            } else {
                preNode = preNode.next;
                node = node.next;
            }

        }

        return head;
    }
}
