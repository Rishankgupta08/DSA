class CircularQueue{
    // int[] arr=new int[5];
    // int n=arr.length;
    // int front=-1;
    // int rear=-1;
    // public boolean isEmpty(){
    //     return rear==-1 && front==-1;
    // }
    // public boolean isFull(){
    //     return (rear+1) % n==front;
    // }
    // public void enqueue(int data){
    //     if(isFull()){
    //         System.out.println("Queue is full");
    //         return;
    //     }
    //     if(isEmpty()){
    //         front=rear=0;
    //         arr[front]=data;
    //         return;
    //     }else{
    //         rear=(rear+1)% n;
    //     }
        
        
    //     arr[rear]=data;
    // }
    // public int dequeue(){
    //     if(isEmpty()){
            
    //         return -1;
    //     }
    //     int result=arr[front];
    //     if(front==rear){
    //         front=rear=-1;   
    //     }else{
    //         front=(front+1)%n;
    //     }
    //     return result;
    // }
    // public void display(){
    //     if(isEmpty()){
    //         System.out.println("Queue is empty");
    //         return;
    //     }
    //     int i=front;
    //     while (true) {
    //         System.out.print(arr[i]+" ");
    //         if(i==rear){
    //             break;
    //         }
    //         i=(i+1)%n;
    //     }
    //     System.out.println();
    // }
    // public static void main(String[] args) {
    //     CircularQueue q=new CircularQueue();
    //     q.enqueue(1);
    //     q.enqueue(2);
    //     q.enqueue(3);
    //     q.enqueue(4);
    //     q.enqueue(5);
    //     q.display();
    //     q.dequeue();
    //     q.display();
    //     q.enqueue(6);
    //     q.display();
        
    // }
    Node head=null;
    Node tail=null;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public boolean isEmpty(){
        return head==null && tail==null;
    }
    public void enqueue(int data){
        Node newNode=new Node(data);
        if(isEmpty()){
            head=tail=newNode;
            tail.next=head;
            return;
        }
        tail.next=newNode;
        tail=newNode;
        tail.next=head;
    }
    public int  dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        int front=head.data;
        if(head==tail){
            head=tail=null;
        }
        head=head.next;
        tail.next=head;
        return front;
    }
    public int  peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        return head.data;
    }
    public void display(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        System.out.println(head.data);
        Node temp=head.next;
        while(temp !=head){
            System.out.println(temp.data+ " ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        CircularQueue q=new CircularQueue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.display();
    }
}