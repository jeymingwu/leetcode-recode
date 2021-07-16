package org.example.leetcode;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author : jeymingwu
 * @date : 2021-07-17
 **/

public class Q0021 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode p = new ListNode();
        ListNode head = p;

        while (l1 != null || l2 != null) {

            if ((l1 != null && l2 != null && l1.val <= l2.val) || (l2 == null)) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        return head.next;
    }
}
