package org.example.jianzhioffer;

import org.example.leetcode.ListNode;

import java.util.Stack;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 *
 * @author : jeymingwu
 * @date : 2021-08-07
 **/

public class Q0022 {

    public ListNode getKthFromEnd(ListNode head, int k) {

        // 方法一：栈
//        Stack<ListNode> stack = new Stack<>();
//        while (head != null) {
//            stack.push(head);
//            head = head.next;
//        }
//
//        while (!stack.isEmpty()) {
//            ListNode pop = stack.pop();
//            --k;
//            if (k == 0) {
//                return pop;
//            }
//        }
//        return null;

        // 方法二：双指针法（两指针相差k个节点）
        ListNode res = head;
        int count = 0;
        while (head != null) {
            head = head.next;
            ++count;
            if (count >= k) {
                res = res.next;
            }
        }
        return res;
    }
}
