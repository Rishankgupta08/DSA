class QueueY{
    // int[] arr=new int[10];
    // int n=arr.length;
    // int rear=-1;
    // int front=-1;
    // public boolean isEmpty(){
    //     return front==-1 && rear==-1;
    // }
    // public void enqueue(int data){
    //     if(rear==n-1){
    //         System.out.println(" Queue is full.");
    //         return ;
    //     }
    //     if(isEmpty()){
    //         front=rear=0;
    //         arr[front]=data;
    //         return;
    //     }
    //     rear++;
    //     arr[rear]=data;
    // }
    // public void dequeue(){
    //     if(isEmpty()){
    //         System.out.println("Queue is empty");
    //         return;
    //     }
    //     System.out.println(arr[front]+" ");
    //     for(int i=0;i<rear;i++){
    //         arr[i]=arr[i+1];
    //     }
    //     rear--;
    // }

    // public void peek(){
    //     if(isEmpty()){
    //         System.out.println("Queue is empty");
    //         return;
    //     }
    //     System.out.println(arr[front]+" ");
    // }
    // public void display(){
    //     if(isEmpty()){
    //         System.out.println("Queue is empty");
    //         return;
    //     }
    //     for(int i=front;i<=rear;i++){
    //         System.out.print(arr[i]+" ");
    //     }
    //     System.out.println();
    // }
    // public static void main(String[] args){
    //     QueueY q=new QueueY();
    //     q.enqueue(1);
    //     q.enqueue(2);
    //     q.enqueue(3);
    //     q.display();
    //     q.dequeue();
    //     q.display();
    //     q.peek();
        
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
        return head== null&& tail==null;
    }
    
    public void enqueue(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head=tail=newNode;
            return;
        }
        tail.next=newNode;
        tail=newNode;
    }
    public int dequeue(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        int front=head.data;
        if(head==tail){
            tail=null;
        }
        head=head.next;
        return front;
    }
    public int peek(){
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
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        QueueY q = new QueueY();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.display();
        System.out.println(q.dequeue());
        q.display();
        System.out.println(q.peek());
    }
}