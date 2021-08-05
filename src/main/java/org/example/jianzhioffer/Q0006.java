package org.example.jianzhioffer;

import org.example.leetcode.ListNode;

import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 *
 * @author : jeymingwu
 * @date : 2021-08-05
 **/

public class Q0006 {

    public int[] reversePrint(ListNode head) {

        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        int index = 0;
        int[] res = new int[stack.size()];
        while (!stack.isEmpty()) {
            res[index++] = stack.pop();
        }
        return res;
    }

}
