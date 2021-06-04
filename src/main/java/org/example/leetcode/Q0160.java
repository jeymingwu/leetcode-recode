package org.example.leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * 160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * @author : jeymingwu
 * @date : 2021-06-04
 **/
public class Q0160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

//        LinkedHashSet<ListNode> set = new LinkedHashSet<ListNode>();
//
//        for (ListNode tmp = headA; tmp != null; tmp = tmp.next) {
//            set.add(tmp);
//        }
//
//        for (ListNode tmp = headB; tmp != null; tmp = tmp.next) {
//            if (set.contains(tmp)) {
//                return tmp;
//            }
//        }
//
//        return null;

        // 方法二：时间复杂度O(n)，空间复杂度O(1)，headA、headB 两链表均无改变
        if (headA == null || headB == null) {
            return null;
        }

        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }

        return nodeA;
    }

    public static void main(String[] args) {

        ListNode listNode2 = new ListNode(2);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode5 = new ListNode(5);

        listNode2.next = listNode6;
        listNode6.next = listNode4;

        listNode1.next = listNode5;

        Q0160 q0160 = new Q0160();
        ListNode intersectionNode = q0160.getIntersectionNode(listNode2, listNode1);
        System.out.println(intersectionNode);
    }
}
