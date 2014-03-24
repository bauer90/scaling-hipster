package mar19;

// Want to implement a queue using two stacks. We establish stack_A and stack_B.
// When we want to enQueue(), we pop out everything in B and push then to A, then enQueue() to A;
// When we want to deQueue(), we pop out everything in A and push them to B, then deQueue() from B;
public final class QueueUsingTwoStacks 
{
    private Stack_customized stack_A;
    private Stack_customized stack_B;
    
    public QueueUsingTwoStacks(int size) 
    {
        stack_A = new Stack_customized(size);
        stack_B = new Stack_customized(size);
    }
    
    public int get_size() 
    {
        return this.stack_A.get_size();
    }
    
    public boolean can_enqueue() 
    {
        return stack_A.get_num_occupied() + stack_B.get_num_occupied() < stack_B.get_size();
    }
    
    public boolean can_dequeue() 
    {
        return stack_A.get_num_occupied() + stack_B.get_num_occupied() > 0;
    }
    
    // pop everything in [origin] to [destination]
    // to reverse the order of elements occupying the stack.
    // useful when we want to enqueue() or dequeue().
    private void stack_transport(Stack_customized origin, Stack_customized destination)
    {
        while (! origin.is_empty()) {
            destination.push(origin.pop());
        }
    }
    
    public void enqueue(int val) 
    {
        if (!this.can_enqueue()) {
            System.out.println("Error: attempting to enqueue() a full queue.");
            return ;
        }
        stack_transport(stack_B, stack_A);
        stack_A.push(val);
    }
    
    public int dequeue()
    {
        if (!this.can_dequeue()) {
            System.out.println("Error: attempting to dequeue() an empty queue.");
            return -1;
        }
        stack_transport(stack_A, stack_B);
        return stack_B.pop();
    }
    
    public String toString() 
    {
        StringBuffer sb = new StringBuffer("A: ");
        sb.append(stack_A.toString());
        sb.append("\nB: ");
        sb.append(stack_B.toString());
        sb.append("\n");
        return sb.toString();
    }
    

}
