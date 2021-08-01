package org.example.jianzhioffer;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 *
 * @author : jeymingwu
 * @date : 2021-08-02
 **/

class CQueue {

    private Stack<Integer> stack;
    private Stack<Integer> tempStack;

    public CQueue() {
        stack = new Stack<>();
        tempStack = new Stack<>();
    }

    public void appendTail(int value) {
        this.stack.push(value);
    }

    // 思路改进，只有在 tempStack 为空的情况下需将 stack 倒入
    public int deleteHead() {
        if (!tempStack.isEmpty()) {
            return tempStack.pop();
        } else {
            while (!stack.isEmpty()) {
                tempStack.push(stack.pop());
            }
            return tempStack.isEmpty() ? -1 : tempStack.pop();
        }
    }

//    public int deleteHead() {
//        if (stack.isEmpty()) {
//            return -1;
//        }
//        while (!stack.isEmpty()) {
//            tempStack.push(stack.pop());
//        }
//        int pop = tempStack.pop();
//        while (!tempStack.isEmpty()) {
//            stack.push(tempStack.pop());
//        }
//        return pop;
//    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */

public class Q0009 {
}
