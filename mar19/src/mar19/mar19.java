package mar19;

public class mar19 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MinValueStack st = new MinValueStack(30);
        st.push(1);
        st.push(3);
        st.push(0);
        st.pop();
        System.out.println(st.get_min());
    }
}