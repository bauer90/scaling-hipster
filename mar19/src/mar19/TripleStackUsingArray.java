package mar19;

// 3 stacks on an array with each stack's
// size being fixed.
public class TripleStackUsingArray 
{
    private int[] arr;
    private int size_each_stack;
    private int[] num_occupy;
    private int[] index_tail;
    
    private boolean is_empty(int which) 
    {
        return num_occupy[which] <= 0;
    }
    
    private boolean is_full(int which) 
    {
        return num_occupy[which] >= size_each_stack;
    }
    
    // initializes three stacks of [size] 
    // and every slot being zero.
    public TripleStackUsingArray(int size) 
    {
        this.arr = new int[3 * size];
        this.num_occupy = new int[3];
        this.index_tail = new int[3];
        this.size_each_stack = size;
        for (int i = 0; i < size * 3; i++)
            arr[i] = 0;
        for (int i = 0; i < 3; i++) {
            num_occupy[i] = 0;
            index_tail[i] = i * size;
        }
    }
    
    // which = 0,1,2
    public int pop_from(int which) 
    {
        if (which != 0 && which != 1 && which != 2) {
            System.out.println("arg wrong for pop_from(int)");
            return -1;
        } else if (is_empty(which)) {
            System.out.println("Stack[" + which + "] is empty. Cannot pop.");
            return -1;
        } else {
            int result = arr[index_tail[which]];
            index_tail[which] -= 1;
            num_occupy[which]--;
            return result;
        }    
    }
    
    // returns 0 on success; otherwise -1.
    public int push_to(int which, int dat) 
    {
        if (which != 0 && which != 1 && which != 2) {
            System.out.println("arg wrong for push_to(int)");
            return -1;
        } else if (is_full(which)) {
            System.out.println("Stack[" + which + "] is full. Cannot push.");
            return -1;
        } else {
            System.out.println("push " + dat + " at " + index_tail[which]);
            arr[index_tail[which]] = dat;
            index_tail[which] += 1;
            num_occupy[which]++;
            return 0;
        }
    }
    
    public String toString() 
    {
        StringBuffer sb = new StringBuffer("| ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < this.size_each_stack; j++)
                sb.append((new Integer(this.arr[i * size_each_stack + j])).toString() + " ");
            sb.append("| ");
        }
        return sb.toString();
    }
}
