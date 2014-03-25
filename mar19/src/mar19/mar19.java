package mar19;

public class mar19 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SortableStack st = new SortableStack(5);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(-1);
        st.push(2);
        System.out.println(st.toString());
        System.out.println(st.sort().toString());
    }
}