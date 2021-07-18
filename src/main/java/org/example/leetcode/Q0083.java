package org.example.leetcode;

/**
 * 83. 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 *
 * 返回同样按升序排列的结果链表。
 *
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 *
 * @author : jeymingwu
 * @date : 2021-07-18
 **/

public class Q0083 {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode node = head.next, preNode = head;
        int val = head.val;

        while (node != null) {

            if (val == node.val) {
                preNode.next = node.next;
            } else {
                preNode = preNode.next;
                val = node.val;
            }
            node = node.next;
        }
        return head;
    }
}
