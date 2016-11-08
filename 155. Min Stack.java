public class MinStack {

    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private Integer min;

    public MinStack() {
        this.stack = new Stack<>();
    }

    public void push(int x) {
        this.stack.push(x);
        min = (min == null ? x : Math.min(min, x));
    }

    public void pop() {
        this.stack.pop();
        //update current min
        min = null;
        for(Integer i: stack){
            min = (min == null ? i : Math.min(min, i));
        }
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return min;
    }
}

class MinStack2{

    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();
    
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if(x <= min){          
            stack.push(min);
            min=x;
        }
        stack.push(x);
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) min=stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
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