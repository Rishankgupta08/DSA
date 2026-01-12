class CircularLL{
    Node head;
    Node tail;
    CircularLL(){
        head = null;
        tail = null;
    }
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public void addFirst(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            tail.next=head;
            return;
        }
        newNode.next=head;
        head=newNode;
        tail.next=head;
    }

    public void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=tail=newNode;
            tail.next=head;
            return;
        }
        tail.next=newNode;
        tail = newNode;
        tail.next=head;
    }
    public void deleteFirst(){
        if(head==null){
            System.out.println(" List is Empty.");
            return;
        }
        if(head==tail){
            head=tail=null;
            return;
        }
        head=head.next;
        tail.next=head;
    }
    public void deleteLast(){
        if(head==null){
            System.out.println(" List is Empty.");
            return;
        }
        if(head==tail){
            head=tail=null;
            return;
        }
        Node prev=head;
        while(prev.next!=tail){
            prev=prev.next;
        }
        prev.next=null;
        tail=prev;
        tail.next=head;
    }
    public void print(){
        Node temp = head.next;
        System.out.print(head.data+ " ");
        while(temp!=head){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }


    public static void main(String[] args){
        CircularLL cll = new CircularLL();
        cll.addFirst(3);
        cll.addFirst(2);
        cll.addFirst(1);
        cll.print();
        cll.addLast(4);
        cll.addLast(5);
        cll.addLast(6);
        cll.print();
        cll.deleteFirst();
        cll.print();
        cll.deleteLast();
        cll.print();
         
    }
}