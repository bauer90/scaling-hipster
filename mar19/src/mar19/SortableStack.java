package mar19;
/* Problem 3.6 (three-stack version) */

public class SortableStack 
{
    private Stack_customized stack_1;
    
    public SortableStack(int size)
    {
        stack_1 = new Stack_customized(size);
    }
    
    public boolean is_empty()
    {
        return stack_1.is_empty();
    }
    
    public boolean is_full()
    {
        return stack_1.is_full();
    }
    
    public int get_num_occupied()
    {
        return stack_1.get_num_occupied();
    }
    
    /* returns the index of the minimum element 
     * in stack_1. For example, if the top element
     * is found to be the minimum, 0 will be returned. */
    private int get_min_index()
    {
        if (this.is_empty()) {
            System.out.println("Error: get_min_index() called on empty SortableStack.");
            return -1;
        }
        Stack_customized stack_1_cpy = new Stack_customized(stack_1);
        int small_num = Integer.MAX_VALUE, small_index = 0, temp, i = 0;
        while (!stack_1_cpy.is_empty()) {
            temp = stack_1_cpy.pop();
            if (temp < small_num) {
                small_num = temp;
                small_index = i;
            }
            i++;
        }
        return small_index;
    }
    
    /* returns the element of depth = dep 
     * in stack_1. If a stack is shown as
     * 4 2 7 _ _ , then get_element_at(0)
     * will return 7 */
    private int get_element_at(int dep)
    {
        if (dep > this.get_num_occupied() - 1 || this.is_empty() || dep < 0) {
            System.out.println("Empty stack, or Bad arg for get_element_at(int).");
            return -1;
        }
        Stack_customized stack_cpy = new Stack_customized(stack_1);
        for (int i = 0; i < dep; i++) {
            stack_cpy.pop();
        }
        return stack_cpy.pop();
    }
    
    private void remove_element_at(int dep)
    {
        if (this.is_empty()) {
            System.out.println("remove_element_at() called on an empty stack.");
            return;
        }
        Stack_customized tmp = new Stack_customized(dep);
        for (int i = 0; i < dep; i++) {
            tmp.push(stack_1.pop());
        }
        stack_1.pop();
        while (!tmp.is_empty()) {
            stack_1.push(tmp.pop());
        }
    }
    /* returns a sorted copy of stack_1 */
    public Stack_customized sort()
    {
        int num_occupied = stack_1.get_num_occupied();
        Stack_customized result = new Stack_customized(stack_1.get_size());
        for(int i = 0; i < num_occupied; i++) {
            System.out.println("");
            result.push(get_element_at(get_min_index()));
            remove_element_at(get_min_index());
        }
        return result;
    }
    
    public int pop() 
    {
        return stack_1.pop();
    }
    
    public void push(int val)
    {
        stack_1.push(val);
    }
    
    public String toString()
    {
        return stack_1.toString();
    }
}
