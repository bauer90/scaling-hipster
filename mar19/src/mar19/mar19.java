package mar19;

public class mar19 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SortableStack st = new SortableStack(10);
        for (int i = 0; i < 10; i++) {
            st.push(i * 7 % 13);
        }
        System.out.println(st.toString());
        st.sort();
        System.out.println(st.toString());
    }
}