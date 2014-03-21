package mar19;

// a stack where min value can be
// retrieved in O(1) time.
public class MinValueStack {
    private Stack_customized min_stack;
    private Stack_customized main_stack;
    
    public MinValueStack(int size) {
       min_stack = new Stack_customized(size);
       main_stack = new Stack_customized(size);
    }
    
    public int pop() {
        if (main_stack.is_empty()) {
            System.out.println("pop() called on an empty stack.");
            return -1;
        }
        int result;
        if ((result = main_stack.pop()) <= get_min()) {
            min_stack.pop();
        }
        return result;
    }

    public void push(int val) {
        if (main_stack.is_full()) {
            System.out.println("push() called on a full stack.");
            return;
        }
        if (val < get_min()) {
            min_stack.push(val);
        }
        main_stack.push(val);
    }
    
    public int get_min() {
        return main_stack.is_empty() ? Integer.MAX_VALUE : min_stack.peek();
    }
    
    
}
