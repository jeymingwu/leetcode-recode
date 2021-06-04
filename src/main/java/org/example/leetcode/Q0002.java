package org.example.leetcode;

/**
 * 2. 两数相加
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author : jeymingwu
 * @date : 2021-06-04
 **/
public class Q0002 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode node1 = l1;
        ListNode node2 = l2;

        int ten = 0;

        ListNode node = new ListNode();
        ListNode res = node;

        while (node1 != null || node2 != null) {

            int tmp = (node1 == null ? 0 : node1.val)
                    + (node2 == null ? 0 : node2.val)
                    + ten;

            if (tmp >= 10) {
                tmp = tmp - 10;
                ten = 1;
            } else {
                ten = 0;
            }

            ListNode listNode = new ListNode(tmp);
            node.next = listNode;
            node = node.next;
            node1 = node1 == null ? null : node1.next;
            node2 = node2 == null ? null : node2.next;
        }

        if (ten != 0) {
            ListNode listNode = new ListNode(ten);
            node.next = listNode;
        }

        return res.next;
    }
}
