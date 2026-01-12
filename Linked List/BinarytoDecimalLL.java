class BinarytoDecimalLL{
    static class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
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
    public int convert(){
        int res=0;
        while(head!=null){
            res=(res<<1)+head.data;
            head=head.next;
        }
        return res;
    }
    public static void main(String[] args) {
        BinarytoDecimalLL list=new BinarytoDecimalLL();
        list.insert(1);
        list.insert(0);
        list.insert(1);
        list.insert(1);
        list.insert(0);
        System.out.println("Decimal value: "+list.convert());
    }
}