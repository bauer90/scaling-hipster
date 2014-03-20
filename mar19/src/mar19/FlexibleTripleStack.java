package mar19;

public class FlexibleTripleStack {
    private int[] arr;
    private int[] head_for;
    private int length_arr;
    private int[] num_occupied_at;
    
    // Useful when push_to() is called.
    // Moves everything at or to the right of stack
    // [starting_from] to the right by one
    // slot. starting_from can be 1 or 2.
    // starting_from == 0 makes no sense here.
    // Returns 0 on success and -1 otherwise.
    private int move_forward(int starting_from) {
        if (starting_from != 1 && starting_from != 2) {
            System.out.println("Error: bad arg for move_forward().");
            return -1;
        } else if (this.num_total_occupied() >= this.length_arr) {
            System.out.println("Error: move_forward() called on a full array.");
            return -1;
        } else {
            // Moves everything starting index = head_for[starting_from] to the right by 1 slot.
            // Note: start from the end to avoid overwriting.
            for (int i = this.num_total_occupied() - 1; i >= head_for[starting_from]; i--) {
                arr[i+1] = arr[i];
            }
        }  
        return 0;
    }
    
    // Useful when pop_from() is called.
    // Moves everything at or to the right of stack
    // of index = [starting_from] to the left by one
    // index. starting_from can be 1 or 2.
    // (It makes no sense if starting_from == 0.)
    // Returns 0 on success and -1 on failure.
    private int move_backward(int starting_from) {
        if (starting_from != 1 && starting_from != 2) {
            System.out.println("Error: bad arg for move_backward(int).");
            return -1;
        } else {
            for (int i = this.head_for[starting_from]; i < this.num_total_occupied(); i++) {
                arr[i - 1] = arr[i];
            }
            arr[this.num_total_occupied() - 1] = 0; // reset the last digit to 0.
        }
        return 0;
    }
    
    public boolean is_full() {
        return this.num_total_occupied() >= this.length_arr;
    }
    
    public boolean is_empty_at(int which) {
        return this.num_occupied_at[which] <= 0;
    }
    
    private int num_total_occupied() {
        return this.num_occupied_at[0] + this.num_occupied_at[1] + this.num_occupied_at[2];
    }
    
    // initiates an array representing three stacks
    // starting at index = 0. Every slot on the
    // array is initiated to be zero.
    public FlexibleTripleStack(int len) {
        if (len < 1) {
            System.out.println("Error: Invalid length for FlexibleTripleStack(int).");
            return;
        }
        this.arr = new int[len];
        this.head_for = new int[3];
        this.num_occupied_at = new int[3];
        this.length_arr = len;
        for (int i = 0; i < len; i++) {
            arr[i] = 0;
        }
        for (int i = 0; i < 3; i++) {
            this.head_for[i] = 0;
            this.num_occupied_at[i] = 0;
            
        }
    }
    
    
    public int pop_from(int which) {
        if (which != 0 && which != 1 && which != 2) {
            System.out.println("Error: bad arg for pop_from(int).");
            return -1;
        } else if (this.is_empty_at(which)) {
            System.out.println("Error: attempting to pop_from an empty stack.");
            return -1;
        } else {
            // ready to pop
            int result = 0;
            if (which == 2) { // Trivial case: pop from the last stack
                result = arr[this.num_total_occupied() - 1];
                arr[this.num_total_occupied() - 1] = 0;
                this.num_occupied_at[which] --;
                return result;
            } else { // Pop from one of first two stacks. Need to call move_backward() -
                result = arr[head_for[which + 1] - 1];
                if (move_backward(which + 1) != 0) {
                    System.out.println("move_backward() failed.");
                    return -1;
                } else {
                    for (int i = which + 1; i < 3; i++) {
                        head_for[i] --;
                    }
                    this.num_occupied_at[which] --;
                    return result;
                }
            }
        }
    }
    
    // returns 0 on success; -1 otherwise.
    public int push_to(int which, int dat) {
        if (this.is_full()) {
            System.out.println("Error: push_to() called on a full array.");
            return -1;
        } else if (which != 0 && which != 1 && which != 2) {
            System.out.println("Error: Bad arg for push_to(int,int).");
            return -1;
        } else if (which == 2) {
            // when push_to the 3rd stack (with index == 2)
            // we don't need to move anything forward. 
            // Just append to the end.
            arr[this.num_total_occupied()] = dat;
        } else {
            // push_to the first two stacks. move_forward() needed.
            if (move_forward(which + 1) != 0) {
                System.out.println("move_forward() failed.");
                return -1;
            }
            for (int i = which + 1; i < 3; i++) {
                this.head_for[i] ++;
            }
            this.arr[head_for[which + 1] - 1] = dat;
        }
        this.num_occupied_at[which] ++;
        return 0;
    }
    
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            sb.append("/ ");
            for (int j = this.head_for[i]; j < (i >= 2 ? (this.length_arr) : (this.head_for[i+1])); j++) {
                sb.append(new Integer(arr[j]).toString() + " ");
            }
        }       
        return sb.toString();
    }
    
    // w/o head location indicator
    public String toString_simple() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < this.length_arr; i++) {
            sb.append((new Integer(arr[i])).toString());
        }
        return sb.toString();
    }
    
    public void print_head_info() {
        for (int i = 0; i < 3; i++) {
            System.out.println("head " + i + " is " + this.head_for[i]);
        }
    }
    
    
}
