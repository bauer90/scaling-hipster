package mar19;

public class ArrayOfStacks {
    private Stack_customized[] array_of_stacks;
    private int length_of_array;
    private int height_each_stack;
    private int current_stack;
    private int current_height;
    
    // initiates ArrayOfStacks with length_of_array == 1.
    public ArrayOfStacks(int height_stack) {
        if (height_each_stack < 1) {
            System.out.println("Err: bad arg for ArrayOfStacks().");
            return;
        }
        array_of_stacks = new Stack_customized[1];
        array_of_stacks[0] = new Stack_customized(height_each_stack);
        this.height_each_stack = height_stack;
        this.length_of_array = 1;
        this.current_stack = 0;
        this.current_height = 0;
    }
    
    // expand the array to 2x of its original size.
    // useful when (current_stack == length_of_array - 1)
    // and (current_height = heigth_each_stack - 1),
    // and push() is called.
    private void resize() {
        Stack_customized[] temp = new Stack_customized[2 * this.length_of_array];
        for (int i = 0; i < this.length_of_array; i++)
                temp[i] = new Stack_customized(this.array_of_stacks[i]); // calling Stack_customized's copy constructor.
        this.array_of_stacks = temp;
        this.length_of_array *= 2;
        this.current_height = 0;
        this.current_stack ++;
    }
    
    public int pop() {
        
    }
    
    public void push(int val) {
        
    }
    
}
