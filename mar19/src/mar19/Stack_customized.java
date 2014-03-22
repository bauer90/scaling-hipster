package mar19;

public final class Stack_customized {
    private int[] arr;
    private int num_occupied;
    private int length_arr;
    
    public Stack_customized(int size) 
    {
        this.arr = new int[size];
        this.num_occupied = 0;
        this.length_arr = size;
        for (int i = 0; i < size; i++)
            this.arr[i] = 0;
    }
    
    // copy constructor
    public Stack_customized(Stack_customized other) 
    {
        this.num_occupied = other.get_num_occupied();
        this.length_arr = other.get_size();
        this.arr = new int[other.get_size()];
        for (int i = 0; i < other.get_size(); i++)
            this.arr[i] = other.arr[i];
    }
    
    public int get_num_occupied() 
    {
        return this.num_occupied;
    }
    
    public int get_size() 
    {
        return this.length_arr;
    }
    
    public boolean is_empty() 
    {
        return this.num_occupied <= 0;
    }
    
    public boolean is_full() 
    {
        return this.num_occupied >= this.length_arr;
    }
    
    public int pop() 
    {
        if (this.is_empty()) {
            System.out.println("Error: pop() called on an empty stack.");
            return -1;
        }
        int result = this.arr[this.num_occupied - 1];
        this.num_occupied --;
        return result;
    }
    
    public void push(int val) 
    {
        if (this.is_full()) {
            System.out.println("Error: push() called on a full stack.");
            return;
        }
        this.arr[this.num_occupied] = val;
        this.num_occupied ++;
    }
    
    public int peek() 
    {
        if (this.is_empty()) {
            System.out.println("Error: peek() called on an empty stack.");
            return -1;
        }
        return arr[this.num_occupied - 1];
    }
    
    public String toString() 
    {
        StringBuffer sb = new StringBuffer("/ ");
        for (int i = 0; i < this.num_occupied; i++)
            sb.append((new Integer(this.arr[i])).toString() + " ");
        for (int i = this.num_occupied; i < this.length_arr; i++)
            sb.append("_ ");
        sb.append("/");
        return sb.toString();   
    }
}
