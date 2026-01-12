class Revision2{
    Node head;
    class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data=data;
            this.next=this.prev=null;
        }
    }
    public void addFirst(int data){
        Node newNode=new Node(data);
        if(head == null){
            head=newNode;
            return;
        }
        head.prev=newNode;
        newNode.next=head;
        head=newNode;
    }
    
    public void printList(){
        Node curr=head;
        while(curr!=null){
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Revision2 dll=new Revision2();
        dll.addFirst(10);
        dll.addFirst(20);
        dll.addFirst(30);
        dll.printList();
    }
}