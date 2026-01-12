class Revision{
    Node head;
    private int size;
    Revision(){
        this.size=0;
    }
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
            size++;
        }
    }
    public void addFirst(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;

    }
    public void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
        
    }
    public void deleteFirst(){
        if(head==null){
            System.out.println("Empty");
            return;
        }
        size--;
        head=head.next;
        
    }
    public void deleteLast(){
        if(head==null){
            System.out.println("Empty");
            return;
        }
        Node temp=head;
        while(temp.next.next !=null){
            temp=temp.next;
        }
        temp.next=null;
        size--;
    }
    public void print(){
        if(head==null){
            System.out.println("Empty");
            return;
        }
        Node temp=head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.print("Null");
    }
    public int getSize(){
        return size;
    }
    public int getMiddle(Node head){
        Node slow=head;
        Node fast=head;
        if(head==null){
            return -1;
        }
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow.data;
    }
    public boolean isCycle(){
        Node slow=head;
        Node fast=head;
        if(head==null){
            return false;
        }
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public void removeCycle(){
        Node slow=head;
        Node fast=head;
        if(head==null){
            return;
        }
        do{
            slow=slow.next;
            fast=fast.next.next;
        }while(slow!=fast);
        fast=head;
        while(slow.next!=fast.next){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=null;
    } 
    public static void main(String[] args){
        Revision l=new Revision();
        l.addFirst(3);
        l.addFirst(2);
        l.addFirst(1);
        l.addFirst(5);
        l.addLast(4);
        l.addLast(6);
        l.addLast(7);
        l.addLast(8);
        l.addLast(9);
        l.print();
        System.out.println();
        l.deleteFirst();
        l.print();
        System.out.println();
        l.deleteLast();
        l.print();
        System.out.println();
        System.out.println(l.getSize());
        System.out.println(l.getMiddle(l.head));
        System.out.println(l.isCycle());
    }
}