package mar19;

public class mar19 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayOfStacks tmp = new ArrayOfStacks(30);
        for (int i = 0; i < 100; i++) {
            tmp.push(3);
        }
        System.out.println(tmp.toString());
    }
}