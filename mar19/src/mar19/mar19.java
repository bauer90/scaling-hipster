package mar19;

public class mar19 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayOfStacks tmp = new ArrayOfStacks(4);
        System.out.println(tmp.toString());
        tmp.push(3);
        System.out.println(tmp.toString());
        tmp.push(4);
        System.out.println(tmp.toString());
        tmp.push(5);
        System.out.println(tmp.toString());
        tmp.push(1);
        System.out.println(tmp.toString());
        tmp.push(2);
        tmp.push(8);
        tmp.push(5);
        System.out.println(tmp.toString());
    }
}