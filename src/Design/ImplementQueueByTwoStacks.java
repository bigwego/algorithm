package Design;

import java.util.Stack;

public class ImplementQueueByTwoStacks {

    private Stack<Integer> push;

    private Stack<Integer> pop;

    public ImplementQueueByTwoStacks() {
        push = new Stack<>();
        pop = new Stack<>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        push.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        if (!pop.isEmpty()) {
            return pop.pop();
        }
        while (!push.isEmpty()) {
            pop.push(push.pop());
        }
        return pop.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        if (!pop.isEmpty()) {
            return pop.peek();
        }
        while (!push.isEmpty()) {
            pop.push(push.pop());
        }
        return pop.peek();
    }
}
