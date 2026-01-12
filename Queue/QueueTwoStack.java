import java.util.Stack;
class QueueTwoStack{
    Stack <Integer> s1 = new Stack<>();
    Stack <Integer> s2 = new Stack<>();
    public Boolean isempty(){
        return s1.isEmpty();
    }
    public void add(int data){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(data);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }
    public int remove(){
        if(s1.isEmpty()){
            System.out.println("empty.");
            return -1;
        }
        return s1.pop();
    }
    public int top(){
        if(s1.isEmpty()){
            System.out.println("empty.");
            return -1;
        }
        return s1.peek();
    }
    public static void main(String[] args){
        QueueTwoStack q = new QueueTwoStack();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        
    }
}