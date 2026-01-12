class LLReverseRecurr{
    Node head;
    class Node{
        String data;
        Node next;
        Node(String data){
            this.data=data;
            this.next=null;
        }
    }
    public void AddFirst(String data){
        Node  newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    public  void AddLast(String data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node currNode=head;
        while(currNode.next!=null){
            currNode=currNode.next;
        }
        currNode.next=newNode;
    }

    public void Print(){
        if(head==null){
            System.out.println("Empty");
        }
        Node currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("NUll");
    }
    public Node ReverseRecursive(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node newHead=ReverseRecursive(head.next);
        head.next.next=head;
        head.next=null;
        return  newHead;

    }
   
    public static void main(String[] args) {
        LLReverseRecurr list=new  LLReverseRecurr();
        list.AddFirst("A");
        list.AddFirst("B");
        list.AddFirst("C");
        list.Print();
        list.head=list.ReverseRecursive(list.head);
        list.Print();
    }
}