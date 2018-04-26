package com.calcu;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhubo
 * @description: 利用两个栈来实现队列功能
 * @time: 2018年04月26日
 * @modifytime:
 */
public class StackQueue
{
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(Integer i){
        stack1.push(i);
    }
    public Integer pop(){
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){ // 重点：每次stack2取完之后，将所有stack1中所有的元素放到stack2中
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        StackQueue sq = new StackQueue();
        sq.push(1);
        sq.push(2);
        sq.push(3);
        sq.push(4);
        System.out.println(sq.pop() + ":" + sq.pop() + ":" + sq.pop() + ":" + sq.pop());
    }
}
