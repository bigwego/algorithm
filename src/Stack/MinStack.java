package Stack;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> data;

    private Stack<Integer> min;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        data = new Stack();
        min = new Stack();
    }

    public void push(int x) {
        data.push(x);
        if (min.isEmpty()) {
            min.push(x);
        } else {
            if (min.peek() > x) {
                min.push(x);
            } else {
                min.push(min.peek());
            }
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

class MinStack2 {

    private Stack<Integer> push;

    private Stack<Integer> min;

    public MinStack2() {
        push = new Stack<>();
        min = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        push.push(number);
        if (min.isEmpty()) {
            min.push(number);
        } else {
            if (min.peek() <= number) {
                min.push(min.peek());
            } else {
                min.push(number);
            }
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        min.pop();
        return push.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
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
