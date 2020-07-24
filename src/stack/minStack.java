package stack;

import java.util.Stack;

/**
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
// 2020.2.20
// 2020.7.24
public class minStack {

    Stack<Integer> data = new Stack<>();
    int min = Integer.MAX_VALUE;

    // 单栈法
    public void push(int node) {
        if (node <= min) {
            data.push(min);
            min = node;
        }
        data.push(node);
    }

    public void pop() {
        if (data.peek() == min) {
            data.pop();
            min = data.pop();
        } else {
            data.pop();
        }

    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min;
    }


    /* 双栈法
    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int node) {
        data.push(node);
        if (min.isEmpty())
            min.push(node);
        int num = Math.min(node, min.peek());
        min.push(num);
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
    */
}
