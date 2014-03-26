package mar19;
import java.util.LinkedList;

public class DogCatQueue
{
    private LinkedList<Animal> dog_queue;
    private LinkedList<Animal> cat_queue;
    private int clock_val;
    
    public DogCatQueue()
    {
        dog_queue = new LinkedList<Animal>();
        cat_queue = new LinkedList<Animal>();
        clock_val = 0;
    }
    
    private void inc_clock_val()
    {
        clock_val++;
    }
    
    public void enqueue(Animal a)
    {
        inc_clock_val();
        a.set_time_arrived(clock_val);
        if (a.is_type_Dog()) {
            dog_queue.addLast(a);
        } else if (a.is_type_Cat()) {
            cat_queue.addLast(a);
        } else {
            System.out.println("Invalid Animal Object for enqueue().");
        }
    }
    
    public String dequeue_any()
    {
        if (dog_queue.isEmpty() && cat_queue.isEmpty()) {
            return "";
        } else if (dog_queue.isEmpty()) {
            return cat_queue.pollFirst().get_id();
        } else if (cat_queue.isEmpty()) {
            return cat_queue.pollFirst().get_id();
        } else {
            if (dog_queue.peek().is_earlier_than(cat_queue.peek())) {
                return dog_queue.pollFirst().get_id();
            } else {
                return cat_queue.pollFirst().get_id();
            }
        }
    }
    
    public String dequeue_dog()
    {
        if (dog_queue.isEmpty()) {
            return "";
        } else {
            return dog_queue.pollFirst().get_id();
        }
    }
    
    public String dequeue_cat()
    {
        if (cat_queue.isEmpty()) {
            return "";
        } else {
            return cat_queue.pollFirst().get_id();
        }
    }
    
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        for (Animal a : dog_queue) {
            sb.append(a.toString() + " /");
        }
        sb.append("\n");
        for (Animal a : cat_queue) {
            sb.append(a.toString() + " /");
        }
        return sb.toString();
    }
}
