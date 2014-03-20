package mar19;

public class mar19 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FlexibleTripleStack stack = new FlexibleTripleStack(10);
        System.out.println(stack.toString());
        stack.push_to(0, 1);
        stack.push_to(1, 2);
        stack.push_to(0, 4);
        stack.push_to(2,5);
        stack.push_to(2, 9);
        //stack.push_to(0, 3);
        //System.out.println(stack.num_total_occupied());
        stack.print_head_info();
        System.out.println(stack.toString());
    }
}