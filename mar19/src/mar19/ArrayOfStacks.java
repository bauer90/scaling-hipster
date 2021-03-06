package mar19;

public final class ArrayOfStacks 
{
    private Stack_customized[] array_of_stacks;
    private int length_of_array;
    private int current_stack;
    
    // initiates ArrayOfStacks with length_of_array == 1.
    public ArrayOfStacks(int height_stack) 
    {
        if (height_stack < 1) {
            System.out.println("Err: bad arg for ArrayOfStacks().");
            return;
        }
        array_of_stacks = new Stack_customized[1];
        array_of_stacks[0] = new Stack_customized(height_stack);
        length_of_array = 1;
        current_stack = 0;
    }
    
    public boolean is_full() 
    {
        return (current_stack >= length_of_array - 1) 
                && (array_of_stacks[current_stack].get_num_occupied() >= array_of_stacks[current_stack].get_size());
    }
    
    public boolean is_empty() 
    {
        return (current_stack <= 0) && (array_of_stacks[0].get_num_occupied() <= 0);
    }
    
    // expand the array to 2x of its original size.
    // useful when push() is called and is_full() returns true.
    private void resize() 
    {
        Stack_customized[] temp = new Stack_customized[2 * length_of_array];
        for (int i = 0; i < length_of_array; i++)
            temp[i] = new Stack_customized(array_of_stacks[i]); // calling Stack_customized's copy constructor.
        for (int i = length_of_array; i < 2 * length_of_array; i++) 
            temp[i] = new Stack_customized((array_of_stacks[0].get_size()));
        array_of_stacks = temp;
        length_of_array *= 2;
        current_stack ++;
    }
    
    public int pop() 
    {
        if (this.is_empty()) {
            System.out.println("Error: attempting to pop() from an empty ArrayOfStacks.");
            return -1;
        }
        int result = array_of_stacks[current_stack].pop();
        if (this.array_of_stacks[current_stack].get_num_occupied() == 0)
            current_stack --;
        return result;
    }
    
    public void push(int val) 
    {
        if (this.is_full())
            this.resize();
        if (array_of_stacks[current_stack].is_full())
            current_stack ++;
        array_of_stacks[current_stack].push(val);
    }
    
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length_of_array; i++) {
            sb.append(array_of_stacks[i].toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
