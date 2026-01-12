import java.util.Queue;
import java.util.LinkedList;
class STbyQ{
    private Queue<Integer> q1=new LinkedList<>();
    private Queue<Integer> q2=new LinkedList<>();
    public void push(int x) {
        while(!q1.isEmpty()){
            q2.add(q1.remove());
        }
        q1.add(x);
        while(!q2.isEmpty()){
            q1.add(q2.remove());
        }
    }
    
    public int pop() {
        if(q1.isEmpty()){
            return -1;
        }
        return q1.remove();
    }
    
    public int top() {
        if(q1.isEmpty()){
            return -1;
        }
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args){
        STbyQ st = new STbyQ();
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println(st.top());
        st.pop();
        System.out.println(st.top());
        st.pop();
        System.out.println(st.top()); 
        st.pop();
        System.out.println(st.empty());
    }
}