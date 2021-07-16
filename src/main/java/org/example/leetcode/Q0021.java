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

        // 方法一：迭代
//        ListNode p = new ListNode();
//        ListNode head = p;
//
//        while (l1 != null || l2 != null) {
//
//            if ((l1 != null && l2 != null && l1.val <= l2.val) || (l2 == null)) {
//                p.next = l1;
//                l1 = l1.next;
//            } else {
//                p.next = l2;
//                l2 = l2.next;
//            }
//            p = p.next;
//        }
//
//        return head.next;

        // 方法二：递归

        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
