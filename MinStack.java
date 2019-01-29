package projects;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack, min;

    /** initialize your data structure here. */

    public MinStack() {
        stack = new Stack<>();
        // stack to store the minimums
        min = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.empty()) 
        	min.push(x);
        else if (min.peek() >= x) 
            min.push(x);
    }

    // delete the min if min is popped from main stack
    public void pop() {
        int popped = stack.pop();
        if (!min.empty() && min.peek() == popped) {
            min.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}  

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */