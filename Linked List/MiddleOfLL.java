class MiddleOfLL{
    Node head;
    int size;
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
            size++;
        }
    }
    public void AddFirst(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    public void PrintList(){
        if(head==null){
            System.out.println("Empty");
            return;
        }
        Node currNode=head;
        while(currNode!=null){
            System.out.print(currNode.data+" -> ");
            currNode=currNode.next;
        }
        System.out.println("Null");
    }
    public int getSize(){
        return size;
    }
    public int  getMiddle(){
        if(head==null){
            return -1;
        }
        int mid=(size/2)+1;
        Node  temp=head;
        for(int i=1;i<mid;i++){
            temp=temp.next;
        }
        return temp.data;
    }
    
    public static void main(String[] args){
        MiddleOfLL l=new MiddleOfLL();
        l.AddFirst(5);
        l.AddFirst(4);
        l.AddFirst(3);
        l.AddFirst(2);
        l.AddFirst(1);
        l.PrintList();
        System.out.println(l.getSize());
        System.out.println(l.getMiddle());
        l.AddFirst(0);
        l.AddFirst(-1);
        l.AddFirst(-2);
        l.AddFirst(-3);
        l.AddFirst(-4);
        l.PrintList();
        System.out.println(l.getSize());
        System.out.println(l.getMiddle());
    }
    
}