package mar19;

public class mar19 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        QueueUsingTwoStacks tmp = new QueueUsingTwoStacks(30);
        tmp.enqueue(3);
        tmp.enqueue(4);
        for (int i = 0; i < 10; i++) {
            tmp.enqueue(i*7);
        }
        System.out.println(tmp.toString());
        for (int i = 0; i < 10; i++) {
            System.out.println(tmp.dequeue());
        }
        //System.out.println(tmp.dequeue());
        System.out.println(tmp.toString());
    }
}