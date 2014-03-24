package mar19;

public class mar19 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ArrayOfStacks tmp = new ArrayOfStacks(6);
        for (int i = 0; i < 20; i++) {
            tmp.push(i * 79 % 17);
        }
        System.out.println(tmp.toString());
    }
}