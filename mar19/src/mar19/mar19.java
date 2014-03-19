package mar19;

public class mar19 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TripleStackUsingArray stacks = new TripleStackUsingArray(4);

        stacks.push_to(2,2);
        System.out.println(stacks.toString());
        stacks.pop_from(2);
        stacks.push_to(1, 44);
        System.out.println(stacks.toString());
        stacks.push_to(0, 3);
        System.out.println(stacks.toString());
    }
}