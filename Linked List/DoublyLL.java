class DoublyLL{
    Node head;
    Node tail;
    class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    public void addFirst(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
            return;
        }
        head.prev=newNode;
        newNode.next=head;
        head=newNode;
    }
    public void addLast(int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
    }
    public void addSpecific(int pos,int data){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            tail=newNode;
            return;
        }
        if(pos ==0){
            addFirst(data);
        }
        Node temp=head;
        for(int i=0;i<pos-1;i++){
            temp=temp.next;
        }
        if(temp.next==null){
            addLast(data);
        }
        newNode.next=temp.next;
        temp.next.prev=newNode;
        newNode.prev=temp;
        temp.next=newNode;
    }

    public void deleteFirst(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(head==tail){
            head=null;
            tail=null;
            return;
        }
        head=head.next;
        head.prev=null;
    }

    public void deleteLast(){
        if(tail==null){
            System.out.println("List is empty");
            return;
        }
        if(head==tail){
            head=null;
            tail=null;
            return;
        }
        tail=tail.prev;
        tail.next=null;
        tail.prev=null;
    }
    public void display(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node temp=head;
        while(temp != null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println("Null");
    }

    public void deleteSpecific(int pos){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(pos==0){
            deleteFirst();
            return;
        }
        if(head==tail){
            head=null;
            tail=null;
            return;
        }
        Node temp=head;
        int count=0;
        while(temp!=null && count<pos){
            temp=temp.next;
            count++;
        }
        temp.prev.next=temp.next;
        temp.next.prev=temp.prev;
    }

    public static void main(String[] args){
        DoublyLL l1=new DoublyLL();
        l1.addFirst(5);
        l1.addFirst(4);
        l1.addFirst(3);
        l1.addFirst(2);
        l1.addFirst(1);
        l1.display();
        l1.addLast(6);
        l1.addLast(7);
        l1.display();
        l1.addLast(9);
        l1.addLast(10);
        l1.display();
        l1.addSpecific(7, 8);
        l1.display();
        l1.deleteFirst();
        l1.display();
        l1.deleteLast();
        l1.display();
        l1.deleteSpecific(4);
        l1.display();
    }
}