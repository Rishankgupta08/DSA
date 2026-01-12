import java.util.*;
class Stack{
    int Stack[]=new int[5];
        int x;
        int top=-1;
        int n=5;
    
    void push(){
        Scanner sc=new Scanner(System.in);
        if(top>=n-1){
            System.out.println("overflow");
        }
        else{
            System.out.print("enter the value to pushed: ");
            int x=sc.nextInt();
            top++;
            Stack[top]=x;
        }
    }
    void pop(){
        if (top<=-1){
            System.out.println("underflow");
        }
        else{
            System.out.println("Popped element:  "+Stack[top]);
            top--;
        }
    }
    void display(){
        if (top>=0){
            System.out.println("element in stack: ");
            for(int i=top;i>=0;i--){
                System.out.println(Stack[i]);
            }
        }
        else{
            System.out.println("stack is empty");
        }
    }
    Boolean isEmpty(){
        if(top==-1){
            return true;
        }else{
            return false;
        }
    }
    Boolean isFull(){
        if(top>=n-1){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args){
        Stack s=new Stack();
        s.push();
        s.push();
        s.push();
        s.push();
        s.push();
        s.display();
        System.out.println("Stack is Full: "+s.isFull());
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.pop();
        s.display();
        System.out.println("Stack is Empty: "+s.isEmpty());
    }
}