package mytest;

import java.util.Stack;

/**
 * Created by fuwenchao on 2021/5/7.
 *
 * 没有想到：利用一个栈，栈内每个元素是元组的情况，python写的。
 */
public class MinStack {
    Stack<Integer> values = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int val) {
        values.push(val);
        if(min.size()==0){
            min.push(val);
        }else if(val<min.peek()){
            min.push(val);
        }else{
            min.push(min.peek());
        }
    }

    public void pop() {
        values.pop();
        min.pop();

    }

    public int top() {
        return values.peek();

    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {

    }
}
