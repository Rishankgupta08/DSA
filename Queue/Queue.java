class Queue{
    int[] queue;
    int front, rear, N;

    Queue(int size) {
        N = size;
        queue = new int[N];
        front = rear = -1;
    }
    void enqueue(int x){
        if(rear==N-1){
            System.out.println("Overflow");
        }else if(front==-1 && rear==-1){
            front=rear=0;
            queue[rear]=x;
            
        }else{
            rear++;
            queue[rear]=x;
        }
    }
    void dequeue(){
        if(front==-1 && rear==-1){
            System.out.println("Underflow");
        }else if(front==rear){
            System.out.println(queue[front]);
            front=rear=-1;
        }else{
            System.out.println(queue[front]);
            front++;
        }
    }
    void displayQueue() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty");
        } else {
            System.out.print("Queue: ");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + " ");
            }
            System.out.println();
        }
    }
    Boolean isEmpty(){
        if (front == -1 && rear == -1) {
            return true;
        } else {
            return false;
        }
    }
    Boolean isFull(){
        if(rear==N-1){
           return true;
        }else{
            return false;
        }
    }
    public static void main(String [] a){
        Queue q=new Queue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.displayQueue();
        System.out.println("Queue is FUll: "+q.isFull());
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.displayQueue();
        System.out.println("Queue is Empty: "+q.isEmpty());
    }
}