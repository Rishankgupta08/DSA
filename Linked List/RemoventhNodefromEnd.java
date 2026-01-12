class RemoventhNodefromEnd {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    Node head;
    public void insert(int data){
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
    public Node remove(Node head,int n){
        int l=0;
        Node temp=head;
        while(temp!=null){
            l++;
            temp=temp.next;
        }
        temp=head;
        if(n==l){
            return head.next;
        }
        for(int i=1;i<l-n;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
    }
    public static void main(String[] args) {
        RemoventhNodefromEnd list=new RemoventhNodefromEnd();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        int n=2;
        Node newHead=list.remove(list.head,n);
        Node temp=newHead;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
}