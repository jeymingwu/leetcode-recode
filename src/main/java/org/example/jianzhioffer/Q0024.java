package org.example.jianzhioffer;

import org.example.leetcode.ListNode;

import java.util.Stack;

/**
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 *
 * @author : jeymingwu
 * @date : 2021-08-09
 **/

public class Q0024 {

    public ListNode reverseList(ListNode head) {

        // 方法一：遍历
//        Stack<ListNode> stack = new Stack<>();
//        while (head != null) {
//            stack.push(head);
//            head = head.next;
//        }
//
//        if (!stack.isEmpty()) {
//            ListNode node = stack.pop();
//            head = node;
//            while (!stack.isEmpty()) {
//                ListNode pop = stack.pop();
//                node.next = pop;
//                node = node.next;
//            }
//            node.next = null;
//        }
//
//        return head;

        // 方法一：遍历（改进）

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
